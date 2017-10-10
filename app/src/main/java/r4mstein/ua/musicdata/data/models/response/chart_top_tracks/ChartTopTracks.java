
package r4mstein.ua.musicdata.data.models.response.chart_top_tracks;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class ChartTopTracks {

    @SerializedName("tracks")
    private Tracks mTracks;

    public Tracks getTracks() {
        return mTracks;
    }

    public void setTracks(Tracks tracks) {
        mTracks = tracks;
    }

}
