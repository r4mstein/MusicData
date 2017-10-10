package r4mstein.ua.musicdata.screens.main.di;

import android.support.v4.app.Fragment;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;
import r4mstein.ua.musicdata.screens.chart.top_artists.TopArtistsFragment;
import r4mstein.ua.musicdata.screens.chart.top_artists.di.TopArtistsComponent;
import r4mstein.ua.musicdata.screens.chart.top_tracks.TopTracksFragment;
import r4mstein.ua.musicdata.screens.chart.top_tracks.di.TopTracksComponent;

@Module
public abstract class MainActivityBuilder {

    @Binds
    @IntoMap
    @FragmentKey(TopArtistsFragment.class)
    abstract AndroidInjector.Factory<? extends Fragment> provideTopArtistsFragmentFactory(TopArtistsComponent.Builder builder);

    @Binds
    @IntoMap
    @FragmentKey(TopTracksFragment.class)
    abstract AndroidInjector.Factory<? extends Fragment> provideTopTracksFragmentFactory(TopTracksComponent.Builder builder);
}
