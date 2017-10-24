package r4mstein.ua.musicdata.screens.artist.top_tracks.di;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import r4mstein.ua.musicdata.screens.artist.top_tracks.ArtistTracksFragment;

@Subcomponent(modules = ArtistTracksModule.class)
public interface ArtistTracksComponent extends AndroidInjector<ArtistTracksFragment> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<ArtistTracksFragment> {

    }
}
