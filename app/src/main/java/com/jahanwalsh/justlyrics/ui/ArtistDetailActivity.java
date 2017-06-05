package com.jahanwalsh.justlyrics.ui;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.jahanwalsh.justlyrics.R;
import com.jahanwalsh.justlyrics.adapters.ArtistListAdapter;
import com.jahanwalsh.justlyrics.adapters.ArtistPagerAdapter;
import com.jahanwalsh.justlyrics.models.Artist;
import com.jahanwalsh.justlyrics.services.ArtistService;

import org.parceler.Parcels;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class ArtistDetailActivity extends AppCompatActivity {
    @Bind(R.id.viewPager) ViewPager mViewPager;
    private ArtistPagerAdapter adapterViewPager;
    ArrayList<Artist> mArtists = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist_detail);
        ButterKnife.bind(this);


        mArtists = Parcels.unwrap(getIntent().getParcelableExtra("artist"));
        int startingPosition = getIntent().getIntExtra("position", 0);

        adapterViewPager = new ArtistPagerAdapter(getSupportFragmentManager(), mArtists);
        mViewPager.setAdapter(adapterViewPager);
        mViewPager.setCurrentItem(startingPosition);
    }
}
