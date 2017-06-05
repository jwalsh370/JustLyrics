package com.jahanwalsh.justlyrics.ui;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;
import android.widget.TextView;

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

public class ArtistActivity {
    public class ArtistListActivity extends AppCompatActivity {
        @Bind(R.id.recyclerView)
        RecyclerView mRecyclerView;
        private ArtistListAdapter mAdapter;
        public ArrayList<Artist> mArtists = new ArrayList<>();

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_artist);
            ButterKnife.bind(this);

            Intent intent = getIntent();
            String name = intent.getStringExtra("name");
            getArtists(name);
        }

        private void getArtists(String name) {
            final ArtistService artistService = new ArtistService();
            artistService.findArtist(name, new Callback() {

                @Override
                public void onFailure(Call call, IOException e) {
                    e.printStackTrace();
                }

                @Override
                public void onResponse(Call call, Response response) {
                    mArtists = artistService.processResults(response);

//                    ArtistActivity.this.runOnUiThread(new Runnable() {
//
//                        @Override
//                        public void run() {
//                            mAdapter = new ArtistListAdapter(getApplicationContext(), mArtists);
//                            mRecyclerView.setAdapter(mAdapter);
//                            RecyclerView.LayoutManager layoutManager =
//                                    new LinearLayoutManager(ArtistActivity.this);
//                            mRecyclerView.setLayoutManager(layoutManager);
//                            mRecyclerView.setHasFixedSize(true);
//
//                        }
//
//                    });
                }
            });
        }
    }
}
