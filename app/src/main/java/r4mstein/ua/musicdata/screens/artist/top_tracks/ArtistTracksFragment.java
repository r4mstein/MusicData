package r4mstein.ua.musicdata.screens.artist.top_tracks;

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
import r4mstein.ua.musicdata.screens.artist.top_tracks.adapter.ArtistTracksAdapter;
import r4mstein.ua.musicdata.screens.base.BaseFragment;
import r4mstein.ua.musicdata.screens.detail.DetailActivity;
import r4mstein.ua.musicdata.utils.Logger;
import r4mstein.ua.musicdata.utils.endless.EndlessScrollListener;

public class ArtistTracksFragment extends BaseFragment<DetailActivity> implements ArtistTracksContract.ArtistTracksView {

    public static final String ARTIST_NAME = "artist_name";

    @Inject
    ArtistTracksPresenter mPresenter;
    @Inject
    Logger mLogger;

    private String mArtist;
    private Toolbar mToolbar;
    private RecyclerView mRecyclerView;
    private ArtistTracksAdapter mAdapter;

    public static ArtistTracksFragment newInstance(String artist) {
        ArtistTracksFragment fragment = new ArtistTracksFragment();

        Bundle bundle = new Bundle();
        bundle.putString(ARTIST_NAME, artist);
        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_artist_tracks;
    }

    @Override
    protected void findUI(View rootView) {
        mToolbar = rootView.findViewById(R.id.toolbar_FAT);
        mRecyclerView = rootView.findViewById(R.id.rv_FAT);
    }

    @Override
    protected void setupUI() {
        mArtist = getArguments().getString(ARTIST_NAME);
        mToolbar.setTitle("Top tracks: " + mArtist);
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

        mAdapter = new ArtistTracksAdapter(getContext());
        mAdapter.setListener(track -> mLogger.d("itemClicked: track: " + track));
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addOnScrollListener(new EndlessScrollListener(layoutManager, () -> {
            mPresenter.getNextPage(mArtist);
            return true;
        }));
    }

    @Override
    public ArtistTracksAdapter getAdapter() {
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
