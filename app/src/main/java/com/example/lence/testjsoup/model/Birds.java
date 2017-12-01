package com.example.lence.testjsoup.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class Birds {

    @SerializedName("birds")
    @Expose
    private List<Bird> birds = null;

    public List<Bird> getBirds() {
        return birds;
    }

    public void setBirds(List<Bird> birds) {
        this.birds = birds;
    }

}