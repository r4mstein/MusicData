package r4mstein.ua.musicdata.screens.artist.info;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.schedulers.Schedulers;
import r4mstein.ua.musicdata.R;
import r4mstein.ua.musicdata.data.models.response.artist_info.ArtistInfo;
import r4mstein.ua.musicdata.data.models.response.artist_info.Tag;
import r4mstein.ua.musicdata.data.providers.ArtistProvider;
import r4mstein.ua.musicdata.screens.base.BasePresenter;
import r4mstein.ua.musicdata.utils.Logger;

import static r4mstein.ua.musicdata.utils.Constants.API_KEY;
import static r4mstein.ua.musicdata.utils.Constants.FORMAT;
import static r4mstein.ua.musicdata.utils.Constants.REQUEST_ARIST_INFO;

public class ArtistInfoPresenter extends BasePresenter implements ArtistInfoContract.ArtistInfoPresenter {

    @Inject
    ArtistProvider mProvider;
    @Inject
    Logger mLogger;

    private ArtistInfoContract.ArtistInfoView mView;

    @Inject
    public ArtistInfoPresenter(ArtistInfoContract.ArtistInfoView view) {
        mView = view;
    }

    @Override
    protected void subscribe() {

    }

    @Override
    protected void unsubscribe() {

    }

    public void getArtistInfo(String artist) {
        mProvider.getArtistInfo(REQUEST_ARIST_INFO, artist, API_KEY, FORMAT)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(disposable -> mView.progressDialogShow())
                .doAfterTerminate(() -> mView.progressDialogHide())
                .subscribe(
                        this::processingResponse,
                        throwable -> mLogger.d(throwable.getMessage())
                );
    }

    private void processingResponse(@NonNull ArtistInfo artistInfo) {
        loadPhoto(artistInfo);
        loadTags(artistInfo);

        mView.getTvListeners().setText(String.format("Listeners: %s",
                artistInfo.getArtist().getStats().getListeners()));

        mView.getTvBio().setText(artistInfo.getArtist().getBio().getContent());
    }

    private void loadTags(@NonNull ArtistInfo artistInfo) {
        List<String> textTags = new ArrayList<>();
        List<Tag> tags = artistInfo.getArtist().getTags().getTag();
        for (Tag tag : tags) {
            textTags.add(tag.getName());
        }
        mView.getAdapter().setModels(textTags);
    }

    private void loadPhoto(@NonNull ArtistInfo artistInfo) {
        String photo = artistInfo.getArtist().getImage().get(4).getText();

        Glide.with(mView.getFragmContext())
                .load(photo)
                .error(R.drawable.bg)
                .placeholder(R.drawable.bg)
                .into(mView.getIvPhoto());
    }
}
