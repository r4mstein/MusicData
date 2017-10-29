
package r4mstein.ua.musicdata.data.models.response.track_info;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class TrackInfo {

    @SerializedName("track")
    private Track mTrack;

    public Track getTrack() {
        return mTrack;
    }

    public void setTrack(Track track) {
        mTrack = track;
    }

}
