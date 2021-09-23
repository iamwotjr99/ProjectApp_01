package org.techtown.chattingapp_01;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import org.json.JSONArray;

public class User extends JSONArray {

    @SerializedName("name")
    private String name;

    @SerializedName("email")
    private String email;

    @SerializedName("password")
    private String password;

    @SerializedName("profile")
    private String profile;

    @SerializedName("user_id")
    private int user_id;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User(int user_id, String name, String email, String password) {
        this.user_id = user_id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public User(String name, String email, String password, String profile) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.profile = profile;
    }

    @Override
    public String toString() {
        return email;
    }
}