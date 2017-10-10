package r4mstein.ua.musicdata.data.api;

import io.reactivex.Observable;
import r4mstein.ua.musicdata.data.models.response.chart_top_artists.ChartTopArtists;
import r4mstein.ua.musicdata.data.models.response.chart_top_tracks.ChartTopTracks;

public interface ChartApi {

    Observable<ChartTopArtists> getTopArtists(String method, String apiKey, long limit, long page,
                                              String format);

    Observable<ChartTopTracks> getTopTracks(String method, String apiKey, long limit, long page,
                                            String format);
}
