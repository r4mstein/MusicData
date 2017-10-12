package r4mstein.ua.musicdata.screens.detail;

import javax.inject.Inject;

import r4mstein.ua.musicdata.screens.base.BasePresenter;

public class DetailPresenter extends BasePresenter implements DetailContract.DetailPresenter {

    private DetailContract.DetailView mDetailView;

    @Inject
    public DetailPresenter(DetailContract.DetailView detailView) {
        mDetailView = detailView;
    }

    @Override
    protected void subscribe() {

    }

    @Override
    protected void unsubscribe() {

    }
}
