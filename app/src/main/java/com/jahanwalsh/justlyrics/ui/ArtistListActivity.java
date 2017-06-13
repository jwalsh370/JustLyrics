package com.jahanwalsh.justlyrics.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;


import com.jahanwalsh.justlyrics.Constants;
import com.jahanwalsh.justlyrics.R;
import com.jahanwalsh.justlyrics.adapters.ArtistListAdapter;
import com.jahanwalsh.justlyrics.models.Artist;
import com.jahanwalsh.justlyrics.services.LyricService;


import java.io.IOException;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;


public class ArtistListActivity extends AppCompatActivity {

    private SharedPreferences mSharedPreferences;
    private String mRecentArtist;

    private Artist mArtist;


    @Bind(R.id.artistNameTextView) TextView mArtistTextView;
    @Bind(R.id.trackTextView) TextView mTrackTextView;
    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;

    private ArtistListAdapter mAdapter;

    public ArrayList<Artist> mArtists = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.artist_activity);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String name = intent.getStringExtra("artist");
        String track = intent.getStringExtra("track");

        mArtistTextView.setText("Hey! Your artist " + name + " is just a click away!");
        mTrackTextView.setText("The lyrics for " + track + " are loading... click in the center of the page to continue. ");

        Typeface streets = Typeface.createFromAsset(getAssets(), "fonts/streets.ttf");
        mArtistTextView.setTypeface(streets);
        mTrackTextView.setTypeface(streets);

        getArtists(name, track);



        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        mRecentArtist = mSharedPreferences.getString(Constants.PREFERENCES_ARTIST_KEY, "");
        Log.d("Shared Pref artist", mRecentArtist);
        if (mRecentArtist != null) {
            getArtists(mRecentArtist, null);
        }



    }




    private void getArtists(String name, String track) {

        final LyricService lyricService = new LyricService();

        lyricService.findArtist(name, track, new Callback() {


            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) {
                mArtists = lyricService.processResults(response);

                ArtistListActivity.this.runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        mAdapter = new ArtistListAdapter(getApplicationContext(), mArtists);
                        mRecyclerView.setAdapter(mAdapter);
                        RecyclerView.LayoutManager layoutManager =
                                new LinearLayoutManager(ArtistListActivity.this);
                        mRecyclerView.setLayoutManager(layoutManager);
                        mRecyclerView.setHasFixedSize(true);
                    }
                });
            }
        });
    }


}