package r4mstein.ua.musicdata.screens.detail;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;
import r4mstein.ua.musicdata.R;
import r4mstein.ua.musicdata.screens.base.BaseActivity;

public class DetailActivity extends BaseActivity implements DetailContract.DetailView {

//    @Inject
//    DispatchingAndroidInjector<Fragment> mFragmentDispatchingAndroidInjector;

    @Inject
    DetailPresenter mPresenter;

    private Toolbar mToolbar;

//    @Override
//    public AndroidInjector<Fragment> supportFragmentInjector() {
//        return mFragmentDispatchingAndroidInjector;
//    }

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
        mToolbar = (Toolbar) findViewById(R.id.toolbar_AD);
    }

    @Override
    protected void setupUI() {
        initToolbar();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
    }

    private void initToolbar() {
        setSupportActionBar(mToolbar);
        getSupportActionBar().setHomeButtonEnabled(false);
        getSupportFragmentManager().addOnBackStackChangedListener(() ->
                getSupportActionBar().setDisplayHomeAsUpEnabled(getSupportFragmentManager().getBackStackEntryCount() > 0)
        );

        mToolbar.setNavigationOnClickListener(view -> onBackPressed());
    }
}
