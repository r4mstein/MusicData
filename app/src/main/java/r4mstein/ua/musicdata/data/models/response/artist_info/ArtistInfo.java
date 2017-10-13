
package r4mstein.ua.musicdata.data.models.response.artist_info;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class ArtistInfo {

    @SerializedName("artist")
    private Artist mArtist;

    public Artist getArtist() {
        return mArtist;
    }

    public void setArtist(Artist artist) {
        mArtist = artist;
    }

}
