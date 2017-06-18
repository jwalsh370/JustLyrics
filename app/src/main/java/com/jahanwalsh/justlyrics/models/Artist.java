package com.jahanwalsh.justlyrics.models;

import org.parceler.Parcel;

@Parcel
public class Artist {

    String lyric;
<<<<<<< HEAD
=======
    String name;
    String track;
    String imgUrl;
>>>>>>> 43ef0b79d0064aec66feceb926a2ac4a08441d5b
    String index;
    private String pushId;



<<<<<<< HEAD
    public Artist (String lyric){
        this.lyric = lyric;
=======
    public Artist (String lyric, String name, String track, String imgUrl){
        this.lyric = lyric;
        this.name = name;
        this.track = track;
//        this.imgUrl = getLargeImageUrl(imgUrl);
>>>>>>> 43ef0b79d0064aec66feceb926a2ac4a08441d5b
        this.index = "not_specified";
    }

    public Artist() {}

    public String getLyric() {
        return lyric;
    }

<<<<<<< HEAD
=======
    public String getName(){
        return name;
    }

    public String getTrack() {
        return track;
    }

    public String getImgUrl() {
        return imgUrl;
    }

>>>>>>> 43ef0b79d0064aec66feceb926a2ac4a08441d5b
    public String getIndex() {
        return index;
    }

    public String getPushId() {
        return pushId;
    }

<<<<<<< HEAD

=======
//    public String getLargeImageUrl(String imgUrl) {
//        String largeImageUrl = imgUrl.substring(0, imgUrl.length() - 6).concat("o.jpg");
//        return largeImageUrl;
//    }
>>>>>>> 43ef0b79d0064aec66feceb926a2ac4a08441d5b

    public void setPushId(String pushId){
        this.pushId = pushId;
    }

    public void setIndex(String index) {
        this.index = index;
    }


}

