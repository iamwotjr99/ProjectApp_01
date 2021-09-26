package org.techtown.chattingapp_01;

import com.google.gson.annotations.SerializedName;

public class Calender {

    @SerializedName("Month")
    private String Month;

    @SerializedName("Day")
    private String Day;

    @SerializedName("Cost")
    private String Cost;

    public String getMonth() {
        return Month;
    }

    public void setMonth(String Month) {
        this.Month = Month;
    }

    public String getDay() {
        return Day;
    }

    public void setDay(String Day) {
        this.Day = Day;
    }

    public String getCost() {
        return Cost;
    }

    public void setCost(String Cost) {
        this.Cost = Cost;
    }

    public Calender(String Month, String Day, String Cost) {
        this.Month = Month;
        this.Day = Day;
        this.Cost = Cost;
    }
    public Calender(String Month, String Day) {
        this.Month = Month;
        this.Day = Day;
    }

}
