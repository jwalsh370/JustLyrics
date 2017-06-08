package com.jahanwalsh.justlyrics.models;

import org.parceler.Parcel;

@Parcel
public class Artist {

    private String mLyric;
    private String mWebsite;

    public Artist (String lyric, String website){
        this.mLyric = lyric;
        this.mWebsite = website;

    }

    public Artist() {}

    public String getLyric() {
        return mLyric;
    }

    public String getWebsite(){
        return mWebsite;
    }



}

