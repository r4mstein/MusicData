
package r4mstein.ua.musicdata.data.models.response.artist_info;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Links {

    @SerializedName("link")
    private Link mLink;

    public Link getLink() {
        return mLink;
    }

    public void setLink(Link link) {
        mLink = link;
    }

}
