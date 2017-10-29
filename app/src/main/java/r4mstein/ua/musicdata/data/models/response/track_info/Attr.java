
package r4mstein.ua.musicdata.data.models.response.track_info;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Attr {

    @SerializedName("position")
    private String mPosition;

    public String getPosition() {
        return mPosition;
    }

    public void setPosition(String position) {
        mPosition = position;
    }

}
