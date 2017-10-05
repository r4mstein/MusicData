package r4mstein.ua.musicdata.di;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import r4mstein.ua.musicdata.screens.main.di.MainActivityComponent;
import r4mstein.ua.musicdata.utils.Logger;

@Module(subcomponents = {
        MainActivityComponent.class
})
public class AppModule {

    @Provides
    @Singleton
    Context provideContext(Application application) {
        return application;
    }

    @Provides
    @Singleton
    Logger provideLogger() {
        return new Logger();
    }
}
