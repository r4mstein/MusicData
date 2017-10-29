package r4mstein.ua.musicdata.screens.detail;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;
import r4mstein.ua.musicdata.R;
import r4mstein.ua.musicdata.screens.artist.info.ArtistInfoFragment;
import r4mstein.ua.musicdata.screens.artist.similar.SimilarArtistsFragment;
import r4mstein.ua.musicdata.screens.artist.top_albums.TopAlbumsFragment;
import r4mstein.ua.musicdata.screens.artist.top_tracks.ArtistTracksFragment;
import r4mstein.ua.musicdata.screens.base.BaseActivity;
import r4mstein.ua.musicdata.screens.track.info.TrackInfoFragment;

import static r4mstein.ua.musicdata.utils.Constants.ARTIST_INFO_NAME;
import static r4mstein.ua.musicdata.utils.Constants.ARTIST_SIMILAR;
import static r4mstein.ua.musicdata.utils.Constants.ARTIST_TOP_ALBUMS;
import static r4mstein.ua.musicdata.utils.Constants.ARTIST_TOP_TRACKS;
import static r4mstein.ua.musicdata.utils.Constants.TRACK_INFO_ARTIST;
import static r4mstein.ua.musicdata.utils.Constants.TRACK_INFO_NAME;

public class DetailActivity extends BaseActivity implements DetailContract.DetailView, HasSupportFragmentInjector {

    @Inject
    DispatchingAndroidInjector<Fragment> mFragmentDispatchingAndroidInjector;

    @Inject
    DetailPresenter mPresenter;

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return mFragmentDispatchingAndroidInjector;
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_detail;
    }

    @Override
    protected int getContainerId() {
        return R.id.fl_container_AD;
    }

    @Override
    protected void findUI() {
    }

    @Override
    protected void setupUI() {
        addFragment();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        if (getIntent().getStringExtra(ARTIST_INFO_NAME) != null || getIntent().getStringExtra(TRACK_INFO_NAME) != null)
            this.setTheme(R.style.DetailScreenTheme);
        super.onCreate(savedInstanceState);
    }

    private void addFragment() {
        if (getIntent().getStringExtra(ARTIST_INFO_NAME) != null)
            replaceFragment(ArtistInfoFragment.newInstance(getIntent().getStringExtra(ARTIST_INFO_NAME)));
        else if (getIntent().getStringExtra(ARTIST_TOP_ALBUMS) != null)
            replaceFragment(TopAlbumsFragment.newInstance(getIntent().getStringExtra(ARTIST_TOP_ALBUMS)));
        else if (getIntent().getStringExtra(ARTIST_TOP_TRACKS) != null)
            replaceFragment(ArtistTracksFragment.newInstance(getIntent().getStringExtra(ARTIST_TOP_TRACKS)));
        else if (getIntent().getStringExtra(ARTIST_SIMILAR) != null)
            replaceFragment(SimilarArtistsFragment.newInstance(getIntent().getStringExtra(ARTIST_SIMILAR)));
        else if (getIntent().getStringExtra(TRACK_INFO_NAME) != null)
            replaceFragment(TrackInfoFragment.newInstance(getIntent().getStringExtra(TRACK_INFO_ARTIST),
                    getIntent().getStringExtra(TRACK_INFO_NAME)));
    }
}
