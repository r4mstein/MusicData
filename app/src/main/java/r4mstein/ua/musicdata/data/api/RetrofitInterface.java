package r4mstein.ua.musicdata.data.api;

import io.reactivex.Observable;
import r4mstein.ua.musicdata.data.models.response.artist_info.ArtistInfo;
import r4mstein.ua.musicdata.data.models.response.chart_top_artists.ChartTopArtists;
import r4mstein.ua.musicdata.data.models.response.chart_top_tracks.ChartTopTracks;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitInterface {

    // chart
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

    // artist
    @GET("2.0/")
    Observable<ArtistInfo> getArtistInfo(@Query("method") String method,
                                         @Query("artist") String artist,
                                         @Query("api_key") String apiKey,
                                         @Query("format") String format);
}
