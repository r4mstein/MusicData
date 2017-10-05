package r4mstein.ua.musicdata.data.api;

import io.reactivex.Observable;
import r4mstein.ua.musicdata.data.models.respons.ChartTopArtists.ChartTopArtists;

public interface ChartApi {

    Observable<ChartTopArtists> getTopArtists(String method, String apiKey, long limit, long page,
                                              String format);
}
