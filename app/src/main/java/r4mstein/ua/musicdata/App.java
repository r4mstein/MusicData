package r4mstein.ua.musicdata;

import android.app.Activity;
import android.app.Application;

import javax.inject.Inject;

import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import r4mstein.ua.musicdata.di.DaggerAppComponent;

public class App extends Application implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> mActivityDispatchingAndroidInjector;

    @Override
    public void onCreate() {
        super.onCreate();

        DaggerAppComponent
                .builder()
                .aplication(this)
                .build()
                .inject(this);

//        Lfm.initializeWithSecret(this);
    }

    @Override
    public DispatchingAndroidInjector<Activity> activityInjector() {
        return mActivityDispatchingAndroidInjector;
    }
}
