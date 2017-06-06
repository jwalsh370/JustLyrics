package com.jahanwalsh.justlyrics.models;

import org.parceler.Parcel;

@Parcel
public class Artist {
    private String mName;
    private String mTrack;
    private String mImg;
    private String mWebsite;
    private String mTrackId;
    private String mLyric;

    public Artist (String lyric){

//        this.mName = name;
//        this.mTrack = track;
//        this.mImg = img;
//        this.mWebsite = website;
//        this.mTrackId= trackId;
        this.mLyric = lyric;

    }

    public Artist() {}

    public String getLyric() {
        return mLyric;
    }

//    public String getName() {
//
//        return mName;
//    }
//
//    public String getTrack(){
//
//        return mTrack;
//    }
//
//    public String getImg(){
//        return mImg;
//    }
//
//    public String getWebsite(){
//        return mWebsite;
//    }
//
//    public String getTrackId(){
//        return mTrackId;
//    }
}

