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

/**
 * Created by jahanwalsh on 5/31/17.
 */

public class ArtistService {


    public static void findArtist(String artist, Callback callback) {
         String TAG = ArtistService.class.getSimpleName();

        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.API_BASE_URL).newBuilder();
        urlBuilder.addQueryParameter(Constants.API_ARTIST_QUERY_PARAMETER, artist);
        urlBuilder.addQueryParameter(Constants.API_KEY_QUERY_PARAMETER, Constants.API_CONSUMER_KEY);
        String url = urlBuilder.build().toString();

        Log.d("url", url);

        Request request = new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }
    public ArrayList<Artist> processResults(Response response) {
        ArrayList<Artist> artist = new ArrayList<>();


        try {

            if (response.isSuccessful()) {
                String jsonData = response.body().string();

                JSONObject artistJSON = new JSONObject(jsonData);
                String artists = artistJSON.getJSONArray("artist").getJSONObject(0).getString("artists");


                Artist instanceOf = new Artist(artists);
                artist.add(instanceOf);

            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (JSONException e) {
            e.printStackTrace();
        }
        return artist;
    }

}


