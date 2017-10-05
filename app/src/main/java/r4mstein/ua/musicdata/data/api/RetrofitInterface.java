package r4mstein.ua.musicdata.data.api;

import io.reactivex.Observable;
import r4mstein.ua.musicdata.data.models.respons.ChartTopArtists.ChartTopArtists;
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
}
