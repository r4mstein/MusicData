package r4mstein.ua.musicdata.screens.detail.di;

import android.support.v4.app.Fragment;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;
import r4mstein.ua.musicdata.screens.artist.info.ArtistInfoFragment;
import r4mstein.ua.musicdata.screens.artist.info.di.ArtistInfoComponent;
import r4mstein.ua.musicdata.screens.artist.top_albums.TopAlbumsFragment;
import r4mstein.ua.musicdata.screens.artist.top_albums.di.TopAlbumsComponent;
import r4mstein.ua.musicdata.screens.artist.top_tracks.ArtistTracksFragment;
import r4mstein.ua.musicdata.screens.artist.top_tracks.di.ArtistTracksComponent;

@Module
public abstract class DetailActivityBuilder {

    @Binds
    @IntoMap
    @FragmentKey(ArtistInfoFragment.class)
    abstract AndroidInjector.Factory<? extends Fragment> provideArtistInfoFragmentFactory(ArtistInfoComponent.Builder builder);

    @Binds
    @IntoMap
    @FragmentKey(TopAlbumsFragment.class)
    abstract AndroidInjector.Factory<? extends Fragment> provideTopAlbumsFragmentFactory(TopAlbumsComponent.Builder builder);

    @Binds
    @IntoMap
    @FragmentKey(ArtistTracksFragment.class)
    abstract AndroidInjector.Factory<? extends Fragment> provideArtistTracksFragmentFactory(ArtistTracksComponent.Builder builder);
}
