package r4mstein.ua.musicdata.screens.artist.similar;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.schedulers.Schedulers;
import r4mstein.ua.musicdata.data.models.ArtistSimilarModel;
import r4mstein.ua.musicdata.data.models.response.artist_similar.Artist;
import r4mstein.ua.musicdata.data.models.response.artist_similar.ArtistSimilar;
import r4mstein.ua.musicdata.data.providers.ArtistProvider;
import r4mstein.ua.musicdata.screens.base.BasePresenter;
import r4mstein.ua.musicdata.utils.Logger;

import static r4mstein.ua.musicdata.utils.Constants.API_KEY;
import static r4mstein.ua.musicdata.utils.Constants.FORMAT;
import static r4mstein.ua.musicdata.utils.Constants.REQUEST_ARTIST_SIMILAR;

public class SimilarArtistsPresenter extends BasePresenter implements SimilarArtistsContract.SimilarArtistsPresenter {

    @Inject
    ArtistProvider mProvider;
    @Inject
    Logger mLogger;

    private SimilarArtistsContract.SimilarArtistsView mView;
    private String mArtist;

    @Inject
    public SimilarArtistsPresenter(SimilarArtistsContract.SimilarArtistsView view) {
        mView = view;
    }

    @Override
    protected void subscribe() {
        getSimilarArtists(mArtist);
    }

    @Override
    protected void unsubscribe() {

    }

    private void getSimilarArtists(String artist) {
        mProvider.getSimilarArtists(REQUEST_ARTIST_SIMILAR, artist, API_KEY, FORMAT)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(disposable -> mView.progressDialogShow())
                .doAfterTerminate(() -> mView.progressDialogHide())
                .subscribe(
                        this::getData,
                        throwable -> mLogger.d(throwable.getMessage())
                );
    }

    private void getData(@NonNull ArtistSimilar response) {
        List<ArtistSimilarModel> resultData = new ArrayList<>();
        List<Artist> artistList = response.getArtists().getArtist();

        for (Artist model : artistList) {
            ArtistSimilarModel similarModel = new ArtistSimilarModel();
            similarModel.setPhotoUrl(String.valueOf(model.getImage().get(2).getText()));
            similarModel.setArtist(model.getName());
            similarModel.setMatch(model.getMatch());

            resultData.add(similarModel);
        }

        mView.setData(resultData);
    }

    public void setArtist(String artist) {
        mArtist = artist;
    }
}
