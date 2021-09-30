package org.techtown.chattingapp_01;

import android.net.Uri;

import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface RetrofitAPI {
    @POST("/post/user")
    Call<User> postUser(@Body User user);

    @GET("/get/user/{email}/{password}")
    Call<User> getUser(@Path("email") String email, @Path("password") String password);

    @GET("/get/user/{user_id}")
    Call<User> getUserID(@Path("user_id") int user_id);

    @FormUrlEncoded
    @PUT("/put/user/profile")
        //Call<User> postUserProfile(@Part MultipartBody.Part profile, @Part("email") RequestBody email);
    Call<User> postUserProfile(@Field("profile") Uri profile,
                               @Field("email") String email);

    @POST("/post/user/{user_id}/add/{friend_id}")
    Call<User> postAddFriends(@Path("user_id") int user_id, @Path("friend_id") int friendID,
                              @Body User friend);

    @GET("/get/{user_id}/friendsList/")
    Call<List<Friends>> getFriends(@Path("user_id") int user_id);

    @POST("/post/calendar/{cost}/{memo}/{date}/user/{user_id}")
    Call<Constructor> postCalendar(@Path("cost") int cost, @Path("memo") String memo, @Path("date") String date, @Path("user_id") int user_id);

    @GET("/get/calendar/{date}/user/{user_id}")
    Call<List<Constructor>> getCalendar(@Path("date") String date, @Path("user_id") int user_id);

    @DELETE("/delete/calendar/{date}/user/{user_id}")
    Call<Constructor> deleteCalendar(@Path("date") String date, @Path("user_id") int user_id);

    @POST("/post/{user_id}/chatList/{roomName}")
    Call<Room> postChatList(@Path("user_id") int user_id, @Path("roomName") String roomName);

    @GET("/get/{user_id}/chatList")
    Call<List<Room>> getChatList(@Path("user_id") int user_id);

    @POST("/post/invite/{user_id}/{room_id}")
    Call<Room> postInvite(@Path("user_id") int user_id, @Path("room_id") int room_id);
}