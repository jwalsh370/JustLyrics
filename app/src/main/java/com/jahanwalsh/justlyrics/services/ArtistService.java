package com.jahanwalsh.justlyrics.services;

import android.util.Log;

import com.jahanwalsh.justlyrics.Constants;
import com.jahanwalsh.justlyrics.models.Artist;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Callback;

import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class ArtistService {

    public static void findArtist(String name, String track, Callback callback) {
        OkHttpClient client = new OkHttpClient.Builder()
                .build();
        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.API_BASE_URL).newBuilder();
        urlBuilder.addQueryParameter("format", "json");
        urlBuilder.addQueryParameter("callback", "callback");
        urlBuilder.addQueryParameter(Constants.API_TRACK_QUERY_PARAMETER, track);
        urlBuilder.addQueryParameter(Constants.API_ARTIST_QUERY_PARAMETER, name);
        urlBuilder.addQueryParameter("quorum_factor", "1");
        urlBuilder.addQueryParameter(Constants.API_KEY_QUERY_PARAMETER, Constants.API_KEY);

        String url = urlBuilder.build().toString();
        Log.d("test", url);

        Request request = new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    public ArrayList<Artist> processResults(Response response) {
        ArrayList<Artist> artists = new ArrayList<>();

        try {
            String jsonData = response.body().string();
            if (response.isSuccessful()) {
                Log.v("TEST", "processResults() in Service");
                Log.d("test2", jsonData);
                JSONObject musicJSON = new JSONObject(jsonData);
                JSONArray artistsJSON = musicJSON.getJSONObject("message").getJSONObject("body").getJSONArray("track_list");

                for (int i = 0; i < artistsJSON.length(); i++) {
                    JSONObject artistJSON = artistsJSON.getJSONObject(i);
                    String name = artistJSON.getJSONObject("track").getString("artist_name");
                    String track = artistJSON.getJSONObject("track").getString("track_name");
                    String img = artistJSON.getJSONObject("track").getString("album_coverart_100x100");

                    Artist artist = new Artist(name, track, img);
                    artists.add(artist);
                    Log.v("JSON2", "LOG AT END OF FOR LOOP processResults() in Service");

                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return artists;

    }

}


