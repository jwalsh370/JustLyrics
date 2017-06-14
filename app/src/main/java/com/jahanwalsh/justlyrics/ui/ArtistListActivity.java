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
<<<<<<< HEAD
import android.widget.ArrayAdapter;
=======
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
>>>>>>> parent of 610fc9a... add new service for second api query call
import android.widget.TextView;
import android.widget.Toast;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.jahanwalsh.justlyrics.Constants;
import com.jahanwalsh.justlyrics.R;
import com.jahanwalsh.justlyrics.adapters.ArtistListAdapter;
import com.jahanwalsh.justlyrics.models.Artist;
import com.jahanwalsh.justlyrics.services.ArtistService;
<<<<<<< HEAD
import com.jahanwalsh.justlyrics.services.LyricService;
=======
>>>>>>> parent of 610fc9a... add new service for second api query call


import java.io.IOException;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

import static java.security.AccessController.getContext;


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

    public ArrayList<Artist> mLyrics = new ArrayList<>();

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

        getLyrics(name, track);
        getArtist(name, track);


        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        mRecentArtist = mSharedPreferences.getString(Constants.PREFERENCES_ARTIST_KEY, "");
        Log.d("Shared Pref artist", mRecentArtist);
        if (mRecentArtist != null) {
            getLyrics(mRecentArtist, null);
        }


    }


    private void getLyrics(String name, String track) {

        final ArtistService artistService = new ArtistService();

        artistService.findArtist(name, track, new Callback() {


            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) {
<<<<<<< HEAD
                mLyrics = lyricService.processResults(response);
=======
                mArtists = artistService.processResults(response);
>>>>>>> parent of 610fc9a... add new service for second api query call

                ArtistListActivity.this.runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        mAdapter = new ArtistListAdapter(getApplicationContext(), mLyrics);
                        mRecyclerView.setAdapter(mAdapter);
                        RecyclerView.LayoutManager layoutManager =
                                new LinearLayoutManager(ArtistListActivity.this);
                        mRecyclerView.setLayoutManager(layoutManager);
                        mRecyclerView.setHasFixedSize(true);
                    }
                });

//
            }
        });
    }

    private void getArtist(String name, String track) {

        final ArtistService artistService = new ArtistService();

        artistService.findArtist(name, track, new Callback() {


            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) {
                final ArrayList<Artist> mArtists = artistService.processResults(response);

                ArtistListActivity.this.runOnUiThread(new Runnable() {

                    @Override
                    public void run() {

                        String[] artistNames = new String[mArtists.size()];
                        for (int i = 0; i < artistNames.length; i++) {
                            artistNames[i] = mArtists.get(i).getName();
                        }

                        ArrayAdapter adapter = new ArrayAdapter(ArtistListActivity.this,
                                android.R.layout.simple_list_item_1, artistNames);

                        for (Artist artist : mArtists) {
                            Log.d(TAG, "Name: " + artist.getName());
                            Log.d(TAG, "Phone: " + artist.getTrack());
                            Log.d(TAG, "Website: " + artist.getAlbumArt());

                            mAdapter = new ArtistListAdapter(getApplicationContext(), mArtists);
                            mRecyclerView.setAdapter(mAdapter);
                            RecyclerView.LayoutManager layoutManager =
                                    new LinearLayoutManager(ArtistListActivity.this);
                            mRecyclerView.setLayoutManager(layoutManager);
                            mRecyclerView.setHasFixedSize(true);
                        }
                    }

//
                });
            }
        });


    }
}