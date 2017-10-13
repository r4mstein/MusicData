
package r4mstein.ua.musicdata.data.models.response.artist_info;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Stats {

    @SerializedName("listeners")
    private String mListeners;
    @SerializedName("playcount")
    private String mPlaycount;

    public String getListeners() {
        return mListeners;
    }

    public void setListeners(String listeners) {
        mListeners = listeners;
    }

    public String getPlaycount() {
        return mPlaycount;
    }

    public void setPlaycount(String playcount) {
        mPlaycount = playcount;
    }

}
