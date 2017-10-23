package r4mstein.ua.musicdata.screens.artist.top_albums;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.schedulers.Schedulers;
import r4mstein.ua.musicdata.data.models.TopAlbumsModel;
import r4mstein.ua.musicdata.data.models.response.artist_albums.Album;
import r4mstein.ua.musicdata.data.models.response.artist_albums.ArtistTopAlbums;
import r4mstein.ua.musicdata.data.providers.ArtistProvider;
import r4mstein.ua.musicdata.screens.base.BasePresenter;
import r4mstein.ua.musicdata.utils.Logger;

import static r4mstein.ua.musicdata.utils.Constants.API_KEY;
import static r4mstein.ua.musicdata.utils.Constants.FORMAT;
import static r4mstein.ua.musicdata.utils.Constants.LIMIT;
import static r4mstein.ua.musicdata.utils.Constants.REQUEST_ARTIST_ALBUMS;

public class TopAlbumsPresenter extends BasePresenter implements TopAlbumsContract.TopAlbumsPresenter {

    @Inject
    ArtistProvider mProvider;
    @Inject
    Logger mLogger;

    private TopAlbumsContract.TopAlbumsView mView;
    private long current_page;
    private long total_pages;
    private String artist;

    @Inject
    public TopAlbumsPresenter(TopAlbumsContract.TopAlbumsView view) {
        mView = view;
    }

    @Override
    protected void subscribe() {
        current_page = 1;
        getTopAlbums(current_page, artist);
    }

    @Override
    protected void unsubscribe() {

    }

    @Override
    public void getNextPage(String artist) {
        if (current_page < total_pages) getTopAlbums(current_page + 1, artist);
    }

    private void getTopAlbums(long pageNumber, String artist) {
        mProvider.getArtistAlbums(REQUEST_ARTIST_ALBUMS, artist, API_KEY, LIMIT, pageNumber, FORMAT)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(disposable -> mView.progressDialogShow())
                .doAfterTerminate(() -> mView.progressDialogHide())
                .subscribe(
                        response -> processingResponse(response, pageNumber),
                        throwable -> {
                            mLogger.d(throwable.getMessage());
                            mView.progressDialogHide();
                        }
                );
    }

    private void processingResponse(@NonNull ArtistTopAlbums response, long pageNumber) {
        current_page = pageNumber;
        total_pages = Long.parseLong(response.getTopalbums().getAttr().getTotalPages());

        List<TopAlbumsModel> dataModels = getData(response);

        if (current_page == 1) mView.getAdapter().setModels(dataModels);
        else mView.getAdapter().addModels(dataModels);
    }

    private List<TopAlbumsModel> getData(ArtistTopAlbums response) {
        List<Album> albumList = response.getTopalbums().getAlbum();
        List<TopAlbumsModel> resultData = new ArrayList<>();

        for (Album album : albumList) {
            TopAlbumsModel model = new TopAlbumsModel();

            model.setAlbum(album.getName());
            model.setPlayCount(String.valueOf(album.getPlaycount()));
            model.setPhotoURL(album.getImage().get(2).getText());

            resultData.add(model);
        }
        return resultData;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
}
