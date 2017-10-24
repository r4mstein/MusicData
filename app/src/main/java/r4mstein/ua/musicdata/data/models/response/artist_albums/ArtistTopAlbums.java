
package r4mstein.ua.musicdata.data.models.response.artist_albums;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class ArtistTopAlbums {

    @SerializedName("topalbums")
    private Topalbums mTopalbums;

    public Topalbums getTopalbums() {
        return mTopalbums;
    }

    public void setTopalbums(Topalbums topalbums) {
        mTopalbums = topalbums;
    }

}
