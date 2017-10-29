package r4mstein.ua.musicdata.screens.artist.similar.di;

import dagger.Module;
import dagger.Provides;
import r4mstein.ua.musicdata.screens.artist.similar.SimilarArtistsContract;
import r4mstein.ua.musicdata.screens.artist.similar.SimilarArtistsFragment;
import r4mstein.ua.musicdata.screens.artist.similar.SimilarArtistsPresenter;

@Module
public class SimilarArtistsModule {

    @Provides
    SimilarArtistsContract.SimilarArtistsView providesSimilarArtistsView(SimilarArtistsFragment fragment) {
        return fragment;
    }

    @Provides
    SimilarArtistsContract.SimilarArtistsPresenter providesArtistsPresenter(SimilarArtistsContract.SimilarArtistsView view) {
        return new SimilarArtistsPresenter(view);
    }
}
