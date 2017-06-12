package com.jahanwalsh.justlyrics.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
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


import java.io.IOException;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

import static java.security.AccessController.getContext;


public class ArtistListActivity extends AppCompatActivity {

    private SharedPreferences mSharedPreferences;
    private String mRecentArtist;

    private Artist mArtist;


    @Bind(R.id.artistNameTextView) TextView mArtistTextView;
    @Bind(R.id.trackTextView) TextView mTrackTextView;
    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;
    @Bind(R.id.saveArtistButton)
    Button mSaveArtistButton;
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

        mArtistTextView.setText("Artist: " + name);
        mTrackTextView.setText("Song : " + track);


        getArtists(name, track);

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        mRecentArtist = mSharedPreferences.getString(Constants.PREFERENCES_ARTIST_KEY, "");
        Log.d("Shared Pref artist", mRecentArtist);
        if (mRecentArtist != null) {
            getArtists(mRecentArtist, null);
        }



    }

    public void onClick(View v) {
        if (v == mSaveArtistButton) {
            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            String uid = user.getUid();

            DatabaseReference artistRef = FirebaseDatabase
                    .getInstance()
                    .getReference(Constants.FIREBASE_CHILD_ARTISTS)
                    .child(uid);

            DatabaseReference pushRef = artistRef.push();
            String pushId = pushRef.getKey();
            mArtist.setPushId(pushId);
            pushRef.setValue(mArtist);

            Toast.makeText(ArtistListActivity.this, "Saved", Toast.LENGTH_SHORT).show();
        }
    }


    private void getArtists(String name, String track) {

        final ArtistService artistService = new ArtistService();

        artistService.findArtist(name, track, new Callback() {


            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) {
                mArtists = artistService.processResults(response);

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