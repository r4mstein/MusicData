package r4mstein.ua.musicdata.screens.artist.info;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import r4mstein.ua.musicdata.screens.artist.info.adapter.TagAdapter;
import r4mstein.ua.musicdata.screens.base.BaseView;

public interface ArtistInfoContract {

    interface ArtistInfoView extends BaseView {
        void progressDialogShow();
        void progressDialogHide();
        TagAdapter getAdapter();
        ImageView getIvPhoto();
        TextView getTvListeners();
        TextView getTvBio();
        Context getFragmContext();
    }

    interface ArtistInfoPresenter {
        void getArtistInfo(String artist);
    }
}
