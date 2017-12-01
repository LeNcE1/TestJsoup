package com.example.lence.testjsoup.view;


import android.util.Log;


import com.example.lence.testjsoup.api.App;
import com.example.lence.testjsoup.model.Bird;
import com.example.lence.testjsoup.model.Birds;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Presenter {
    MVP mMVP;

    public Presenter(MVP MVP) {
        mMVP = MVP;
    }

    public void loadBirds() {
        App.getApi().get().enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Log.e("Error", response.message() + " "+response.code());

                String json = null;
                JSONObject jsonObject = null;
                JSONArray jsonArray;

                try {
                    jsonArray = new JSONArray(response.body().string());

                    jsonObject = new JSONObject(jsonArray.get(0).toString());

                    jsonObject  = jsonObject.getJSONObject("content");

                    json  = jsonObject.getString("rendered");
                    Log.e("post", json.toString());
                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }


                if(json != null){
                    mMVP.getContent(json);
                }
                else{
                    Log.e("POST", "isEmpty");
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

}
