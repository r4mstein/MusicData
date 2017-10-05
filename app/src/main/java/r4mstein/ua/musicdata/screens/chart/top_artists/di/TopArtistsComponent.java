package r4mstein.ua.musicdata.screens.chart.top_artists.di;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import r4mstein.ua.musicdata.screens.chart.top_artists.TopArtistsFragment;

@Subcomponent(modules = TopArtistsModule.class)
public interface TopArtistsComponent extends AndroidInjector<TopArtistsFragment> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<TopArtistsFragment> {

    }
}
