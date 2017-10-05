
package r4mstein.ua.musicdata.data.models.respons.ChartTopArtists;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class ChartTopArtists {

    @SerializedName("artists")
    private Artists mArtists;

    public Artists getArtists() {
        return mArtists;
    }

    public void setArtists(Artists artists) {
        mArtists = artists;
    }

}
