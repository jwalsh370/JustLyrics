package com.jahanwalsh.justlyrics.models;

import org.parceler.Parcel;

@Parcel
public class Artist {

    String lyric;
    String website;
    private String pushId;

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

    public String getPushId() {
        return pushId;
    }

    public void setPushId(String pushId){
        this.pushId = pushId;
    }



}

