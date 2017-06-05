package com.jahanwalsh.justlyrics.models;

import org.parceler.Parcel;

@Parcel
public class Artist {
    private String mName;
    private String mTrack;

    public Artist (String name, String track){

        this.mName = name;
        this.mTrack = track;
    }

    public Artist() {}

    public String getName() {

        return mName;
    }

    public String getTrack(){
        return mTrack;
    }
}

