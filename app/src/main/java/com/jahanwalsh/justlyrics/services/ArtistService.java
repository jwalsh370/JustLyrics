package com.jahanwalsh.justlyrics.services;

import android.util.Log;

import com.jahanwalsh.justlyrics.Constants;
import com.jahanwalsh.justlyrics.models.Artist;

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
            ArrayList<Artist> lyrics = new ArrayList<>();

            try {

                if (response.isSuccessful()) {
                    String jsonData = response.body().string();
                    JSONObject lyricJSON = new JSONObject(jsonData);
                    String name = lyricJSON.getJSONArray("lyrics").getJSONObject(0).getString("name");
//                    String track = lyricJSON.getString("track");

                    Artist instanceOf = new Artist(name);
                    lyrics.add(instanceOf);

                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return lyrics;
        }



}


