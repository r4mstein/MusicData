package r4mstein.ua.musicdata.screens.chart.top_tracks;

import r4mstein.ua.musicdata.screens.base.BaseView;
import r4mstein.ua.musicdata.screens.chart.top_tracks.adapter.TopTracksAdapter;

public interface TopTracksContract {

    interface TopTracksView extends BaseView {
        TopTracksAdapter getAdapter();
        void progressDialogShow();
        void progressDialogHide();
    }

    interface TopTracksPresenter {
        void getNextPage();
    }
}
