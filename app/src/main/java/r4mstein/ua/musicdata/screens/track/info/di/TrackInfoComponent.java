package r4mstein.ua.musicdata.screens.track.info.di;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import r4mstein.ua.musicdata.screens.track.info.TrackInfoFragment;

@Subcomponent(modules = TrackInfoModule.class)
public interface TrackInfoComponent extends AndroidInjector<TrackInfoFragment> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<TrackInfoFragment> {

    }
}
