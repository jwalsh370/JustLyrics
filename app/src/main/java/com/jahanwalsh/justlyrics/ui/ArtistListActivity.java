package com.jahanwalsh.justlyrics.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.jahanwalsh.justlyrics.Constants;
import com.jahanwalsh.justlyrics.R;
import com.jahanwalsh.justlyrics.adapters.ArtistListAdapter;
import com.jahanwalsh.justlyrics.models.Artist;
import com.jahanwalsh.justlyrics.services.ArtistService;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;



public class ArtistListActivity extends AppCompatActivity {

    private SharedPreferences mSharedPreferences;
    private String mRecentArtist;

    public static final String TAG = ArtistListActivity.class.getSimpleName();


    @Bind(R.id.artistNameTextView)
    TextView mArtistTextView;
    @Bind(R.id.trackTextView)
    TextView mTrackTextView;
    @Bind(R.id.recyclerView)
    RecyclerView mRecyclerView;

    private ArtistListAdapter mAdapter;

    public ArrayList<Artist> mArtists = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artists);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String name = intent.getStringExtra("artist");
        String track = intent.getStringExtra("track");

        mArtistTextView.setText("Hey! Your artist " + name + " is just a click away!");
        mTrackTextView.setText("The lyrics for " + track + " are loading... click in the center of the page to continue. ");

        Typeface streets = Typeface.createFromAsset(getAssets(), "fonts/streets.ttf");
        mArtistTextView.setTypeface(streets);
        mTrackTextView.setTypeface(streets);

        getLyrics(name, track);



        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        mRecentArtist = mSharedPreferences.getString(Constants.PREFERENCES_ARTIST_KEY, "");
        if (mRecentArtist != null) {
            getLyrics(mRecentArtist, null);
        }


    }

    public void getLyrics(final String name, final String track) {

        final ArtistService artistService = new ArtistService();
        artistService.findLyrics(name, track, new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) {
                mArtists = artistService.processResults(response);
                getLyrics(name, track);

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
