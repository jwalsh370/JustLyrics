package com.jahanwalsh.justlyrics.models;
import org.parceler.Parcel;

import java.util.ArrayList;

@Parcel
public class Artist {
    private String mName;
    private String mTrack;

    public Artist() {}

    public Artist (String name){

        this.mName = name;
//        this.mTrack = track;
    }

    public String getName() {

        return mName;
    }

//    public String getTrack(){
//        return mTrack;
//    }
}

