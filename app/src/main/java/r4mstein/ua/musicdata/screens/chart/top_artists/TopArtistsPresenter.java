package r4mstein.ua.musicdata.screens.chart.top_artists;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.schedulers.Schedulers;
import r4mstein.ua.musicdata.data.models.TopArtistsModel;
import r4mstein.ua.musicdata.data.models.respons.ChartTopArtists.Artist;
import r4mstein.ua.musicdata.data.models.respons.ChartTopArtists.ChartTopArtists;
import r4mstein.ua.musicdata.data.providers.ChartProvider;
import r4mstein.ua.musicdata.screens.base.BasePresenter;

import static r4mstein.ua.musicdata.utils.Constants.API_KEY;
import static r4mstein.ua.musicdata.utils.Constants.FORMAT;
import static r4mstein.ua.musicdata.utils.Constants.LIMIT;
import static r4mstein.ua.musicdata.utils.Constants.REQUEST_CHART_TA;

public class TopArtistsPresenter extends BasePresenter implements TopArtistsContract.TopArtistsPresenter {

    private static final String TAG = "TopArtistsPresenter";
    private TopArtistsContract.TopArtistsView mView;
    private ChartProvider mChartProvider = new ChartProvider();

    private long current_page;
    private long total_pages;

    @Inject
    public TopArtistsPresenter(TopArtistsContract.TopArtistsView view) {
        mView = view;
    }

    @Override
    protected void subscribe() {
        current_page = 1;
        getTopArtists(current_page);
    }

    @Override
    protected void unsubscribe() {

    }

    @Override
    public void getNextPage() {
        if (current_page < total_pages) getTopArtists(current_page + 1);
    }

    private void getTopArtists(long pageNumber) {
        mChartProvider.getTopArtists(REQUEST_CHART_TA, API_KEY, LIMIT, pageNumber, FORMAT)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(disposable -> mView.progressDialogShow())
                .doAfterTerminate(() -> mView.progressDialogHide())
                .subscribe(
                        response -> processingResponse(pageNumber, response),
                        throwable -> {
                            Log.d(TAG, throwable.getMessage());
                            mView.progressDialogHide();
                        }
                );
    }

    private void processingResponse(long pageNumber, ChartTopArtists response) {
        current_page = pageNumber;
        total_pages = Long.parseLong(response.getArtists().getAttr().getTotalPages());

        List<TopArtistsModel> dataModels = getData(response);

        if (current_page == 1) mView.getAdapter().setModels(dataModels);
        else mView.getAdapter().addModels(dataModels);
    }

    @android.support.annotation.NonNull
    private List<TopArtistsModel> getData(@NonNull ChartTopArtists response) {
        List<Artist> artistsList = response.getArtists().getArtist();
        List<TopArtistsModel> dataModels = new ArrayList<>();

        for (Artist artist : artistsList) {
            TopArtistsModel dataModel = new TopArtistsModel();

            dataModel.setName(artist.getName());
            dataModel.setPhotoURL(artist.getImage().get(2).getText());

            dataModels.add(dataModel);
        }

        return dataModels;
    }
}
