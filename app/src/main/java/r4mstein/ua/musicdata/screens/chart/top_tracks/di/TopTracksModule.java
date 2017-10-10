package r4mstein.ua.musicdata.screens.chart.top_tracks.di;

import dagger.Module;
import dagger.Provides;
import r4mstein.ua.musicdata.screens.chart.top_tracks.TopTracksContract;
import r4mstein.ua.musicdata.screens.chart.top_tracks.TopTracksFragment;
import r4mstein.ua.musicdata.screens.chart.top_tracks.TopTracksPresenter;

@Module
public class TopTracksModule {

    @Provides
    TopTracksContract.TopTracksView providesTopTracksView(TopTracksFragment topTracksFragment) {
        return topTracksFragment;
    }

    @Provides
    TopTracksContract.TopTracksPresenter providesTopTracksPresenter(TopTracksContract.TopTracksView view) {
        return new TopTracksPresenter(view);
    }
}
