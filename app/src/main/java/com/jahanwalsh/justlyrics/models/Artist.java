package com.jahanwalsh.justlyrics.models;

import org.parceler.Parcel;

@Parcel
public class Artist {
    private String mName;
    private String mTrack;
    private String mImg;

    public Artist (String name, String track, String img){

        this.mName = name;
        this.mTrack = track;
        this.mImg = img;
    }

    public Artist() {}

    public String getName() {

        return mName;
    }

    public String getTrack(){

        return mTrack;
    }

    public String getImg(){
        return mImg;
    }
}

