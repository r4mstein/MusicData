package r4mstein.ua.musicdata.screens.detail.di;

import dagger.Module;
import dagger.Provides;
import r4mstein.ua.musicdata.screens.detail.DetailActivity;
import r4mstein.ua.musicdata.screens.detail.DetailContract;
import r4mstein.ua.musicdata.screens.detail.DetailPresenter;

@Module (subcomponents = {
        // TODO: 12.10.2017
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
