package org.techtown.chattingapp_01;

import androidx.fragment.app.Fragment;

import android.content.Context;
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

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class Frag_Main_Login extends Fragment {

    private EditText loginEmail;
    private EditText loginPW;
    private Button btnLogin;
    private User user;
    private Context context;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_main_login, container, false);

        context = container.getContext();

        Gson gson = new GsonBuilder().setLenient().create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ServerURL.RETROFIT_SERVER_URL)
                .addConverterFactory(new NullOnEmptyConverterFactory())
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);

        loginEmail = view.findViewById(R.id.login_id);
        loginPW = view.findViewById(R.id.login_passwd);
        btnLogin = view.findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = loginEmail.getText().toString();
                String password = loginPW.getText().toString();

                // user = new User(email, password);

                Call<User> call = retrofitAPI.getUser(email, password);

                call.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        if(response.isSuccessful()) {
                            User result = response.body();
                            if(result != null) {
                                Log.d("Login: ", "Success");
                                //Intent intent = new Intent(getActivity(), MainActivity.class);
                                Intent intent = new Intent(getActivity(), MainActivity.class);
                                intent.putExtra("userName", result.getName());
                                intent.putExtra("userEmail", result.getEmail());
                                intent.putExtra("userPassword", result.getPassword());
                                intent.putExtra("userProfile", result.getProfile());
                                intent.putExtra("userID", result.getUser_id());
                                startActivity(intent);
                            } else {
                                Log.d("Login: ", "Fail");
                                Toast.makeText(getContext(), "다시 입력해주세요", Toast.LENGTH_LONG).show();
                            }


                        }
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        Log.d("onResponse GET User", t.getMessage());
                    }
                });
            }
        });

        return view;
    }

    /*public void confirmName() {
        for(int i = 0; i < )
    }*/
}
