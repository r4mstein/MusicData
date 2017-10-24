
package r4mstein.ua.musicdata.data.models.response.artist_tracks;

import com.google.gson.annotations.SerializedName;

import java.util.List;

@SuppressWarnings("unused")
public class Track {

    @SerializedName("artist")
    private Artist mArtist;
    @SerializedName("@attr")
    private Attr mAttr;
    @SerializedName("image")
    private List<Image> mImage;
    @SerializedName("listeners")
    private String mListeners;
    @SerializedName("mbid")
    private String mMbid;
    @SerializedName("name")
    private String mName;
    @SerializedName("playcount")
    private String mPlaycount;
    @SerializedName("streamable")
    private String mStreamable;
    @SerializedName("url")
    private String mUrl;

    public Artist getArtist() {
        return mArtist;
    }

    public void setArtist(Artist artist) {
        mArtist = artist;
    }

    public Attr getAttr() {
        return mAttr;
    }

    public void setAttr(Attr attr) {
        mAttr = attr;
    }

    public List<Image> getImage() {
        return mImage;
    }

    public void setImage(List<Image> image) {
        mImage = image;
    }

    public String getListeners() {
        return mListeners;
    }

    public void setListeners(String listeners) {
        mListeners = listeners;
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

    public String getPlaycount() {
        return mPlaycount;
    }

    public void setPlaycount(String playcount) {
        mPlaycount = playcount;
    }

    public String getStreamable() {
        return mStreamable;
    }

    public void setStreamable(String streamable) {
        mStreamable = streamable;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

}
