//<<<<<<< HEAD
////package com.jahanwalsh.justlyrics.services;
////
////import android.util.Log;
////
////import com.jahanwalsh.justlyrics.Constants;
////import com.jahanwalsh.justlyrics.models.Artist;
////
////import org.json.JSONArray;
////import org.json.JSONException;
////import org.json.JSONObject;
////
////import java.io.IOException;
////import java.util.ArrayList;
////
////import okhttp3.Call;
////import okhttp3.Callback;
////import okhttp3.HttpUrl;
////import okhttp3.OkHttpClient;
////import okhttp3.Request;
////import okhttp3.Response;
////
////
////public class LyricService {
////
////    public static void findArtist(String name, String track, Callback callback) {
////        OkHttpClient client = new OkHttpClient.Builder()
////                .build();
////        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.API_NEW_URL).newBuilder();
////        urlBuilder.addQueryParameter("format", "json");
////        urlBuilder.addQueryParameter("callback", "callback");
////        urlBuilder.addQueryParameter(Constants.API_TRACK_QUERY_PARAMETER, track);
////        urlBuilder.addQueryParameter(Constants.API_ARTIST_QUERY_PARAMETER, name);
////        urlBuilder.addQueryParameter(Constants.API_KEY_QUERY_PARAMETER, Constants.API_KEY);
////
////        String url = urlBuilder.build().toString();
////        Request request = new Request.Builder()
////                .url(url)
////                .build();
////        Call call = client.newCall(request);
////        call.enqueue(callback);
////    }
////
////    public ArrayList<Artist> processResults(Response response) {
////        ArrayList<Artist> lyrics = new ArrayList<>();
////
////        try {
////            String jsonData = response.body().string();
////            if (response.isSuccessful()) {
////                JSONObject musicJSON = new JSONObject(jsonData);
////                JSONObject bodyJSON = musicJSON.getJSONObject("message").getJSONObject("body");
////                JSONObject albumsJSON = bodyJSON.getJSONObject("track_list");
////
////                Log.d("ALL ALBUMS", albumsJSON.toString());
////
////                for (int i = 0; i < albumsJSON.length(); i++) {
////
////                    JSONObject artistJSON = albumsJSON.getJSONObject("track_list");
////                    String name = artistJSON.getString("artist_name");
////                    String track = artistJSON.getString("track_name");
////                    String img = artistJSON.getString("album_coverart_350x350");
//////                    String lyric = artistJSON.getString("lyrics_body");
////
////
////                    Artist artist = new Artist(name,track, img, null);
////                   lyrics.add(artist);
////                    Log.i("artistreturnedLog", "processResults() in Service");
////                }
////
////            }
////
////        } catch (IOException e) {
////            e.printStackTrace();
////        } catch (JSONException e) {
////            e.printStackTrace();
////        }
////        return lyrics;
////    }
////}
////
////
//=======
//package com.jahanwalsh.justlyrics.services;
//
//import android.util.Log;
//
//import com.jahanwalsh.justlyrics.Constants;
//import com.jahanwalsh.justlyrics.models.Artist;
//
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import java.io.IOException;
//import java.util.ArrayList;
//
//import okhttp3.Call;
//import okhttp3.Callback;
//import okhttp3.HttpUrl;
//import okhttp3.OkHttpClient;
//import okhttp3.Request;
//import okhttp3.Response;
//
//
//public class LyricService {
//
//    public static void findArtist(String name, String track, Callback callback) {
//        OkHttpClient client = new OkHttpClient.Builder()
//                .build();
//        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.API_NEW_URL).newBuilder();
//        urlBuilder.addQueryParameter("format", "json");
//        urlBuilder.addQueryParameter("callback", "callback");
//        urlBuilder.addQueryParameter(Constants.API_TRACK_QUERY_PARAMETER, track);
//        urlBuilder.addQueryParameter(Constants.API_ARTIST_QUERY_PARAMETER, name);
//        urlBuilder.addQueryParameter(Constants.API_KEY_QUERY_PARAMETER, Constants.API_KEY);
//
//        String url = urlBuilder.build().toString();
//        Request request = new Request.Builder()
//                .url(url)
//                .build();
//        Call call = client.newCall(request);
//        call.enqueue(callback);
//    }
//
//    public ArrayList<Artist> processResults(Response response) {
//        ArrayList<Artist> lyrics = new ArrayList<>();
//
//        try {
//            String jsonData = response.body().string();
//            if (response.isSuccessful()) {
//                JSONObject musicJSON = new JSONObject(jsonData);
//                JSONObject bodyJSON = musicJSON.getJSONObject("message").getJSONObject("body");
//                JSONObject albumsJSON = bodyJSON.getJSONObject("track_list");
//
//                Log.d("ALL ALBUMS", albumsJSON.toString());
//
//                for (int i = 0; i < albumsJSON.length(); i++) {
//
//                    JSONObject artistJSON = albumsJSON.getJSONObject("track_list");
//                    String name = artistJSON.getString("artist_name");
//                    String track = artistJSON.getString("track_name");
//                    String img = artistJSON.getString("album_coverart_350x350");
////                    String lyric = artistJSON.getString("lyrics_body");
//
//
//                    Artist artist = new Artist(name,track, img, null);
//                   lyrics.add(artist);
//                    Log.i("artistreturnedLog", "processResults() in Service");
//                }
//
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        return lyrics;
//    }
//}
//
//
//
