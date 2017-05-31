package com.jahanwalsh.justlyrics;

import javax.security.auth.callback.Callback;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import se.akerfeldt.okhttp.signpost.OkHttpOAuthConsumer;
import se.akerfeldt.okhttp.signpost.SigningInterceptor;

/**
 * Created by jahanwalsh on 5/31/17.
 */

public class ArtistService {
    public static void findArtist(String artist, Callback callback) {
        OkHttpOAuthConsumer consumer = new OkHttpOAuthConsumer(Constants.API_CONSUMER_KEY);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new SigningInterceptor(consumer))
                .build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.API_BASE_URL).newBuilder();
        urlBuilder.addQueryParameter(Constants.API_ARTIST_QUERY_PARAMETER, artist);
        String url = urlBuilder.build().toString();

    }
}
