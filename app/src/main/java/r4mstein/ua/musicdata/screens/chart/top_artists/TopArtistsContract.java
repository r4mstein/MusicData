package r4mstein.ua.musicdata.screens.chart.top_artists;

import r4mstein.ua.musicdata.screens.base.BaseView;
import r4mstein.ua.musicdata.screens.chart.top_artists.adapter.TopArtistsAdapter;

public interface TopArtistsContract {

    interface TopArtistsView extends BaseView {
        TopArtistsAdapter getAdapter();
        void progressDialogShow();
        void progressDialogHide();
    }

    interface TopArtistsPresenter {
        void getNextPage();
    }
}
