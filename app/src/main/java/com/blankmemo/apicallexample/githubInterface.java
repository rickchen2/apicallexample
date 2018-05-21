package com.blankmemo.apicallexample;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface githubInterface {
    @GET("users/{user}/repos")
    Call<ResponseBody> getMeRepos(@Path("user") String user);

    @GET("users/list")
    Call<ResponseBody> getlistResponse();
}