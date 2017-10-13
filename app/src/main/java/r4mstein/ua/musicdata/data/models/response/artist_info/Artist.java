
package r4mstein.ua.musicdata.data.models.response.artist_info;

import com.google.gson.annotations.SerializedName;

import java.util.List;

@SuppressWarnings("unused")
public class Artist {

    @SerializedName("bio")
    private Bio mBio;
    @SerializedName("image")
    private List<Image> mImage;
    @SerializedName("mbid")
    private String mMbid;
    @SerializedName("name")
    private String mName;
    @SerializedName("ontour")
    private String mOntour;
    @SerializedName("similar")
    private Similar mSimilar;
    @SerializedName("stats")
    private Stats mStats;
    @SerializedName("streamable")
    private String mStreamable;
    @SerializedName("tags")
    private Tags mTags;
    @SerializedName("url")
    private String mUrl;

    public Bio getBio() {
        return mBio;
    }

    public void setBio(Bio bio) {
        mBio = bio;
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

    public String getOntour() {
        return mOntour;
    }

    public void setOntour(String ontour) {
        mOntour = ontour;
    }

    public Similar getSimilar() {
        return mSimilar;
    }

    public void setSimilar(Similar similar) {
        mSimilar = similar;
    }

    public Stats getStats() {
        return mStats;
    }

    public void setStats(Stats stats) {
        mStats = stats;
    }

    public String getStreamable() {
        return mStreamable;
    }

    public void setStreamable(String streamable) {
        mStreamable = streamable;
    }

    public Tags getTags() {
        return mTags;
    }

    public void setTags(Tags tags) {
        mTags = tags;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

}
