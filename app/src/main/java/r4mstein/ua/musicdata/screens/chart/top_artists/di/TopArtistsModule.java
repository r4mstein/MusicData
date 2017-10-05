package r4mstein.ua.musicdata.screens.chart.top_artists.di;

import dagger.Module;
import dagger.Provides;
import r4mstein.ua.musicdata.screens.chart.top_artists.TopArtistsContract;
import r4mstein.ua.musicdata.screens.chart.top_artists.TopArtistsFragment;
import r4mstein.ua.musicdata.screens.chart.top_artists.TopArtistsPresenter;

@Module
public class TopArtistsModule {

    @Provides
    TopArtistsContract.TopArtistsView provideTopArtistsView(TopArtistsFragment topArtistsFragment) {
        return topArtistsFragment;
    }

    @Provides
    TopArtistsContract.TopArtistsPresenter provideTopArtistsPresenter(TopArtistsContract.TopArtistsView view) {
        return new TopArtistsPresenter(view);
    }
}
