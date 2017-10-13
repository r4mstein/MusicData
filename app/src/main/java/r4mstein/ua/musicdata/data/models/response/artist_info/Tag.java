
package r4mstein.ua.musicdata.data.models.response.artist_info;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Tag {

    @SerializedName("name")
    private String mName;
    @SerializedName("url")
    private String mUrl;

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
