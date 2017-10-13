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
import r4mstein.ua.musicdata.screens.base.BaseActivity;

import static r4mstein.ua.musicdata.utils.Constants.ARTIST_INFO_NAME;

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
        replaceFragment(ArtistInfoFragment.newInstance(getIntent().getStringExtra(ARTIST_INFO_NAME)));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
    }
}
