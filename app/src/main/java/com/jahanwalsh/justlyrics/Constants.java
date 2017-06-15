package com.jahanwalsh.justlyrics;


public class Constants {
    public static final String API_KEY = BuildConfig.API_KEY;
    public static final String API_BASE_URL = "https://api.musixmatch.com/ws/1.1/matcher.lyrics.get?";
    public static final String API_ARTIST_QUERY_PARAMETER = "q_artist";
    public static final String API_KEY_QUERY_PARAMETER = "apikey";
    public static final String API_TRACK_QUERY_PARAMETER= "q_track";
    public static final String API_NEW_URL = "https://api.musixmatch.com/ws/1.1/track.search?";


    public static final String FIREBASE_CHILD_SEARCHED_ARTIST= "searchedArtist";

    public static final String FIREBASE_CHILD_ARTISTS = "artists";

    public static final String PROJECT_URL = "https://developer.musixmatch.com";

    public static final String PREFERENCES_ARTIST_KEY = "artist";

    public static final String FIREBASE_QUERY_INDEX = "index";

    public static final String KEY_SOURCE = "source";
    public static final String SOURCE_SAVED = "saved";
    public static final String SOURCE_FIND = "find";


}
