package com.jahanwalsh.justlyrics.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.jahanwalsh.justlyrics.MyArtistArrayAdapter;
import com.jahanwalsh.justlyrics.R;

import butterknife.Bind;
import butterknife.ButterKnife;



public class ArtistActivity extends AppCompatActivity {
    @Bind(R.id.songTextView)
    public TextView mSongTextView;
    @Bind(R.id.listView)
    ListView mListView;

//    public static final String TAG = ArtistActivity.class.getSimpleName();

    private String[] artists = new String[] {"MF Doom", "Cricket", "Prince", "Tupac"};
    private String[]  songs = new String[] {"Beer", "Breakfast", "Raspberry Beret", "California Love"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist);
        ButterKnife.bind(this);

        mListView = (ListView) findViewById(R.id.listView);
        mSongTextView = (TextView) findViewById(R.id.songTextView);

        MyArtistArrayAdapter adapter = new MyArtistArrayAdapter(this, android.R.layout.simple_list_item_1,
                artists, songs); //must match constructor!

//        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, artists);

        mListView.setAdapter(adapter);


        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String artists = ((TextView)view).getText().toString();
                Toast.makeText(ArtistActivity.this, artists, Toast.LENGTH_LONG).show();
            }
        });

        Intent intent = getIntent();
        String song = intent.getStringExtra("song");
        mSongTextView.setText("This artist has: " + song);

    }
}