package r4mstein.ua.musicdata.utils;

public class Constants {

    public static final String API_KEY = "6f27dbea71d282779c96886a90e61281";
    public static final String API_SECRET = "10cc91d8dbcca451d17149964ecac1cc";

    public static final String BASE_URL = "http://ws.audioscrobbler.com/";
    public static final long LIMIT = 20;
    public static final String FORMAT = "json";

    public static final String ARTIST_INFO_NAME = "artist_name";
    public static final String ARTIST_TOP_ALBUMS = "artist_top_albums";
    public static final String ARTIST_TOP_TRACKS = "artist_top_tracks";
    public static final String ARTIST_SIMILAR = "artist_similar";
    public static final String TRACK_INFO_NAME = "track_info_name";
    public static final String TRACK_INFO_ARTIST = "track_info_artist";

    // requests
    public static final String REQUEST_CHART_TA = "chart.gettopartists";
    public static final String REQUEST_CHART_TT = "chart.gettoptracks";
    public static final String REQUEST_ARTIST_INFO = "artist.getinfo";
    public static final String REQUEST_ARTIST_ALBUMS = "artist.gettopalbums";
    public static final String REQUEST_ARTIST_TRACKS = "artist.gettoptracks";
    public static final String REQUEST_ARTIST_SIMILAR = "artist.getsimilar";
    public static final String REQUEST_TRACK_INFO = "track.getInfo";

    // menu dialog
    public static final String MENU_DIALOG_HEADER = "md_header";
    public static final String MENU_DIALOG_INFO = "md_info";
    public static final String MENU_DIALOG_SIMILAR = "md_similar";
    public static final String MENU_DIALOG_ALBUMS_VISIBILITY = "md_albums_visibility";
    public static final String MENU_DIALOG_TRACKS_VISIBILITY = "md_tracks_visibility";
}
