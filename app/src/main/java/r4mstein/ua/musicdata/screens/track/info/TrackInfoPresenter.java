package r4mstein.ua.musicdata.screens.track.info;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.schedulers.Schedulers;
import r4mstein.ua.musicdata.data.models.response.track_info.Tag;
import r4mstein.ua.musicdata.data.models.response.track_info.TrackInfo;
import r4mstein.ua.musicdata.data.providers.TrackProvider;
import r4mstein.ua.musicdata.screens.base.BasePresenter;
import r4mstein.ua.musicdata.utils.Logger;

import static r4mstein.ua.musicdata.utils.Constants.API_KEY;
import static r4mstein.ua.musicdata.utils.Constants.FORMAT;
import static r4mstein.ua.musicdata.utils.Constants.REQUEST_TRACK_INFO;

public class TrackInfoPresenter extends BasePresenter implements TrackInfoContract.TrackInfoPresenter {

    @Inject
    TrackProvider mProvider;
    @Inject
    Logger mLogger;

    private TrackInfoContract.TrackInfoView mView;

    @Inject
    public TrackInfoPresenter(TrackInfoContract.TrackInfoView view) {
        mView = view;
    }

    @Override
    protected void subscribe() {

    }

    @Override
    protected void unsubscribe() {

    }

    public void getTrackInfo(String artist, String track) {
        mProvider.getTrackInfo(REQUEST_TRACK_INFO, artist, API_KEY, track, FORMAT)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(disposable -> mView.progressDialogShow())
                .doAfterTerminate(() -> mView.progressDialogHide())
                .subscribe(
                        this::processingResponse,
                        throwable -> {
                            mLogger.d(throwable.getMessage());
                            mView.progressDialogHide();
                        }
                );
    }

    private void processingResponse(@NonNull TrackInfo trackInfo) {
        if (trackInfo.getTrack().getToptags() != null) loadTags(trackInfo);
        else mView.setTags(null);

        if (trackInfo.getTrack().getAlbum() != null)
            mView.loadPhoto(trackInfo.getTrack().getAlbum().getImage().get(3).getText());
        else mView.loadPhoto("");

        mView.setListeners(trackInfo.getTrack().getListeners());
        mView.setPlayCount(trackInfo.getTrack().getPlaycount());
        mView.setDuration(trackInfo.getTrack().getDuration());

        if (trackInfo.getTrack().getWiki() != null) {
            mView.setBio(trackInfo.getTrack().getWiki().getContent());
        } else mView.setBio(null);
    }

    private void loadTags(@NonNull TrackInfo trackInfo) {
        List<String> textTags = new ArrayList<>();
        List<Tag> tags = trackInfo.getTrack().getToptags().getTag();
        for (Tag tag : tags) {
            textTags.add(tag.getName());
        }
        mView.setTags(textTags);
    }
}
