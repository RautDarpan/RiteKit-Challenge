package com.raut.ritetag.core.api.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class InfluencersResponse {

    @SerializedName("result")
    @Expose
    private boolean result;
    @SerializedName("code")
    @Expose
    private int code;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("hashtag")
    @Expose
    private String hashtag;
    @SerializedName("data")
    @Expose
    private List<InflunencerResponseData> data = null;
    @SerializedName("color")
    @Expose
    private List<String> color = null;

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getHashtag() {
        return hashtag;
    }

    public void setHashtag(String hashtag) {
        this.hashtag = hashtag;
    }

    public List<InflunencerResponseData> getData() {
        return data;
    }

    public void setData(List<InflunencerResponseData> data) {
        this.data = data;
    }

    public List<String> getColor() {
        return color;
    }

    public void setColor(List<String> color) {
        this.color = color;
    }

}