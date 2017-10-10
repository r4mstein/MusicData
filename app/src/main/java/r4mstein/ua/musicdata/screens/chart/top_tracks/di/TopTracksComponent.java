package r4mstein.ua.musicdata.screens.chart.top_tracks.di;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import r4mstein.ua.musicdata.screens.chart.top_tracks.TopTracksFragment;

@Subcomponent(modules = TopTracksModule.class)
public interface TopTracksComponent extends AndroidInjector<TopTracksFragment> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<TopTracksFragment> {

    }
}
