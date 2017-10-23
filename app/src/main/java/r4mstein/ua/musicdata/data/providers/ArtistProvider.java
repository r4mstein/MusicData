package r4mstein.ua.musicdata.data.providers;

import javax.inject.Inject;

import io.reactivex.Observable;
import r4mstein.ua.musicdata.data.api.ArtistApi;
import r4mstein.ua.musicdata.data.models.response.artist_albums.ArtistTopAlbums;
import r4mstein.ua.musicdata.data.models.response.artist_info.ArtistInfo;

public class ArtistProvider extends BaseProvider implements ArtistApi {

    @Inject
    public ArtistProvider() {
    }

    @Override
    public Observable<ArtistInfo> getArtistInfo(String method, String artist, String apiKey, String format) {
        return api.getArtistInfo(method, artist, apiKey, format);
    }

    @Override
    public Observable<ArtistTopAlbums> getArtistAlbums(String method, String artist, String apiKey,
                                                       long limit, long page, String format) {
        return api.getArtistAlbums(method, artist, apiKey, limit, page, format);
    }
}
