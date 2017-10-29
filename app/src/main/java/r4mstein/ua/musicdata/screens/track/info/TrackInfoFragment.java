package r4mstein.ua.musicdata.screens.track.info;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;
import r4mstein.ua.musicdata.R;
import r4mstein.ua.musicdata.screens.base.BaseFragment;
import r4mstein.ua.musicdata.screens.detail.DetailActivity;
import r4mstein.ua.musicdata.screens.track.info.adapter.TagAdapter;
import r4mstein.ua.musicdata.utils.Logger;

public class TrackInfoFragment extends BaseFragment<DetailActivity> implements TrackInfoContract.TrackInfoView {

    public static final String ARTIST_NAME = "artist_name";
    public static final String TRACK_NAME = "track_name";

    @Inject
    TrackInfoPresenter mPresenter;
    @Inject
    Logger mLogger;

    private Toolbar mToolbar;
    private ImageView ivPhoto;
    private TextView tvListeners;
    private TextView tvPlayCount;
    private TextView tvDuration;
    private TextView tvTrack;
    private TextView tvBio;
    private RecyclerView rvTags;
    private TagAdapter mAdapter;

    public static TrackInfoFragment newInstance(String artist, String track) {
        TrackInfoFragment fragment = new TrackInfoFragment();

        Bundle bundle = new Bundle();
        bundle.putString(ARTIST_NAME, artist);
        bundle.putString(TRACK_NAME, track);
        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_track_info;
    }

    @Override
    protected void findUI(View rootView) {
        mToolbar = rootView.findViewById(R.id.toolbar_FTI);
        ivPhoto = rootView.findViewById(R.id.iv_photo_FTI);
        tvListeners = rootView.findViewById(R.id.tv_listeners_FTI);
        tvPlayCount = rootView.findViewById(R.id.tv_play_count_FTI);
        tvDuration = rootView.findViewById(R.id.tv_duration_FTI);
        tvTrack = rootView.findViewById(R.id.tv_track_FTI);
        tvBio = rootView.findViewById(R.id.tv_bio_FTI);
        rvTags = rootView.findViewById(R.id.rv_tags_FTI);
    }

    @Override
    protected void setupUI() {
        mToolbar.setTitle(getArguments().getString(ARTIST_NAME));
        tvTrack.setText(getArguments().getString(TRACK_NAME));
        setupRecyclerView();
        mPresenter.getTrackInfo(getArguments().getString(ARTIST_NAME), getArguments().getString(TRACK_NAME));
    }

    @Override
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    private void setupRecyclerView() {
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 3);
        rvTags.setLayoutManager(layoutManager);

        mAdapter = new TagAdapter();
        mAdapter.setClickListener(tag -> mLogger.d("tagClicked: " + tag));
        rvTags.setAdapter(mAdapter);
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
    public void loadPhoto(String url) {
        Glide.with(getContext())
                .load(url)
                .error(R.drawable.bg)
                .placeholder(R.drawable.bg)
                .into(ivPhoto);
    }

    @Override
    public void setTags(List<String> tags) {
        if (tags != null) mAdapter.setModels(tags);
        else rvTags.setVisibility(View.GONE);
    }

    @Override
    public void setListeners(String listeners) {
        if (listeners != null) tvListeners.setText(String.format("Listeners: %s", listeners));
        else tvListeners.setText(String.format("Listeners: %s", getResources().getString(R.string.data_placeholder)));
    }

    @Override
    public void setPlayCount(String playCount) {
        if (playCount != null) tvPlayCount.setText(String.format("Play count: %s", playCount));
        else tvPlayCount.setText(String.format("Play count: %s", getResources().getString(R.string.data_placeholder)));
    }

    @Override
    public void setDuration(String duration) {
        if (duration != null) {
            long milliseconds = Long.parseLong(duration);
            String result = String.format(Locale.getDefault(), "%d:%02d",
                    TimeUnit.MILLISECONDS.toMinutes(milliseconds),
                    TimeUnit.MILLISECONDS.toSeconds(milliseconds) -
                            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(milliseconds))
            );
            tvDuration.setText(String.format("Duration: %s", result));
        }
        else tvDuration.setText(String.format("Duration: %s", getResources().getString(R.string.data_placeholder)));
    }

    @Override
    public void setBio(String bio) {
        if (bio != null) tvBio.setText(bio);
        else tvBio.setVisibility(View.GONE);
    }
}
