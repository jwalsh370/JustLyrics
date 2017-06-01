package com.jahanwalsh.justlyrics.services;

import android.util.Log;

import com.jahanwalsh.justlyrics.Constants;

import okhttp3.Callback;

import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by jahanwalsh on 5/31/17.
 */

public class ArtistService {

    public static final String TAG = ArtistService.class.getSimpleName();

    public static void findArtist(String artist, Callback callback) {

        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.API_BASE_URL).newBuilder();
        urlBuilder.addQueryParameter(Constants. API_ARTIST_QUERY_PARAMETER,artist);
        urlBuilder.addQueryParameter(Constants.API_KEY_QUERY_PARAMETER, Constants.API_CONSUMER_KEY);
        String url = urlBuilder.build().toString();

        Log.d("url", url);

        Request request = new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }
}

