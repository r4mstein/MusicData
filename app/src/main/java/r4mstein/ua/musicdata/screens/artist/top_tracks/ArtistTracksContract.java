package r4mstein.ua.musicdata.screens.artist.top_tracks;

import r4mstein.ua.musicdata.screens.artist.top_tracks.adapter.ArtistTracksAdapter;
import r4mstein.ua.musicdata.screens.base.BaseView;

public interface ArtistTracksContract {

    interface ArtistTracksView extends BaseView {
        ArtistTracksAdapter getAdapter();
        void progressDialogShow();
        void progressDialogHide();
    }

    interface ArtistTracksPresenter {
        void getNextPage(String artist);
    }
}
