package r4mstein.ua.musicdata.screens.detail.di;

import android.support.v4.app.Fragment;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;
import r4mstein.ua.musicdata.screens.chart.top_artists.TopArtistsFragment;
import r4mstein.ua.musicdata.screens.chart.top_artists.di.TopArtistsComponent;

@Module
public abstract class DetailActivityBuilder {

//    @Binds
//    @IntoMap
//    @FragmentKey(TopArtistsFragment.class)
//    abstract AndroidInjector.Factory<? extends Fragment> provideTopArtistsFragmentFactory(TopArtistsComponent.Builder builder);
}
