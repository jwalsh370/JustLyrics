package com.jahanwalsh.justlyrics.models;

import org.parceler.Parcel;

@Parcel
public class Artist {

    String lyric;
    String name;
    String track;
    String imgUrl;
    String index;
    private String pushId;



    public Artist (String lyric, String name, String track, String imgUrl){
        this.lyric = lyric;
        this.name = name;
        this.track = track;
//        this.imgUrl = getLargeImageUrl(imgUrl);
        this.index = "not_specified";
    }

    public Artist() {}

    public String getLyric() {
        return lyric;
    }

    public String getName(){
        return name;
    }

    public String getTrack() {
        return track;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getIndex() {
        return index;
    }

    public String getPushId() {
        return pushId;
    }

//    public String getLargeImageUrl(String imgUrl) {
//        String largeImageUrl = imgUrl.substring(0, imgUrl.length() - 6).concat("o.jpg");
//        return largeImageUrl;
//    }

    public void setPushId(String pushId){
        this.pushId = pushId;
    }

    public void setIndex(String index) {
        this.index = index;
    }


}

