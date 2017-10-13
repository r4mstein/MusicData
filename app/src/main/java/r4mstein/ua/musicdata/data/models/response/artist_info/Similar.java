
package r4mstein.ua.musicdata.data.models.response.artist_info;

import com.google.gson.annotations.SerializedName;

import java.util.List;

@SuppressWarnings("unused")
public class Similar {

    @SerializedName("artist")
    private List<Artist> mArtist;

    public List<Artist> getArtist() {
        return mArtist;
    }

    public void setArtist(List<Artist> artist) {
        mArtist = artist;
    }

}
