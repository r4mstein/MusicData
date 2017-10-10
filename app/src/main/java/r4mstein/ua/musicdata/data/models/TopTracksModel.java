package r4mstein.ua.musicdata.data.models;

@SuppressWarnings("unused")
public class TopTracksModel {

    private String photoURL;
    private String name;
    private String track;

    public String getPhotoURL() {
        return photoURL;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTrack() {
        return track;
    }

    public void setTrack(String track) {
        this.track = track;
    }
}
