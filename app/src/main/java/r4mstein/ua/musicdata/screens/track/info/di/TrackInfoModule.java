package r4mstein.ua.musicdata.screens.track.info.di;

import dagger.Module;
import dagger.Provides;
import r4mstein.ua.musicdata.screens.track.info.TrackInfoContract;
import r4mstein.ua.musicdata.screens.track.info.TrackInfoFragment;
import r4mstein.ua.musicdata.screens.track.info.TrackInfoPresenter;

@Module
public class TrackInfoModule {

    @Provides
    TrackInfoContract.TrackInfoView providesTrackInfoView(TrackInfoFragment fragment) {
        return fragment;
    }

    @Provides
    TrackInfoContract.TrackInfoPresenter providesTrackInfoPresenter(TrackInfoContract.TrackInfoView view) {
        return new TrackInfoPresenter(view);
    }
}
