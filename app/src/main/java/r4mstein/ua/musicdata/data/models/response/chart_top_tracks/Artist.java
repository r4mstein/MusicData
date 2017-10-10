
package r4mstein.ua.musicdata.data.models.response.chart_top_tracks;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Artist {

    @SerializedName("mbid")
    private String mMbid;
    @SerializedName("name")
    private String mName;
    @SerializedName("url")
    private String mUrl;

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

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

}
