package com.raut.ritetag.core.api.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Tag implements Serializable{

    @SerializedName("tag")
    @Expose
    private String tag;
    @SerializedName("tweets")
    @Expose
    private int tweets;
    @SerializedName("retweets")
    @Expose
    private int retweets;
    @SerializedName("exposure")
    @Expose
    private int exposure;
    @SerializedName("links")
    @Expose
    private float links;
    @SerializedName("photos")
    @Expose
    private float photos;
    @SerializedName("mentions")
    @Expose
    private float mentions;
    @SerializedName("color")
    @Expose
    private int color;

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getTweets() {
        return tweets;
    }

    public void setTweets(int tweets) {
        this.tweets = tweets;
    }

    public int getRetweets() {
        return retweets;
    }

    public void setRetweets(int retweets) {
        this.retweets = retweets;
    }

    public int getExposure() {
        return exposure;
    }

    public void setExposure(int exposure) {
        this.exposure = exposure;
    }

    public float getLinks() {
        return links;
    }

    public void setLinks(float links) {
        this.links = links;
    }

    public float getPhotos() {
        return photos;
    }

    public void setPhotos(float photos) {
        this.photos = photos;
    }

    public float getMentions() {
        return mentions;
    }

    public void setMentions(float mentions) {
        this.mentions = mentions;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

}