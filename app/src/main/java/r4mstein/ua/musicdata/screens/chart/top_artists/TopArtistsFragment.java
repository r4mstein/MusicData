package r4mstein.ua.musicdata.screens.chart.top_artists;

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
import r4mstein.ua.musicdata.screens.chart.top_artists.adapter.TopArtistsAdapter;
import r4mstein.ua.musicdata.screens.detail.DetailActivity;
import r4mstein.ua.musicdata.screens.dialogs.MenuDialog;
import r4mstein.ua.musicdata.screens.dialogs.MenuDialogListener;
import r4mstein.ua.musicdata.screens.main.MainActivity;
import r4mstein.ua.musicdata.utils.Logger;
import r4mstein.ua.musicdata.utils.endless.EndlessScrollListener;

public class TopArtistsFragment extends BaseFragment<MainActivity> implements TopArtistsContract.TopArtistsView {

    @Inject
    TopArtistsPresenter mPresenter;
    @Inject
    Logger mLogger;

    private RecyclerView mRecyclerView;
    private TopArtistsAdapter mAdapter;

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_top_artists;
    }

    @Override
    protected void findUI(View rootView) {
        mRecyclerView = rootView.findViewById(R.id.rv_FTA);
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
        getActivityGeneric().getSupportActionBar().setSubtitle("Chart Top Artists");
    }

    private void setupRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(layoutManager);

        mAdapter = new TopArtistsAdapter(getContext());
        mAdapter.setClickListener((name, position) -> {
            mLogger.d("itemClicked: name: " + name);
            showMenuDialog(name);
        });
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addOnScrollListener(new EndlessScrollListener(layoutManager, () -> {
            mPresenter.getNextPage();
            return true;
        }));
    }

    private void showMenuDialog(String name) {
        MenuDialog menuDialog = MenuDialog.newInstance(name, getString(R.string.artist_info_DM),
                getString(R.string.similar_artists_DM), View.VISIBLE, View.VISIBLE);
        menuDialog.setListener(new MenuDialogListener() {
            @Override
            public void infoClicked() {
                mLogger.d("infoClicked");
                startActivity(new Intent(getActivityGeneric(), DetailActivity.class));
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
        menuDialog.show(TopArtistsFragment.this.getFragmentManager(), "MenuDialog");
    }

    @Override
    public TopArtistsAdapter getAdapter() {
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
