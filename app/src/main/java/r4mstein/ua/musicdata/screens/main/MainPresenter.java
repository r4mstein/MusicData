package r4mstein.ua.musicdata.screens.main;

import javax.inject.Inject;

import r4mstein.ua.musicdata.screens.base.BasePresenter;

public class MainPresenter extends BasePresenter implements MainContract.MainPresenter {

    private static final String TAG = "MainPresenter";

    private MainContract.MainView mMainView;

    @Inject
    public MainPresenter(MainContract.MainView mainView) {
        mMainView = mainView;
    }

    @Override
    protected void subscribe() {

    }

    @Override
    protected void unsubscribe() {

    }
}
