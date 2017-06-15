package com.jahanwalsh.justlyrics.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import com.jahanwalsh.justlyrics.models.Artist;
import com.jahanwalsh.justlyrics.ui.ArtistDetailFragment;

import java.util.ArrayList;

public class ArtistPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Artist> mArtists;

    public ArtistPagerAdapter(FragmentManager fm, ArrayList<Artist> artists) {
        super(fm);
        mArtists = artists;
    }

    @Override
    public Fragment getItem(int position) {
        return ArtistDetailFragment.newInstance(mArtists.get(position));
    }

    @Override
    public int getCount() {
        return mArtists.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mArtists.get(position).getLyric();
    }
}

