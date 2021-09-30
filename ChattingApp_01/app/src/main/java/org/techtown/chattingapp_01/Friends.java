package org.techtown.chattingapp_01;

import com.google.gson.annotations.SerializedName;

public class Friends {
    @SerializedName("user_id")
    private int user_id;

    @SerializedName("fr_name")
    private String fr_name;

    @SerializedName("fr_email")
    private String fr_email;

    @SerializedName("fr_password")
    private String fr_password;

    @SerializedName("fr_profile")
    private String fr_profile;

    @SerializedName("friend_id")
    private int friend_id;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getFr_name() {
        return fr_name;
    }

    public void setFr_name(String fr_name) {
        this.fr_name = fr_name;
    }

    public String getFr_email() {
        return fr_email;
    }

    public void setFr_email(String fr_email) {
        this.fr_email = fr_email;
    }

    public String getFr_password() {
        return fr_password;
    }

    public void setFr_password(String fr_password) {
        this.fr_password = fr_password;
    }

    public String getFr_profile() {
        return fr_profile;
    }

    public void setFr_profile(String fr_profile) {
        this.fr_profile = fr_profile;
    }

    public int getFriend_id() {
        return friend_id;
    }

    public void setFriend_id(int friend_id) {
        this.friend_id = friend_id;
    }

    public Friends(String fr_name, String fr_profile, int friend_id) {
        this.fr_name = fr_name;
        this.fr_profile = fr_profile;
        this.friend_id = friend_id;
    }

    public Friends(String fr_name, String fr_profile) {
        this.fr_name = fr_name;
        this.fr_profile = fr_profile;
    }
}
