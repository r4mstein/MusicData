package r4mstein.ua.musicdata.data.api;

import io.reactivex.Observable;
import r4mstein.ua.musicdata.data.models.response.artist_albums.ArtistTopAlbums;
import r4mstein.ua.musicdata.data.models.response.artist_info.ArtistInfo;
import r4mstein.ua.musicdata.data.models.response.artist_similar.ArtistSimilar;
import r4mstein.ua.musicdata.data.models.response.artist_tracks.ArtistTopTracks;

public interface ArtistApi {

    Observable<ArtistInfo> getArtistInfo(String method, String artist, String apiKey, String format);

    Observable<ArtistTopAlbums> getArtistAlbums(String method, String artist, String apiKey,
                                                long limit, long page, String format);

    Observable<ArtistTopTracks> getArtistTracks(String method, String artist, String apiKey,
                                                long limit, long page, String format);

    Observable<ArtistSimilar> getSimilarArtists(String method, String artist, String apiKey, String format);
}
