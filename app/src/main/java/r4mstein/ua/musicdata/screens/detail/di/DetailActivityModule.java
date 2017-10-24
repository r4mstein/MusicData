package r4mstein.ua.musicdata.screens.detail.di;

import dagger.Module;
import dagger.Provides;
import r4mstein.ua.musicdata.screens.artist.info.di.ArtistInfoComponent;
import r4mstein.ua.musicdata.screens.artist.top_albums.di.TopAlbumsComponent;
import r4mstein.ua.musicdata.screens.artist.top_tracks.di.ArtistTracksComponent;
import r4mstein.ua.musicdata.screens.detail.DetailActivity;
import r4mstein.ua.musicdata.screens.detail.DetailContract;
import r4mstein.ua.musicdata.screens.detail.DetailPresenter;

@Module (subcomponents = {
        ArtistInfoComponent.class,
        TopAlbumsComponent.class,
        ArtistTracksComponent.class
})
public class DetailActivityModule {

    @Provides
    DetailContract.DetailView providesDetailView(DetailActivity activity) {
        return activity;
    }

    @Provides
    DetailContract.DetailPresenter providesDetailPresenter(DetailContract.DetailView view) {
        return new DetailPresenter(view);
    }
}
