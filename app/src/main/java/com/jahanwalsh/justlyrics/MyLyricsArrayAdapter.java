package com.jahanwalsh.justlyrics;

import android.content.Context;
import android.util.Log;
import android.widget.ArrayAdapter;



public class MyLyricsArrayAdapter extends ArrayAdapter {
    private Context mContext;
    private String[] mArtists;
    private String[] mSongs;

    public MyLyricsArrayAdapter(Context mContext, int resource, String[] mArtists, String[] mSongs) {
        super(mContext, resource);
        this.mContext = mContext;
        this.mArtists = mArtists;
        this.mSongs = mSongs;
    }

    @Override
    public Object getItem(int position) {
        String artists = mArtists[position];
        String songs = mSongs[position];
        return String.format("%s \nServes great: %s", artists, songs);

    }

    @Override
    public int getCount() {
        return mArtists.length;
    }

}