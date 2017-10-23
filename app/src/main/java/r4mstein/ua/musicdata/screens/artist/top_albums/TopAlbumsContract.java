package r4mstein.ua.musicdata.screens.artist.top_albums;

import r4mstein.ua.musicdata.screens.artist.top_albums.adapter.TopAlbumsAdapter;
import r4mstein.ua.musicdata.screens.base.BaseView;

public interface TopAlbumsContract {

    interface TopAlbumsView extends BaseView {
        TopAlbumsAdapter getAdapter();
        void progressDialogShow();
        void progressDialogHide();
    }

    interface TopAlbumsPresenter {
        void getNextPage(String artist);
    }
}
