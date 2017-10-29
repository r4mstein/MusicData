package r4mstein.ua.musicdata.data.api;

import io.reactivex.Observable;
import r4mstein.ua.musicdata.data.models.response.artist_albums.ArtistTopAlbums;
import r4mstein.ua.musicdata.data.models.response.artist_info.ArtistInfo;
import r4mstein.ua.musicdata.data.models.response.artist_similar.ArtistSimilar;
import r4mstein.ua.musicdata.data.models.response.artist_tracks.ArtistTopTracks;
import r4mstein.ua.musicdata.data.models.response.chart_top_artists.ChartTopArtists;
import r4mstein.ua.musicdata.data.models.response.chart_top_tracks.ChartTopTracks;
import r4mstein.ua.musicdata.data.models.response.track_info.TrackInfo;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitInterface {

                    // CHART //
    @GET("2.0/")
    Observable<ChartTopArtists> getTopArtists(@Query("method") String method,
                                              @Query("api_key") String apiKey,
                                              @Query("limit") long limit,
                                              @Query("page") long page,
                                              @Query("format") String format);

    @GET("2.0/")
    Observable<ChartTopTracks> getTopTracks(@Query("method") String method,
                                            @Query("api_key") String apiKey,
                                            @Query("limit") long limit,
                                            @Query("page") long page,
                                            @Query("format") String format);

                    // ARTIST //
    @GET("2.0/")
    Observable<ArtistInfo> getArtistInfo(@Query("method") String method,
                                         @Query("artist") String artist,
                                         @Query("api_key") String apiKey,
                                         @Query("format") String format);

    @GET("2.0/")
    Observable<ArtistTopAlbums> getArtistAlbums(@Query("method") String method,
                                                @Query("artist") String artist,
                                                @Query("api_key") String apiKey,
                                                @Query("limit") long limit,
                                                @Query("page") long page,
                                                @Query("format") String format);

    @GET("2.0/")
    Observable<ArtistTopTracks> getArtistTracks(@Query("method") String method,
                                                @Query("artist") String artist,
                                                @Query("api_key") String apiKey,
                                                @Query("limit") long limit,
                                                @Query("page") long page,
                                                @Query("format") String format);

    @GET("2.0/")
    Observable<ArtistSimilar> getSimilarArtists(@Query("method") String method,
                                                @Query("artist") String artist,
                                                @Query("api_key") String apiKey,
                                                @Query("format") String format);

                    // TRACK //
    @GET("2.0/")
    Observable<TrackInfo> getTrackInfo(@Query("method") String method,
                                       @Query("artist") String artist,
                                       @Query("api_key") String apiKey,
                                       @Query("track") String track,
                                       @Query("format") String format);
}
