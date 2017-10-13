package r4mstein.ua.musicdata.screens.artist.info.di;

import dagger.Module;
import dagger.Provides;
import r4mstein.ua.musicdata.screens.artist.info.ArtistInfoContract;
import r4mstein.ua.musicdata.screens.artist.info.ArtistInfoFragment;
import r4mstein.ua.musicdata.screens.artist.info.ArtistInfoPresenter;

@Module
public class ArtistInfoModule {

    @Provides
    ArtistInfoContract.ArtistInfoView provideArtistInfoView(ArtistInfoFragment fragment) {
        return fragment;
    }

    @Provides
    ArtistInfoContract.ArtistInfoPresenter providesArtistInfoPresenter(ArtistInfoContract.ArtistInfoView view) {
        return new ArtistInfoPresenter(view);
    }
}
