package r4mstein.ua.musicdata.screens.artist.top_albums.di;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import r4mstein.ua.musicdata.screens.artist.top_albums.TopAlbumsFragment;

@Subcomponent(modules = TopAlbumsModule.class)
public interface TopAlbumsComponent extends AndroidInjector<TopAlbumsFragment> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<TopAlbumsFragment> {

    }
}
