package org.techtown.chattingapp_01;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AddFriendActivity extends AppCompatActivity {
    private String mUserName;
    private String mUserEmail;
    private String mUserPassword;
    private String mUserProfile;
    private int mUserID;
    private EditText etFriendID;
    private TextView tvUserID;
    private String friendName;
    private String friendEmail;
    private String friendPassword;
    private String friendProfile;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitiy_add_friend);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://ec2-15-164-230-128.ap-northeast-2.compute.amazonaws.com:3000")
                .addConverterFactory(new NullOnEmptyConverterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);

        mUserName = getIntent().getExtras().getString("userName");
        mUserEmail = getIntent().getExtras().getString("userEmail");
        mUserPassword = getIntent().getExtras().getString("userPassword");
        mUserProfile = getIntent().getExtras().getString("userProfile");
        mUserID = getIntent().getExtras().getInt("userID");

        etFriendID = findViewById(R.id.et_friendID);
        tvUserID = findViewById(R.id.tv_mUserID);


        tvUserID.setText(String.valueOf(mUserID));

        Button btnAdd = findViewById(R.id.btn_add);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int friendID = Integer.parseInt(etFriendID.getText().toString());
                Call<User> getCall = retrofitAPI.getUserID(friendID);

                getCall.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        if(response.isSuccessful()) {
                            User result = response.body();
                            Log.d("getFriendData", result.getName());
                            // null 이 아니라는것은 그 조회한 회원이 라오톡 회원이라는 뜻
                            if(result != null) {
                                friendName = result.getName();
                                friendEmail = result.getEmail();
                                friendPassword = result.getPassword();
                                friendProfile = result.getProfile();

                                User friend = new User(friendName, friendEmail, friendPassword, friendProfile);

                                Call<User> postCall = retrofitAPI.postAddFriends(mUserID, friendID, friend);

                                postCall.enqueue(new Callback<User>() {
                                    @Override
                                    public void onResponse(Call<User> call, Response<User> response) {
                                        if(response.isSuccessful()) {
                                            Log.d("PostCall", "Post Friend Success!");
                                        }
                                    }

                                    @Override
                                    public void onFailure(Call<User> call, Throwable t) {
                                        Log.d("onFailureFriend", t.getMessage());
                                    }
                                });
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        Log.d("getFriendData", t.getMessage());
                    }
                });
            }
        });


    }
}
