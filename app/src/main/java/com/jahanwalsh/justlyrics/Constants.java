package com.jahanwalsh.justlyrics;


public class Constants {
    public static final String API_KEY = BuildConfig.API_KEY;
    public static final String API_BASE_URL = "https://api.musixmatch.com/ws/1.1/matcher.lyrics.get?format=jsonp&callback=callback&q_track=";
    public static final String API_ARTIST_QUERY_PARAMETER = "name";
    public static final String API_TRACK_QUERY_PARAMETER = "track"+"&q_artist=";


}
