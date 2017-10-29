package r4mstein.ua.musicdata.screens.artist.similar;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.List;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;
import r4mstein.ua.musicdata.R;
import r4mstein.ua.musicdata.data.models.ArtistSimilarModel;
import r4mstein.ua.musicdata.screens.artist.similar.adapter.SimilarArtistsAdapter;
import r4mstein.ua.musicdata.screens.base.BaseFragment;
import r4mstein.ua.musicdata.screens.detail.DetailActivity;
import r4mstein.ua.musicdata.utils.Logger;

public class SimilarArtistsFragment extends BaseFragment<DetailActivity> implements SimilarArtistsContract.SimilarArtistsView {

    public static final String ARTIST_NAME = "artist_name";

    @Inject
    SimilarArtistsPresenter mPresenter;
    @Inject
    Logger mLogger;

    private String mArtist;
    private Toolbar mToolbar;
    private RecyclerView mRecyclerView;
    private SimilarArtistsAdapter mAdapter;

    public static SimilarArtistsFragment newInstance(String artist) {
        SimilarArtistsFragment fragment = new SimilarArtistsFragment();

        Bundle bundle = new Bundle();
        bundle.putString(ARTIST_NAME, artist);
        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_artist_similar;
    }

    @Override
    protected void findUI(View rootView) {
        mToolbar = rootView.findViewById(R.id.toolbar_FAS);
        mRecyclerView = rootView.findViewById(R.id.rv_FAS);
    }

    @Override
    protected void setupUI() {
        mArtist = getArguments().getString(ARTIST_NAME);
        mToolbar.setTitle("Similar to: " + mArtist);
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

        mAdapter = new SimilarArtistsAdapter(getContext());
        mAdapter.setClickListener(artist -> mLogger.d("itemClicked: artist: " + artist));
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void progressDialogShow() {
        progressDialogBaseShow();
    }

    @Override
    public void progressDialogHide() {
        progressDialogBaseHide();
    }

    @Override
    public void setData(List<ArtistSimilarModel> models) {
        mAdapter.setModels(models);
    }
}
