package com.blankmemo.apicallexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Request;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class ApiCallActivity extends AppCompatActivity {
    private static final String TAG="[apicall] ";
    private Anime myAnime = new Anime();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api_call);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.jikan.moe/")
                .addConverterFactory(GsonConverterFactory.create())
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();

        final JikanInterface myJikanService = retrofit.create(JikanInterface.class);

        myJikanService.getAnimeRequest(1, "episodes", 2).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(response.isSuccessful()){
                    Log.d(TAG, String.valueOf(response.code()));
                    Log.d(TAG,call.request().toString());

                    try {
                        String responseString=response.body().string();
                        ((TextView)findViewById(R.id.response)).setText(responseString);
//                        Log.d(TAG,responseString);
//                        JSONArray jsonObject=new JSONArray(responseString);
//                        //
//                         Type type=new TypeToken<List<Repo>>(){}.getType();
//                         myRepos=new Gson().fromJson(jsonObject.toString(),type);
//                        //Repo repo=new Gson().fromJson(jsonObject.toString(),Repo.class);
                        JSONObject jsonObject = new JSONObject(responseString);
                        myAnime = new Gson().fromJson(jsonObject.toString(), Anime.class);
                        Log.d(TAG, myAnime.toString());
                    } catch (IOException| JSONException  e) {
                        e.printStackTrace();
                    }
                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });

        //logAnime();

    }

    private void logAnime(){
        Log.d(TAG, myAnime.toString());
    }
//    private void logRepos(){
//        for (Repo repo:myRepos) {
//            Log.d(TAG, repo.getId()+"---"+repo.getUserName());
//        }
//
//    }


}
