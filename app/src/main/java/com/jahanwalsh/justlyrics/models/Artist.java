package com.jahanwalsh.justlyrics.models;

import org.parceler.Parcel;

@Parcel
public class Artist  {

    private String pushId;
    String albumArt;
    String name;
    String track;
    String lyric;

    public Artist ( String albumArt, String name, String track, String lyric){
        this.albumArt = getLargeImageUrl(albumArt);
        this.name = name;
        this.track = track;
        this.lyric = lyric;

    }

    public Artist() {}


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

    public String getLyric() {
        return lyric;
    }

    public String getLargeImageUrl(String albumArt) {
        String largeImageUrl = albumArt.substring(0, albumArt.length() - 6).concat("o.jpg");
        return largeImageUrl;
    }



}

