package com.blankmemo.apicallexample;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Repo {
    @SerializedName("name")
    @Expose
    private String userName;
    @SerializedName("id")
    @Expose
    private Integer id;

    public String getUserName() {
        return userName;
    }

    public Integer getId() {
        return id;
    }
}
