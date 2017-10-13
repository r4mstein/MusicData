
package r4mstein.ua.musicdata.data.models.response.artist_info;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Link {

    @SerializedName("href")
    private String mHref;
    @SerializedName("rel")
    private String mRel;
    @SerializedName("#text")
    private String mText;

    public String getHref() {
        return mHref;
    }

    public void setHref(String href) {
        mHref = href;
    }

    public String getRel() {
        return mRel;
    }

    public void setRel(String rel) {
        mRel = rel;
    }

    public String getText() {
        return mText;
    }

    public void setText(String text) {
        mText = text;
    }

}
