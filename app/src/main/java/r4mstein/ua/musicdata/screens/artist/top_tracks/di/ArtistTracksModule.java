package r4mstein.ua.musicdata.screens.artist.top_tracks.di;

import dagger.Module;
import dagger.Provides;
import r4mstein.ua.musicdata.screens.artist.top_tracks.ArtistTracksContract;
import r4mstein.ua.musicdata.screens.artist.top_tracks.ArtistTracksFragment;
import r4mstein.ua.musicdata.screens.artist.top_tracks.ArtistTracksPresenter;

@Module
public class ArtistTracksModule {

    @Provides
    ArtistTracksContract.ArtistTracksView providesArtistTracksView(ArtistTracksFragment fragment) {
        return fragment;
    }

    @Provides
    ArtistTracksContract.ArtistTracksPresenter providesArtistTracksPresenter(ArtistTracksContract.ArtistTracksView view) {
        return new ArtistTracksPresenter(view);
    }
}
