
package r4mstein.ua.musicdata.data.models.response.artist_tracks;

import com.google.gson.annotations.SerializedName;

import java.util.List;

@SuppressWarnings("unused")
public class Toptracks {

    @SerializedName("@attr")
    private Attr mAttr;
    @SerializedName("track")
    private List<Track> mTrack;

    public Attr getAttr() {
        return mAttr;
    }

    public void setAttr(Attr attr) {
        mAttr = attr;
    }

    public List<Track> getTrack() {
        return mTrack;
    }

    public void setTrack(List<Track> track) {
        mTrack = track;
    }

}
