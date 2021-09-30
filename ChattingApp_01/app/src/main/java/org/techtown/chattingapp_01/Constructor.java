package org.techtown.chattingapp_01;

import com.google.gson.annotations.SerializedName;

public class Constructor {

    @SerializedName("Cost")
    private String cost;

    @SerializedName("Memo")
    private String memo;

    @SerializedName("Date")
    private String date;

    public String getCost() { return cost; }

    public void setCost(String cost) { this.cost = cost; }

    public String getMemo() { return memo; }

    public void setMemo(String cost) { this.memo = memo; }

    public String getDate() { return date; }

    public void setDate(String date) { this.date = date; }

    public Constructor(String cost, String memo) {
        this.cost = cost;
        this.memo = memo;
    }

}