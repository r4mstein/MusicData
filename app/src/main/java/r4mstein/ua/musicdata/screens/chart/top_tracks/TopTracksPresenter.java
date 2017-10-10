package r4mstein.ua.musicdata.screens.chart.top_tracks;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.schedulers.Schedulers;
import r4mstein.ua.musicdata.data.models.TopTracksModel;
import r4mstein.ua.musicdata.data.models.response.chart_top_tracks.ChartTopTracks;
import r4mstein.ua.musicdata.data.models.response.chart_top_tracks.Track;
import r4mstein.ua.musicdata.data.providers.ChartProvider;
import r4mstein.ua.musicdata.screens.base.BasePresenter;
import r4mstein.ua.musicdata.utils.Logger;

import static r4mstein.ua.musicdata.utils.Constants.API_KEY;
import static r4mstein.ua.musicdata.utils.Constants.FORMAT;
import static r4mstein.ua.musicdata.utils.Constants.LIMIT;
import static r4mstein.ua.musicdata.utils.Constants.REQUEST_CHART_TT;

public class TopTracksPresenter extends BasePresenter implements TopTracksContract.TopTracksPresenter {

    @Inject
    ChartProvider mChartProvider;
    @Inject
    Logger mLogger;

    private TopTracksContract.TopTracksView mView;
    private long current_page;
    private long total_pages;

    @Inject
    public TopTracksPresenter(TopTracksContract.TopTracksView view) {
        mView = view;
    }

    @Override
    protected void subscribe() {
        current_page = 1;
        getTopTracks(current_page);
    }

    @Override
    protected void unsubscribe() {

    }

    @Override
    public void getNextPage() {
        if (current_page < total_pages) getTopTracks(current_page + 1);
    }

    private void getTopTracks(long pageNumber) {
        mChartProvider.getTopTracks(REQUEST_CHART_TT, API_KEY, LIMIT, pageNumber, FORMAT)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(disposable -> mView.progressDialogShow())
                .doAfterTerminate(() -> mView.progressDialogHide())
                .subscribe(
                        response -> processingResponse(pageNumber, response),
                        throwable -> {
                            mLogger.d(throwable.getMessage());
                            mView.progressDialogHide();
                        }
                );
    }

    private void processingResponse(long pageNumber, ChartTopTracks response) {
        current_page = pageNumber;
        total_pages = Long.parseLong(response.getTracks().getAttr().getTotalPages());

        List<TopTracksModel> dataModels = getData(response);

        if (current_page == 1) mView.getAdapter().setModels(dataModels);
        else mView.getAdapter().addModels(dataModels);
    }

    @android.support.annotation.NonNull
    private List<TopTracksModel> getData(@NonNull ChartTopTracks response) {
        List<Track> artistsList = response.getTracks().getTrack();
        List<TopTracksModel> dataModels = new ArrayList<>();

        for (Track track : artistsList) {
            TopTracksModel dataModel = new TopTracksModel();

            dataModel.setName(track.getArtist().getName());
            dataModel.setTrack(track.getName());
            dataModel.setPhotoURL(track.getImage().get(2).getText());

            dataModels.add(dataModel);
        }

        return dataModels;
    }
}
