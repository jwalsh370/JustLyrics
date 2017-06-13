package com.jahanwalsh.justlyrics.models;

import org.parceler.Parcel;

@Parcel
public class Artist {

    String lyric;
    private String pushId;
    String albumArt;
    String name;
    String track;

    public Artist (String lyric, String albumArt, String name, String track){
        this.lyric = lyric;
        this.albumArt = albumArt;
        this.name = name;
        this.track = track;

    }

    public Artist() {}

    public String getLyric() {
        return lyric;
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

    public String getPushId() {
        return pushId;
    }

    public void setPushId(String pushId){
        this.pushId = pushId;
    }



}

