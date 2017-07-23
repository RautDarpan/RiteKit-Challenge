package com.raut.ritetag.core.api.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class InflunencerResponseData {

    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("tweets")
    @Expose
    private int tweets;
    @SerializedName("exposure")
    @Expose
    private int exposure;
    @SerializedName("retweets")
    @Expose
    private int retweets;
    @SerializedName("links")
    @Expose
    private float links;
    @SerializedName("images")
    @Expose
    private float images;
    @SerializedName("mentions")
    @Expose
    private float mentions;
    @SerializedName("color")
    @Expose
    private int color;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getTweets() {
        return tweets;
    }

    public void setTweets(int tweets) {
        this.tweets = tweets;
    }

    public int getExposure() {
        return exposure;
    }

    public void setExposure(int exposure) {
        this.exposure = exposure;
    }

    public int getRetweets() {
        return retweets;
    }

    public void setRetweets(int retweets) {
        this.retweets = retweets;
    }

    public float getLinks() {
        return links;
    }

    public void setLinks(float links) {
        this.links = links;
    }

    public float getImages() {
        return images;
    }

    public void setImages(float images) {
        this.images = images;
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