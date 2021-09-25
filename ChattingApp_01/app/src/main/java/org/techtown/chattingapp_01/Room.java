package org.techtown.chattingapp_01;

import android.net.Uri;

import com.google.gson.annotations.SerializedName;

public class Room {
    private Uri roomProfile;

    @SerializedName("roomName")
    private String roomName;
    @SerializedName("roomID")
    private int roomID;

    public Room(Uri roomProfile, String roomName) {
        this.roomProfile = roomProfile;
        this.roomName = roomName;
    }

    public Room(String title) { }

    public void setRoomProfile(Uri roomProfile) {
        roomProfile = roomProfile;
    }
    public void setRoomName(String roomName) { roomName = roomName; }
    public Uri getRoomProfile() {
        return roomProfile;
    }
    public String getRoomName() {
        return roomName;
    }
}
