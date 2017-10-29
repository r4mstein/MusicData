package r4mstein.ua.musicdata.screens.artist.top_tracks;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.schedulers.Schedulers;
import r4mstein.ua.musicdata.data.models.ArtistTracksModel;
import r4mstein.ua.musicdata.data.models.response.artist_tracks.ArtistTopTracks;
import r4mstein.ua.musicdata.data.models.response.artist_tracks.Track;
import r4mstein.ua.musicdata.data.providers.ArtistProvider;
import r4mstein.ua.musicdata.screens.base.BasePresenter;
import r4mstein.ua.musicdata.utils.Logger;

import static r4mstein.ua.musicdata.utils.Constants.API_KEY;
import static r4mstein.ua.musicdata.utils.Constants.FORMAT;
import static r4mstein.ua.musicdata.utils.Constants.LIMIT;
import static r4mstein.ua.musicdata.utils.Constants.REQUEST_ARTIST_TRACKS;

public class ArtistTracksPresenter extends BasePresenter implements ArtistTracksContract.ArtistTracksPresenter {

    @Inject
    ArtistProvider mProvider;
    @Inject
    Logger mLogger;

    private ArtistTracksContract.ArtistTracksView mView;
    private long current_page;
    private long total_pages;
    private String artist;

    @Inject
    public ArtistTracksPresenter(ArtistTracksContract.ArtistTracksView view) {
        mView = view;
    }

    @Override
    protected void subscribe() {
        current_page = 1;
        getTopTracks(current_page, artist);
    }

    @Override
    protected void unsubscribe() {

    }

    @Override
    public void getNextPage(String artist) {
        if (current_page < total_pages) getTopTracks(current_page + 1, artist);
    }

    private void getTopTracks(long pageNumber, String artist) {
        mProvider.getArtistTracks(REQUEST_ARTIST_TRACKS, artist, API_KEY, LIMIT, pageNumber, FORMAT)
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

    private void processingResponse(@NonNull ArtistTopTracks response, long pageNumber) {
        current_page = pageNumber;
        total_pages = Long.parseLong(response.getToptracks().getAttr().getTotalPages());

        List<ArtistTracksModel> dataModels = getData(response);

        if (current_page == 1) mView.getAdapter().setModels(dataModels);
        else mView.getAdapter().addModels(dataModels);
    }

    private List<ArtistTracksModel> getData(ArtistTopTracks response) {
        List<Track> trackList = response.getToptracks().getTrack();
        List<ArtistTracksModel> resultData = new ArrayList<>();

        for (Track track : trackList) {
            ArtistTracksModel model = new ArtistTracksModel();

            model.setTrack(track.getName());
            model.setPlayCount(String.valueOf(track.getPlaycount()));
            model.setPhotoURL(track.getImage().get(2).getText());
            model.setRank(track.getAttr().getRank());

            resultData.add(model);
        }
        return resultData;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
}
