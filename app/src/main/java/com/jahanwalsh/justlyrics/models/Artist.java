package com.jahanwalsh.justlyrics.models;

import org.parceler.Parcel;

@Parcel
public class Artist {

    String lyric;
    String index;
    private String pushId;



    public Artist (String lyric){
        this.lyric = lyric;
        this.index = "not_specified";
    }

    public Artist() {}

    public String getLyric() {
        return lyric;
    }

    public String getIndex() {
        return index;
    }

    public String getPushId() {
        return pushId;
    }



    public void setPushId(String pushId){
        this.pushId = pushId;
    }

    public void setIndex(String index) {
        this.index = index;
    }


}

