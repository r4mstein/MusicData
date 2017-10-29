package r4mstein.ua.musicdata.screens.artist.similar;

import java.util.List;

import r4mstein.ua.musicdata.data.models.ArtistSimilarModel;
import r4mstein.ua.musicdata.screens.base.BaseView;

public interface SimilarArtistsContract {

    interface SimilarArtistsView extends BaseView {
        void progressDialogShow();
        void progressDialogHide();
        void setData(List<ArtistSimilarModel> models);
    }

    interface SimilarArtistsPresenter {

    }
}
