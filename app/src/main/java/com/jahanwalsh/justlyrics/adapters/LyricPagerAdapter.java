package com.jahanwalsh.justlyrics.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.jahanwalsh.justlyrics.models.Artist;
import com.jahanwalsh.justlyrics.models.Lyric;
import com.jahanwalsh.justlyrics.ui.ArtistDetailFragment;

import java.util.ArrayList;

public class LyricPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Lyric> mLyrics;

    public LyricPagerAdapter(FragmentManager fm, ArrayList<Lyric> lyrics) {
        super(fm);
        mLyrics = lyrics;
    }

    @Override
    public Fragment getItem(int position) {
        return ArtistDetailFragment.newInstance(mLyrics.get(position));
    }

    @Override
    public int getCount() {
        return
                mLyrics.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mLyrics.get(position).getLyric();
    }
}

