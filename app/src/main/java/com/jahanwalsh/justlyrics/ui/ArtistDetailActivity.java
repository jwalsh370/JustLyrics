package com.jahanwalsh.justlyrics.ui;


import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;


import com.jahanwalsh.justlyrics.R;
import com.jahanwalsh.justlyrics.adapters.ArtistPagerAdapter;
import com.jahanwalsh.justlyrics.adapters.LyricPagerAdapter;
import com.jahanwalsh.justlyrics.models.Artist;
import com.jahanwalsh.justlyrics.models.Lyric;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;


public class ArtistDetailActivity extends AppCompatActivity {
    @Bind(R.id.viewPager) ViewPager mViewPager;
    private ArtistPagerAdapter adapterViewPager;
    @Bind(R.id.lyricViewPager) ViewPager mLyricViewPager;
    private LyricPagerAdapter lyricAdapterViewPager;
    ArrayList<Artist> mArtists;
    ArrayList<Lyric> mLyrics;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist_detail);
        ButterKnife.bind(this);

        mLyrics = Parcels.unwrap(getIntent().getParcelableExtra("lyrics"));
        mArtists = Parcels.unwrap(getIntent().getParcelableExtra("artists"));
        int startingPosition = getIntent().getIntExtra("position", 0);





        lyricAdapterViewPager = new LyricPagerAdapter(getSupportFragmentManager(), mLyrics);
        adapterViewPager = new ArtistPagerAdapter(getSupportFragmentManager(), mArtists);
        mViewPager.setAdapter(adapterViewPager);
        mViewPager.setCurrentItem(startingPosition);
    }
}
