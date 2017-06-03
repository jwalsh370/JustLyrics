package com.jahanwalsh.justlyrics.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

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



public class ArtistListActivity extends AppCompatActivity {
    @Bind(R.id.songTextView)
    public TextView mSongTextView;
    @Bind(R.id.listView)
    ListView mListView;

    public static final String TAG = ArtistListActivity.class.getSimpleName();
    public ArrayList<Artist> mArtists = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        mSongTextView.setText("Here are all the songs by: " + name);
        getArtists(name);
    }

    private void getArtists(String name) {
        final ArtistService artistService = new ArtistService();
        artistService.findArtist(name, new Callback(){

            @Override
            public void onFailure(Call call, IOException e) {

                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response)
            {
                mArtists = artistService.processResults(response);
                ArtistListActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        String[] artistNames = new String[mArtists.size()];
                        for (int i = 0; i < artistNames.length; i++) {
                            artistNames[i] = mArtists.get(i).getName();
                        }

                        ArrayAdapter adapter = new ArrayAdapter(ArtistListActivity.this,
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