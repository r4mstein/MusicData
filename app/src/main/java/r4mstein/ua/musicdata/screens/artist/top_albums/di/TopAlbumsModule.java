package r4mstein.ua.musicdata.screens.artist.top_albums.di;

import dagger.Module;
import dagger.Provides;
import r4mstein.ua.musicdata.screens.artist.top_albums.TopAlbumsContract;
import r4mstein.ua.musicdata.screens.artist.top_albums.TopAlbumsFragment;
import r4mstein.ua.musicdata.screens.artist.top_albums.TopAlbumsPresenter;

@Module
public class TopAlbumsModule {

    @Provides
    TopAlbumsContract.TopAlbumsView provideTopAlbumsView(TopAlbumsFragment fragment) {
        return fragment;
    }

    @Provides
    TopAlbumsContract.TopAlbumsPresenter providesTopAlbumsPresenter(TopAlbumsContract.TopAlbumsView view) {
        return new TopAlbumsPresenter(view);
    }
}
