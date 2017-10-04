package r4mstein.ua.musicdata.screens.main;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import r4mstein.ua.musicdata.R;
import r4mstein.ua.musicdata.screens.base.BaseActivity;

public class MainActivity extends BaseActivity implements MainContract.MainView {

    private static final String TAG = "MainActivity";

    @Inject
    MainPresenter mMainPresenter;

    private Toolbar mToolbar;

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
