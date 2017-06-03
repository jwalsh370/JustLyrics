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
    public static final String TAG = ArtistService.class.getSimpleName();

    public static void findArtist(String name, Callback callback) {
        OkHttpClient client = new OkHttpClient.Builder()
                .build();
        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.API_BASE_URL).newBuilder();
        urlBuilder.addQueryParameter("format", "json");
        urlBuilder.addQueryParameter("callback", "callback");
        urlBuilder.addQueryParameter(Constants.API_ARTIST_QUERY_PARAMETER, name);
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
        ArrayList<Artist> lyric = new ArrayList<>();

        try {
            String jsonData = response.body().string();
            if (response.isSuccessful()) {
                Log.v("TEST", "processResults() in Service");
                JSONObject musicJSON = new JSONObject(jsonData);
                JSONArray lyricsJSON = musicJSON.getJSONArray("results");
                for (int i = 0; i < 100; i++) {
                    JSONObject lyricJSON = lyricsJSON.getJSONObject(i);
                    String name = lyricJSON.getString("name");

                    Artist artist = new Artist(name);
                    lyric.add(artist);
                    Log.v("JSON2", "LOG AT END OF FOR LOOP processResults() in Service");

                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return lyric;
    }

}


