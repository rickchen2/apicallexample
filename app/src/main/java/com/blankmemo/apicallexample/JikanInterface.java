package com.blankmemo.apicallexample;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface JikanInterface {
    @GET("anime/{id}/{request}/{parameter}")
    Call<ResponseBody> getAnimeRequest(@Path("id") int id,
                                       @Path("request") String request,
                                       @Path("parameter") int parameter);

    //@GET("users/list")
    //Call<ResponseBody> getlistResponse();
}