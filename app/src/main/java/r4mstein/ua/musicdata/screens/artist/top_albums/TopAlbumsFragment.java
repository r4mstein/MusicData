package r4mstein.ua.musicdata.screens.artist.top_albums;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;
import r4mstein.ua.musicdata.R;
import r4mstein.ua.musicdata.screens.artist.top_albums.adapter.TopAlbumsAdapter;
import r4mstein.ua.musicdata.screens.base.BaseFragment;
import r4mstein.ua.musicdata.screens.detail.DetailActivity;
import r4mstein.ua.musicdata.utils.Logger;
import r4mstein.ua.musicdata.utils.endless.EndlessScrollListener;

public class TopAlbumsFragment extends BaseFragment<DetailActivity> implements TopAlbumsContract.TopAlbumsView {

    public static final String ARTIST_NAME = "artist_name";

    @Inject
    TopAlbumsPresenter mPresenter;
    @Inject
    Logger mLogger;

    private RecyclerView mRecyclerView;
    private TopAlbumsAdapter mAdapter;
    private Toolbar mToolbar;
    private String mArtist;

    public static TopAlbumsFragment newInstance(String artist) {
        TopAlbumsFragment fragment = new TopAlbumsFragment();

        Bundle bundle = new Bundle();
        bundle.putString(ARTIST_NAME, artist);
        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_artist_albums;
    }

    @Override
    protected void findUI(View rootView) {
        mToolbar = rootView.findViewById(R.id.toolbar_FAA);
        mRecyclerView = rootView.findViewById(R.id.rv_FAA);
    }

    @Override
    protected void setupUI() {
        mArtist = getArguments().getString(ARTIST_NAME);
        mToolbar.setTitle("Top albums: " + mArtist);

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
        mPresenter.setArtist(mArtist);
        mPresenter.subscribe();
    }

    private void setupRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(layoutManager);

        mAdapter = new TopAlbumsAdapter(getContext());
        mAdapter.setClickListener(album -> mLogger.d("album: " + album));
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addOnScrollListener(new EndlessScrollListener(layoutManager, () -> {
            mPresenter.getNextPage(mArtist);
            return true;
        }));
    }

    @Override
    public TopAlbumsAdapter getAdapter() {
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
