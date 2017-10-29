package r4mstein.ua.musicdata.data.providers;

import javax.inject.Inject;

import io.reactivex.Observable;
import r4mstein.ua.musicdata.data.api.TrackApi;
import r4mstein.ua.musicdata.data.models.response.track_info.TrackInfo;

public class TrackProvider extends BaseProvider implements TrackApi {

    @Inject
    public TrackProvider() {
    }

    @Override
    public Observable<TrackInfo> getTrackInfo(String method, String artist, String apiKey, String track, String format) {
        return api.getTrackInfo(method, artist, apiKey, track, format);
    }
}
