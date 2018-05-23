package com.blankmemo.apicallexample;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Anime {
    @SerializedName("mal_id")
    @Expose
    private Integer malId;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("link_canonical")
    @Expose
    private String link_canonical;
    @SerializedName("title")
    @Expose
    private String title;

    @Override
    public String toString() {
        return "\n Mal_id is: "+ getMalId() + "\n Type is: " + getType() + "\n Link_canonical is: "+ getLinkCanonical() + "\n Title is: " + getTitle();
    }



    public Integer getMalId() {
        return malId;
    }

    public void setMalId(Integer malId) {
        this.malId = malId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLinkCanonical() {
        return link_canonical;
    }

    public void setLinkCanonical(String LinkCanonical) {
        this.link_canonical = link_canonical;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
