package com.jahanwalsh.justlyrics.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.jahanwalsh.justlyrics.MyArtistArrayAdapter;
import com.jahanwalsh.justlyrics.R;
import com.jahanwalsh.justlyrics.models.Artist;
import com.jahanwalsh.justlyrics.services.ArtistService;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;



public class ArtistActivity extends AppCompatActivity {
    @Bind(R.id.songTextView)
    public TextView mSongTextView;
    @Bind(R.id.listView)
    ListView mListView;

    public static final String TAG = ArtistActivity.class.getSimpleName();

    private String[] artists = new String[]{"MF Doom", "Cricket", "Prince", "Tupac"};
    private String[] songs = new String[]{"Beer", "Breakfast", "Raspberry Beret", "California Love"};
    public ArrayList<Artist> mArtists = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist);
        ButterKnife.bind(this);

        mListView = (ListView) findViewById(R.id.listView);
        mSongTextView = (TextView) findViewById(R.id.songTextView);

        MyArtistArrayAdapter adapter = new MyArtistArrayAdapter(this, android.R.layout.simple_list_item_1,
                artists, songs); //must match constructor!


        mListView.setAdapter(adapter);


        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String name = ((TextView) view).getText().toString();
                Toast.makeText(ArtistActivity.this, name, Toast.LENGTH_LONG).show();
            }
        });

        Intent intent = getIntent();
         String artist = "prince";
        getArtists(artist);
    }

    private void getArtists(String name) {
        final ArtistService artistService = new ArtistService();
        artistService.findArtist(name, new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    String jsonData = response.body().string();
                    if (response.isSuccessful()) {
                        Log.v(TAG, jsonData);
                        mArtists = artistService.processResults(response);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            ArtistActivity.this.runOnUiThread(new Runnable() {

                @Override
                public void run () {

                    String[] artistNames = new String[mArtists.size()];
                    for (int i = 0; i < artistNames.length; i++) {
                        artistNames[i] = mArtists.get(i).getName();
                    }

                    ArrayAdapter adapter = new ArrayAdapter(ArtistActivity.this,
                            android.R.layout.simple_list_item_1, artistNames);
                    mListView.setAdapter(adapter);

                    for (Artist artist : mArtists) {
                        Log.d(TAG, "Name: " + artist.getName());
                    }

                }
             });

            }

        });
    }


}