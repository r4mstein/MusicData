
package r4mstein.ua.musicdata.data.models.response.chart_top_artists;

import com.google.gson.annotations.SerializedName;

import java.util.List;

@SuppressWarnings("unused")
public class Artist {

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
