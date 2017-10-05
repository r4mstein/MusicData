
package r4mstein.ua.musicdata.data.models.respons.ChartTopArtists;

import com.google.gson.annotations.SerializedName;

import java.util.List;

@SuppressWarnings("unused")
public class Artists {

    @SerializedName("artist")
    private List<Artist> mArtist;
    @SerializedName("@attr")
    private Attr mAttr;

    public List<Artist> getArtist() {
        return mArtist;
    }

    public void setArtist(List<Artist> artist) {
        mArtist = artist;
    }

    public Attr getAttr() {
        return mAttr;
    }

    public void setAttr(Attr attr) {
        mAttr = attr;
    }

}
