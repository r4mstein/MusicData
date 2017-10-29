
package r4mstein.ua.musicdata.data.models.response.track_info;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Streamable {

    @SerializedName("fulltrack")
    private String mFulltrack;
    @SerializedName("#text")
    private String mText;

    public String getFulltrack() {
        return mFulltrack;
    }

    public void setFulltrack(String fulltrack) {
        mFulltrack = fulltrack;
    }

    public String getText() {
        return mText;
    }

    public void setText(String text) {
        mText = text;
    }

}
