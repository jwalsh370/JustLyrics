package com.jahanwalsh.justlyrics.models;

import org.parceler.Parcel;

@Parcel
public class Artist {
    private String mName;

    public Artist (String name){

        this.mName = name;
    }

    public Artist() {}

    public String getName() {

        return mName;
    }
}

