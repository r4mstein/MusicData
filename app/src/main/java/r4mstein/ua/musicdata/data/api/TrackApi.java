package r4mstein.ua.musicdata.data.api;

import io.reactivex.Observable;
import r4mstein.ua.musicdata.data.models.response.track_info.TrackInfo;

public interface TrackApi {

    Observable<TrackInfo> getTrackInfo( String method, String artist, String apiKey, String track,
                                        String format);
}
