package org.techtown.chattingapp_01;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SetProfileActivity extends AppCompatActivity {

    private String mUserName;
    private ImageView imageProfile;
    private Button btnSetProfile;
    private Button btnNone;
    private Button btnNext;
    private TextView tvWelcome;
    private Uri defaultProfileUri;
    private String mUserEmail;
    private String mUserPassword;

    OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .connectTimeout(1, TimeUnit.MINUTES)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .build();

    Gson gson = new GsonBuilder().setLenient().create();

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://192.168.219.101:3000")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build();

    RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.activity_set_profile);
        super.onCreate(savedInstanceState);

        mUserPassword = getIntent().getExtras().getString("userPassword");
        mUserName = getIntent().getExtras().getString("userName");
        mUserEmail = getIntent().getExtras().getString("userEmail");
        tvWelcome = findViewById(R.id.tv_welcome);
        tvWelcome.setText(mUserName + "님 안녕하세요.");

        btnSetProfile = findViewById(R.id.btn_setProfile);
        btnSetProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }
        });

        String defaultProfile = "android.resource://org.techtown.sockettest/drawable/" +
                "friend";
        defaultProfileUri = Uri.parse(defaultProfile);

        btnNone = findViewById(R.id.btn_none);
        btnNone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Call<User> call = retrofitAPI.postUserProfile(defaultProfileUri, mUserEmail);

                call.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        Log.d("PostUserProfile", "Default Profile Send!");
                        imageProfile.setImageURI(defaultProfileUri);
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        Log.d("FailurePostProfile", t.getMessage());
                    }
                });

            }

        });

        btnNext = findViewById(R.id.btn_next);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SetProfileActivity.this, Beginscr_activity.class);
                startActivity(intent);
            }
        });

    }

    public void openGallery() {
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("image/*");

        startActivityForResult(intent, 202);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 202) {
            if(resultCode == Activity.RESULT_OK) {
                Uri filepath = data.getData();

                mUserEmail = getIntent().getExtras().getString("userEmail");

                imageProfile = findViewById(R.id.image_profile);

                Call<User> call = retrofitAPI.postUserProfile(filepath, mUserEmail);

                call.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        Log.d("PostUserProfile", "Profile Send!");
                        imageProfile.setImageURI(filepath);

                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        Log.d("FailurePostProfile", t.getMessage());
                    }
                });

            }
        }
    }
}
