package r4mstein.ua.musicdata.data.api;

import io.reactivex.Observable;
import r4mstein.ua.musicdata.data.models.response.artist_info.ArtistInfo;

public interface ArtistApi {

    Observable<ArtistInfo> getArtistInfo(String method, String artist, String apiKey, String format);
}
