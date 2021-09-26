package org.techtown.chattingapp_01;

import com.google.gson.annotations.SerializedName;

public class Calender {

    @SerializedName("Date")
    private String Date;

    @SerializedName("Cost")
    private String Cost;

    @SerializedName("Memo")
    private String Memo;

    public String getDate(){return Date;}

    public void setDate(String Date) {
        this.Date = Date;
    }

    public String getMemo() {return Memo;}

    public void setMemo(String Memo) {
        this.Memo = Memo;
    }

    public String getCost() {
        return Cost;
    }

    public void setCost(String Cost) {
        this.Cost = Cost;
    }

    public Calender(String Date, String cost, String Memo) {
        this.Date = Date;
        this.Cost = Cost;
        this.Memo = Memo;
    }
    public Calender(String Date) {
        this.Date =Date;
    }

}
