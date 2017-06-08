package com.jahanwalsh.justlyrics.models;

import org.parceler.Parcel;

@Parcel
public class Artist {

   String lyric;
    String website;

    public Artist (String lyric, String website){
        this.lyric = lyric;
        this.website = website;

    }

    public Artist() {}

    public String getLyric() {
        return lyric;
    }

    public String getWebsite(){
        return website;
    }



}

