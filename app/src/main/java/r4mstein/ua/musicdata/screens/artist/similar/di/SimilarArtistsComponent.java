package r4mstein.ua.musicdata.screens.artist.similar.di;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import r4mstein.ua.musicdata.screens.artist.similar.SimilarArtistsFragment;

@Subcomponent(modules = SimilarArtistsModule.class)
public interface SimilarArtistsComponent extends AndroidInjector<SimilarArtistsFragment> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<SimilarArtistsFragment> {

    }
}
