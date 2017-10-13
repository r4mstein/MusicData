
package r4mstein.ua.musicdata.data.models.response.artist_info;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Bio {

    @SerializedName("content")
    private String mContent;
    @SerializedName("links")
    private Links mLinks;
    @SerializedName("published")
    private String mPublished;
    @SerializedName("summary")
    private String mSummary;

    public String getContent() {
        return mContent;
    }

    public void setContent(String content) {
        mContent = content;
    }

    public Links getLinks() {
        return mLinks;
    }

    public void setLinks(Links links) {
        mLinks = links;
    }

    public String getPublished() {
        return mPublished;
    }

    public void setPublished(String published) {
        mPublished = published;
    }

    public String getSummary() {
        return mSummary;
    }

    public void setSummary(String summary) {
        mSummary = summary;
    }

}
