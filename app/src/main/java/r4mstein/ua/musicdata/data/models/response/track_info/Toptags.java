
package r4mstein.ua.musicdata.data.models.response.track_info;

import com.google.gson.annotations.SerializedName;

import java.util.List;

@SuppressWarnings("unused")
public class Toptags {

    @SerializedName("tag")
    private List<Tag> mTag;

    public List<Tag> getTag() {
        return mTag;
    }

    public void setTag(List<Tag> tag) {
        mTag = tag;
    }

}
