package com.example.lence.testjsoup.api;




import com.example.lence.testjsoup.model.Bird;
import com.example.lence.testjsoup.model.Birds;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Api {
    @GET("posts?categories=2&page=1")
    Call<ResponseBody> get();


    @GET("/posts/{id}")
    Call<ResponseBody> post(@Path("id") String id);

}
