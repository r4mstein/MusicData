package r4mstein.ua.musicdata.screens.chart.top_tracks;

import android.content.Context;
import android.content.Intent;
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
import r4mstein.ua.musicdata.screens.detail.DetailActivity;
import r4mstein.ua.musicdata.screens.dialogs.MenuDialog;
import r4mstein.ua.musicdata.screens.dialogs.MenuDialogListener;
import r4mstein.ua.musicdata.screens.main.MainActivity;
import r4mstein.ua.musicdata.utils.Logger;
import r4mstein.ua.musicdata.utils.endless.EndlessScrollListener;

import static r4mstein.ua.musicdata.utils.Constants.TRACK_INFO_ARTIST;
import static r4mstein.ua.musicdata.utils.Constants.TRACK_INFO_NAME;

public class TopTracksFragment extends BaseFragment<MainActivity> implements TopTracksContract.TopTracksView {

    @Inject
    TopTracksPresenter mPresenter;
    @Inject
    Logger mLogger;

    private RecyclerView mRecyclerView;
    private TopTracksAdapter mAdapter;

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
        mAdapter.setClickListener((track, name) -> {
            mLogger.d("itemClicked: name: " + name + ", track: " + track);
            showMenuDialog(track, name);
        });
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addOnScrollListener(new EndlessScrollListener(layoutManager, () -> {
            mPresenter.getNextPage();
            return true;
        }));
    }

    private void showMenuDialog(String track, String artist) {
        MenuDialog menuDialog = MenuDialog.newInstance(track, getString(R.string.track_info_DM),
                getString(R.string.similar_tracks_DM), View.GONE, View.GONE);
        menuDialog.setListener(new MenuDialogListener() {
            @Override
            public void infoClicked() {
                mLogger.d("infoClicked");
                goToDetail(TRACK_INFO_NAME, track, TRACK_INFO_ARTIST, artist);
            }

            @Override
            public void albumsClicked() {
                mLogger.d("albumsClicked");
            }

            @Override
            public void tracksClicked() {
                mLogger.d("tracksClicked");
            }

            @Override
            public void similarClicked() {
                mLogger.d("similarClicked");
            }
        });
        menuDialog.show(getFragmentManager(), "MenuDialog");
    }

    private void goToDetail(String bundleConstTrack, String track, String bundleConstArtist, String artist) {
        Intent intent = new Intent(getActivityGeneric(), DetailActivity.class);
        intent.putExtra(bundleConstTrack, track);
        intent.putExtra(bundleConstArtist, artist);
        startActivity(intent);
    }

    @Override
    public TopTracksAdapter getAdapter() {
        return mAdapter;
    }

    @Override
    public void progressDialogShow() {
        progressDialogBaseShow();
    }

    @Override
    public void progressDialogHide() {
        progressDialogBaseHide();
    }
}
