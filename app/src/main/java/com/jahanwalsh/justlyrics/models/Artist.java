package com.jahanwalsh.justlyrics.models;

import org.parceler.Parcel;

@Parcel
public class Artist {

    private String mLyric;

    public Artist (String lyric){

        this.mLyric = lyric;

    }

    public Artist() {}

    public String getLyric() {
        return mLyric;
    }

}

