package r4mstein.ua.musicdata.screens.artist.info;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;
import r4mstein.ua.musicdata.R;
import r4mstein.ua.musicdata.screens.artist.info.adapter.TagAdapter;
import r4mstein.ua.musicdata.screens.base.BaseFragment;
import r4mstein.ua.musicdata.screens.detail.DetailActivity;
import r4mstein.ua.musicdata.utils.Logger;

public class ArtistInfoFragment extends BaseFragment<DetailActivity> implements ArtistInfoContract.ArtistInfoView {

    public static final String ARTIST_NAME = "artist_name";

    @Inject
    ArtistInfoPresenter mPresenter;
    @Inject
    Logger mLogger;

    private Toolbar mToolbar;
    private ImageView ivPhoto;
    private TextView tvListeners;
    private TextView tvBio;
    private RecyclerView rvTags;
    private TagAdapter mAdapter;

    public static ArtistInfoFragment newInstance(String artist) {
        ArtistInfoFragment fragment = new ArtistInfoFragment();

        Bundle bundle = new Bundle();
        bundle.putString(ARTIST_NAME, artist);
        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_artist_info;
    }

    @Override
    protected void findUI(View rootView) {
        mToolbar = rootView.findViewById(R.id.toolbar_FAI);
        ivPhoto = rootView.findViewById(R.id.iv_photo_FAI);
        tvListeners = rootView.findViewById(R.id.tv_listeners_FAI);
        tvBio = rootView.findViewById(R.id.tv_bio_FAI);
        rvTags = rootView.findViewById(R.id.rv_tags_FAI);
    }

    @Override
    protected void setupUI() {
        mToolbar.setTitle(getArguments().getString(ARTIST_NAME));
        setupRecyclerView();
        mPresenter.getArtistInfo(getArguments().getString(ARTIST_NAME));
    }

    private void setupRecyclerView() {
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 3);
        rvTags.setLayoutManager(layoutManager);

        mAdapter = new TagAdapter();
        mAdapter.setClickListener(tag -> mLogger.d("tagClicked: " + tag));
        rvTags.setAdapter(mAdapter);
    }

    @Override
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
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
    public TagAdapter getAdapter() {
        return mAdapter;
    }

    @Override
    public ImageView getIvPhoto() {
        return ivPhoto;
    }

    @Override
    public TextView getTvListeners() {
        return tvListeners;
    }

    @Override
    public TextView getTvBio() {
        return tvBio;
    }

    @Override
    public Context getFragmContext() {
        return getContext();
    }
}
