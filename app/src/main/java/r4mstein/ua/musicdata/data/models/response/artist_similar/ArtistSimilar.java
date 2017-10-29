
package r4mstein.ua.musicdata.data.models.response.artist_similar;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class ArtistSimilar {

    @SerializedName("similarartists")
    private Artists mArtists;

    public Artists getArtists() {
        return mArtists;
    }

    public void setArtists(Artists artists) {
        mArtists = artists;
    }

}
