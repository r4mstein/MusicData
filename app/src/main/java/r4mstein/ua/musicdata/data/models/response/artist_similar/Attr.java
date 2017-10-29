
package r4mstein.ua.musicdata.data.models.response.artist_similar;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Attr {

    @SerializedName("artist")
    private String mArtist;

    public String getArtist() {
        return mArtist;
    }

    public void setArtist(String artist) {
        mArtist = artist;
    }

}
