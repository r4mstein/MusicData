
package r4mstein.ua.musicdata.data.models.response.artist_albums;

import com.google.gson.annotations.SerializedName;

import java.util.List;

@SuppressWarnings("unused")
public class Topalbums {

    @SerializedName("album")
    private List<Album> mAlbum;
    @SerializedName("@attr")
    private Attr mAttr;

    public List<Album> getAlbum() {
        return mAlbum;
    }

    public void setAlbum(List<Album> album) {
        mAlbum = album;
    }

    public Attr getAttr() {
        return mAttr;
    }

    public void setAttr(Attr attr) {
        mAttr = attr;
    }

}
