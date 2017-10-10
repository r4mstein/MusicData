package r4mstein.ua.musicdata.screens.chart.top_tracks;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;
import r4mstein.ua.musicdata.R;
import r4mstein.ua.musicdata.screens.base.BaseFragment;
import r4mstein.ua.musicdata.screens.chart.top_tracks.adapter.TopTracksAdapter;
import r4mstein.ua.musicdata.screens.dialogs.LoadingDialog;
import r4mstein.ua.musicdata.screens.main.MainActivity;
import r4mstein.ua.musicdata.utils.Logger;
import r4mstein.ua.musicdata.utils.endless.EndlessScrollListener;

public class TopTracksFragment extends BaseFragment<MainActivity> implements TopTracksContract.TopTracksView {

    @Inject
    TopTracksPresenter mPresenter;
    @Inject
    Logger mLogger;

    private RecyclerView mRecyclerView;
    private TopTracksAdapter mAdapter;
    private LoadingDialog mLoadingDialog;

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_top_tracks;
    }

    @Override
    protected void findUI(View rootView) {
        mRecyclerView = rootView.findViewById(R.id.rv_FTT);
    }

    @Override
    protected void setupUI() {
        setupRecyclerView();
    }

    @Override
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter.subscribe();
    }

    @Override
    public void onStart() {
        super.onStart();
        getActivityGeneric().getSupportActionBar().setSubtitle("Chart Top Tracks");
    }

    private void setupRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(layoutManager);

        mAdapter = new TopTracksAdapter(getContext());
        mAdapter.setClickListener((track, name) -> mLogger.d("itemClicked: name: " + name + ", track: " + track));
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addOnScrollListener(new EndlessScrollListener(layoutManager, () -> {
            mPresenter.getNextPage();
            return true;
        }));
    }

    @Override
    public TopTracksAdapter getAdapter() {
        return mAdapter;
    }

    @Override
    public void progressDialogShow() {
        if (mLoadingDialog == null) mLoadingDialog = new LoadingDialog();

        if (!mLoadingDialog.isShowing()) mLoadingDialog.show(
                getActivityGeneric().getSupportFragmentManager(), "progress dialog");
    }

    @Override
    public void progressDialogHide() {
        if (mLoadingDialog != null && mLoadingDialog.isShowing() && !mLoadingDialog.isDismiss())
            mLoadingDialog.dismiss();
    }
}
