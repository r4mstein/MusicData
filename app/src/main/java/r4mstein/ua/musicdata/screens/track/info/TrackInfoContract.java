package r4mstein.ua.musicdata.screens.track.info;

import java.util.List;

import r4mstein.ua.musicdata.screens.base.BaseView;

public interface TrackInfoContract {

    interface TrackInfoView extends BaseView {
        void progressDialogShow();
        void progressDialogHide();
        void loadPhoto(String url);
        void setTags(List<String> tags);
        void setListeners(String listeners);
        void setPlayCount(String playCount);
        void setDuration(String duration);
        void setBio(String bio);
    }

    interface TrackInfoPresenter {

    }
}
