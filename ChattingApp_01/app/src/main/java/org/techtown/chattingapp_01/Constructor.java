package org.teachtown.myapplication03;

import org.json.JSONArray;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Constructor {

    @SerializedName("cost")
    private String cost;

    @SerializedName("memo")
    private String memo;

    public String getCost() { return cost; }

    public void setCost(String cost) { this.cost = cost; }

    public String getMemo() { return memo; }

    public void setMemo(String cost) { this.memo = memo; }

    public Constructor(String cost, String memo) {
        this.cost = cost;
        this.memo = memo;
    }

}