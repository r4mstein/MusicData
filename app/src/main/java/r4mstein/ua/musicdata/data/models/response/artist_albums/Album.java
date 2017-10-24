
package r4mstein.ua.musicdata.data.models.response.artist_albums;

import com.google.gson.annotations.SerializedName;

import java.util.List;

@SuppressWarnings("unused")
public class Album {

    @SerializedName("artist")
    private Artist mArtist;
    @SerializedName("image")
    private List<Image> mImage;
    @SerializedName("mbid")
    private String mMbid;
    @SerializedName("name")
    private String mName;
    @SerializedName("playcount")
    private Long mPlaycount;
    @SerializedName("url")
    private String mUrl;

    public Artist getArtist() {
        return mArtist;
    }

    public void setArtist(Artist artist) {
        mArtist = artist;
    }

    public List<Image> getImage() {
        return mImage;
    }

    public void setImage(List<Image> image) {
        mImage = image;
    }

    public String getMbid() {
        return mMbid;
    }

    public void setMbid(String mbid) {
        mMbid = mbid;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public Long getPlaycount() {
        return mPlaycount;
    }

    public void setPlaycount(Long playcount) {
        mPlaycount = playcount;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

}
