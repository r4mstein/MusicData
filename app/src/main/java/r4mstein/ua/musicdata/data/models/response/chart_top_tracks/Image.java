
package r4mstein.ua.musicdata.data.models.response.chart_top_tracks;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Image {

    @SerializedName("size")
    private String mSize;
    @SerializedName("#text")
    private String mText;

    public String getSize() {
        return mSize;
    }

    public void setSize(String size) {
        mSize = size;
    }

    public String getText() {
        return mText;
    }

    public void setText(String text) {
        mText = text;
    }

}
