package org.techtown.chattingapp_01;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RetrofitAPI {
    @POST("/post/user")
    Call<User> postUser(@Body User user);

    @GET("/get/user/{email}/{password}")
    Call<User> getUser(@Path("email") String email, @Path("password") String password);


}