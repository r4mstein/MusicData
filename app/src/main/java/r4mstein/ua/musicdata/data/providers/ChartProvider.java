package r4mstein.ua.musicdata.data.providers;

import io.reactivex.Observable;
import r4mstein.ua.musicdata.data.api.ChartApi;
import r4mstein.ua.musicdata.data.models.respons.ChartTopArtists.ChartTopArtists;

public class ChartProvider extends BaseProvider implements ChartApi {


    @Override
    public Observable<ChartTopArtists> getTopArtists(String method, String apiKey, long limit,
                                                     long page, String format) {
        return api.getTopArtists(method, apiKey, limit, page, format);
    }
}
