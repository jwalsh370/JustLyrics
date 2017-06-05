package com.jahanwalsh.justlyrics.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.jahanwalsh.justlyrics.R;
import com.jahanwalsh.justlyrics.adapters.ArtistListAdapter;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist);


    }

//    private void getArtists(String name) {
//        final ArtistService artistService = new ArtistService();
//        artistService.findArtist(name, new Callback(){
//
//            @Override
//            public void onFailure(Call call, IOException e) {
//                e.printStackTrace();
//            }
//
//            @Override
//            public void onResponse(Call call, Response response)
//            {
//                mArtists = artistService.processResults(response);
//
//                ArtistListActivity.this.runOnUiThread(new Runnable() {
//
//                    @Override
//                    public void run() {
//                        mAdapter = new ArtistListAdapter(getApplicationContext(), mArtists);
//                        mRecyclerView.setAdapter(mAdapter);
//                        RecyclerView.LayoutManager layoutManager =
//                                new LinearLayoutManager(ArtistListActivity.this);
//                        mRecyclerView.setLayoutManager(layoutManager);
//                        mRecyclerView.setHasFixedSize(true);
//
//                    }
//
//                });
//            }
//        });
//    }
}