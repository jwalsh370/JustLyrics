package com.jahanwalsh.justlyrics.ui;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.graphics.Typeface;

import com.jahanwalsh.justlyrics.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.button) Button mButton;
    @Bind(R.id.aboutButton) Button mAboutButton;
    @Bind(R.id.artistEditText) EditText mArtistEditText;
    @Bind(R.id.trackEditText) EditText mTrackEditText;
    @Bind(R.id.appNameTextView) TextView mAppNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Typeface streets = Typeface.createFromAsset(getAssets(), "fonts/streets.ttf");
        mAppNameTextView.setTypeface(streets);

        mButton.setOnClickListener(this);
        mAboutButton.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        if (v == mButton) {
            String artist = mArtistEditText.getText().toString();
            String track = mTrackEditText.getText().toString();
            if (artist.length() == 0)  {
                mArtistEditText.setError("This field is Required!");
            } else if  (track.length() == 0) {
                mTrackEditText.setError("This field is Required!");
            } else {
                Intent intent = new Intent(MainActivity.this, ArtistActivity.class);
                intent.putExtra("artist", artist);
                startActivity(intent);
            }


        }
        if(v == mAboutButton) {
            Intent aboutIntent = new Intent(MainActivity.this, AboutActivity.class);
            startActivity(aboutIntent);
        }
    }


}
