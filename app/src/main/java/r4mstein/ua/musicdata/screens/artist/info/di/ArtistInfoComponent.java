package r4mstein.ua.musicdata.screens.artist.info.di;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import r4mstein.ua.musicdata.screens.artist.info.ArtistInfoFragment;

@Subcomponent(modules = ArtistInfoModule.class)
public interface ArtistInfoComponent extends AndroidInjector<ArtistInfoFragment> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<ArtistInfoFragment> {

    }
}
