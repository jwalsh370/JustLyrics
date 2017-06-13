package com.jahanwalsh.justlyrics.models;


import org.parceler.Parcel;

@Parcel


public class Lyric {
    String lyric;

    public Lyric( String lyric){

        this.lyric = lyric;
    }


    public Lyric() {}

    public String getLyric() {

        return lyric;
    }
}
