package com.jahanwalsh.justlyrics.ui;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.graphics.Typeface;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.jahanwalsh.justlyrics.Constants;
import com.jahanwalsh.justlyrics.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private DatabaseReference mSearchedArtistReference;

    private ValueEventListener mSearchedArtistReferenceListener;

    @Bind(R.id.button) Button mButton;
    @Bind(R.id.aboutButton) Button mAboutButton;
    @Bind(R.id.artistEditText) EditText mArtistEditText;
    @Bind(R.id.trackEditText) EditText mTrackEditText;
    @Bind(R.id.appNameTextView) TextView mAppNameTextView;
    @Bind(R.id.savedArtistsButton) Button mSavedArtistsButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mSearchedArtistReference = FirebaseDatabase
                .getInstance()
                .getReference()
                .child(Constants.FIREBASE_CHILD_SEARCHED_ARTIST);

        mSearchedArtistReferenceListener = mSearchedArtistReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot artistSnapshot : dataSnapshot.getChildren()) {
                    String artist = artistSnapshot.getValue().toString();
                    Log.d("artist updated", "artist: " + artist);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Typeface streets = Typeface.createFromAsset(getAssets(), "fonts/streets.ttf");
        mAppNameTextView.setTypeface(streets);

        mButton.setOnClickListener(this);
        mAboutButton.setOnClickListener(this);
        mSavedArtistsButton.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        if (v == mButton) {
            String artist = mArtistEditText.getText().toString();
            String track = mTrackEditText.getText().toString();

            saveArtistToFirebase(artist);

            if (artist.length() == 0)  {
                mArtistEditText.setError("This field is Required!");
            } else if  (track.length() == 0) {
                mTrackEditText.setError("This field is Required!");
            } else {

                Intent intent = new Intent(MainActivity.this, ArtistListActivity.class);
                intent.putExtra("artist", artist);
                intent.putExtra("track", track);
                startActivity(intent);
                Toast.makeText(MainActivity.this, "Searching for your song...", Toast.LENGTH_LONG).show();
            }

        }
        if(v == mAboutButton) {
            Intent aboutIntent = new Intent(MainActivity.this, AboutActivity.class);
            startActivity(aboutIntent);
        }

        if (v == mSavedArtistsButton) {
            Intent intent = new Intent(MainActivity.this, SavedArtistListActivity.class);
            startActivity(intent);
        }
    }

    public void saveArtistToFirebase(String artist) {
        mSearchedArtistReference.push().setValue(artist);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mSearchedArtistReference.removeEventListener(mSearchedArtistReferenceListener);
    }

}



