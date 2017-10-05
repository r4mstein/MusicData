package r4mstein.ua.musicdata.screens.main.di;

import dagger.Module;
import dagger.Provides;
import r4mstein.ua.musicdata.screens.chart.top_artists.di.TopArtistsComponent;
import r4mstein.ua.musicdata.screens.main.MainActivity;
import r4mstein.ua.musicdata.screens.main.MainContract;
import r4mstein.ua.musicdata.screens.main.MainPresenter;

@Module(subcomponents = {
        TopArtistsComponent.class
})
public class MainActivityModule {

    @Provides
    MainContract.MainView provideMainView(MainActivity mainActivity) {
        return mainActivity;
    }

    @Provides
    MainContract.MainPresenter provideMainPresenter(MainContract.MainView mainView) {
        return new MainPresenter(mainView);
    }
}
