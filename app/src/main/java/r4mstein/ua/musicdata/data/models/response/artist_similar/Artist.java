
package r4mstein.ua.musicdata.data.models.response.artist_similar;

import com.google.gson.annotations.SerializedName;

import java.util.List;

@SuppressWarnings("unused")
public class Artist {

    @SerializedName("image")
    private List<Image> mImage;
    @SerializedName("match")
    private String mMatch;
    @SerializedName("mbid")
    private String mMbid;
    @SerializedName("name")
    private String mName;
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

    public String getMatch() {
        return mMatch;
    }

    public void setMatch(String match) {
        mMatch = match;
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
