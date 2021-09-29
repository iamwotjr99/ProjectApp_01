package org.techtown.chattingapp_01;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class Frag_Main_Join extends Fragment {

    private EditText joinEmail;
    private EditText joinPW;
    private EditText joinName;
    private Button btnJoin;
    private User user;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_main_join, container, false);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(1, TimeUnit.MINUTES)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ServerURL.RETROFIT_SERVER_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);

        joinEmail = (EditText) view.findViewById(R.id.join_email);
        joinPW = (EditText) view.findViewById(R.id.join_pwd);
        joinName = (EditText) view.findViewById(R.id.join_name);
        btnJoin = view.findViewById(R.id.btn_join);

        btnJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = joinEmail.getText().toString();
                String password = joinPW.getText().toString();
                String name = joinName.getText().toString();

                user = new User(name, email, password);

                Call<User> postCall = retrofitAPI.postUser(user);

                postCall.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        if(response.isSuccessful()) {
                            User userResult = response.body();
                            Log.d("PostCall","ok");
                            Toast.makeText(getContext(), "회원가입 성공!", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(getActivity(), SetProfileActivity.class);
                            intent.putExtra("userName", name);
                            intent.putExtra("userEmail", email);
                            intent.putExtra("userPassword", password);
                            startActivity(intent);
                        } else {
                            Log.d("ResponsePostCall", "실패");
                            Toast.makeText(getContext(), "네트워크 오류", Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        Log.d("FailurePostCall", t.getMessage());
                    }
                });
            }
        });

        return view;
    }
}


