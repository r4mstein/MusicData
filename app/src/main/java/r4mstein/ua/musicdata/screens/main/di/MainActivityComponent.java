package r4mstein.ua.musicdata.screens.main.di;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import r4mstein.ua.musicdata.screens.main.MainActivity;

@Subcomponent(modules = {
        MainActivityModule.class,
        MainActivityBuilder.class
})
public interface MainActivityComponent extends AndroidInjector<MainActivity> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MainActivity> {

    }
}
