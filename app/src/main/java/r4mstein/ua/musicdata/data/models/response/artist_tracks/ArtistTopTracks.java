
package r4mstein.ua.musicdata.data.models.response.artist_tracks;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class ArtistTopTracks {

    @SerializedName("toptracks")
    private Toptracks mToptracks;

    public Toptracks getToptracks() {
        return mToptracks;
    }

    public void setToptracks(Toptracks toptracks) {
        mToptracks = toptracks;
    }

}
