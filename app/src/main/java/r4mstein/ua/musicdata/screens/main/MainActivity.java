package r4mstein.ua.musicdata.screens.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;

import com.andremion.floatingnavigationview.FloatingNavigationView;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;
import r4mstein.ua.musicdata.R;
import r4mstein.ua.musicdata.screens.base.BaseActivity;
import r4mstein.ua.musicdata.screens.chart.top_artists.TopArtistsFragment;
import r4mstein.ua.musicdata.screens.chart.top_tracks.TopTracksFragment;

public class MainActivity extends BaseActivity implements MainContract.MainView, HasSupportFragmentInjector {

    private static final String TAG = "MainActivity";

    @Inject
    DispatchingAndroidInjector<Fragment> mFragmentDispatchingAndroidInjector;

    @Inject
    MainPresenter mMainPresenter;

    private Toolbar mToolbar;
    private FloatingNavigationView FNV;

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_main;
    }

    @Override
    protected int getContainerId() {
        return R.id.fl_container_AM;
    }

    @Override
    protected void findUI() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar_AM);
        FNV = (FloatingNavigationView) findViewById(R.id.fnv_AM);
    }

    @Override
    protected void setupUI() {
        initToolbar();
        setupFNV();
        replaceFragment(new TopArtistsFragment());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
    }

    private void setupFNV() {
        FNV.setOnClickListener(v -> FNV.open());
        FNV.setNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.nvm_top_artists:
                    replaceFragmentWithBackStack(new TopArtistsFragment());
                    FNV.close();
                    return true;
                case R.id.nvm_top_tracks:
                    replaceFragmentWithBackStack(new TopTracksFragment());
                    FNV.close();
                    return true;
            }
            return true;
        });
    }

    private void initToolbar() {
        setSupportActionBar(mToolbar);
        getSupportActionBar().setHomeButtonEnabled(false);
        getSupportFragmentManager().addOnBackStackChangedListener(() ->
                getSupportActionBar().setDisplayHomeAsUpEnabled(getSupportFragmentManager().getBackStackEntryCount() > 0)
        );

        mToolbar.setNavigationOnClickListener(view -> onBackPressed());
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return mFragmentDispatchingAndroidInjector;
    }

    @Override
    public void onBackPressed() {
        if (FNV.isOpened()) FNV.close();
        else if (getSupportFragmentManager().getFragments().size() == 1) finish();
        else super.onBackPressed();
    }
}
