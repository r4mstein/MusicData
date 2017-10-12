package r4mstein.ua.musicdata.screens.detail.di;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import r4mstein.ua.musicdata.screens.detail.DetailActivity;

@Subcomponent(modules = {
        DetailActivityModule.class,
        DetailActivityBuilder.class
})
public interface DetailActivityComponent extends AndroidInjector<DetailActivity> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<DetailActivity> {

    }
}
