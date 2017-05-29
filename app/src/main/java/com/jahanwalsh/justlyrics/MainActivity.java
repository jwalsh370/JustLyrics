package com.jahanwalsh.justlyrics;


import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.graphics.Typeface;

//public class MainActivity extends AppCompatActivity {
//    private Button mFindRestaurantsButton;
//    private EditText mLocationEditText;
//    private TextView mAppNameTextView;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        mLocationEditText = (EditText) findViewById(R.id.locationEditText);
//        mFindRestaurantsButton = (Button) findViewById(R.id.findRestaurantsButton);
//        mAppNameTextView = (TextView) findViewById(R.id.appNameTextView);
//        Typeface ostrichFont = Typeface.createFromAsset(getAssets(), "fonts/ostrich-regular.ttf");
//        mAppNameTextView.setTypeface(ostrichFont);
//
//        mFindRestaurantsButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String location = mLocationEditText.getText().toString();
//                Intent intent = new Intent(MainActivity.this, RestaurantsActivity.class);
//                intent.putExtra("location", location);
//                startActivity(intent);
//            }
//        });
//    }
//}

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.button) Button mButton;
    @Bind(R.id.artistEditText) EditText mArtistEditText;
    @Bind(R.id.justLyricsTextView) TextView mjustLyricsTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Typeface streets = Typeface.createFromAsset(getAssets(), "fonts/streets.ttf");
        mjustLyricsTextView.setTypeface(streets);

        mButton.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        if (v == mButton) {
            String artist = mArtistEditText.getText().toString();
            Intent intent = new Intent(MainActivity.this, ArtistActivity.class);
            intent.putExtra("artist", artist);
            startActivity(intent);
        }
    }
}
