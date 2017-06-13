package com.jahanwalsh.justlyrics.models;


import org.parceler.Parcel;




public abstract class Lyric extends Artist {
    String lyric;

    public Lyric( String lyric){

        this.lyric = lyric;
    }

    public String getAlbumArt() {
        return albumArt;
    }


    public String getName() {
        return name;
    }

    public String getTrack() {
        return track;
    }


    public Lyric() {}
    public String getLyric() {
        return lyric;
    }
}
