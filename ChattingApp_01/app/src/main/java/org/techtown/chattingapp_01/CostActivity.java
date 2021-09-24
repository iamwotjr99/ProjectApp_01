package org.teachtown.myapplication03;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CostActivity extends AppCompatActivity implements Serializable {
    EditText today_cost;
    EditText today_memo;
    ImageButton btn_save;
    ImageButton btn_delete;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.today_cost);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://172.23.12.39:5000")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitService retrofitService = retrofit.create(RetrofitService.class);

        today_cost = (EditText) findViewById(R.id.editText_cost_input);
        today_memo = (EditText) findViewById(R.id.editText_memo_input);
        btn_save = (ImageButton) findViewById(R.id.btn_save);
        btn_delete = (ImageButton) findViewById(R.id.btn_delete);

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cost = today_cost.getText().toString();
                String memo = today_memo.getText().toString();

                Call<Constructor> call = retrofitService.postCalendar(cost, memo);
                call.enqueue(new Callback<Constructor>() {
                    @Override
                    public void onResponse(Call<Constructor> call, Response<Constructor> response) {
                        if(response.isSuccessful()) {
                            Constructor constructorResult = response.body();
                            Intent intent = new Intent(CostActivity.this, CalendarActivity.class);
                            intent.putExtra("cost", cost);
                            intent.putExtra("memo", memo);
                            startActivity(intent);
                        } else {
                            Log.d("ResponsePostCall", "실패");
                            }
                        }

                    @Override
                    public void onFailure(Call<Constructor> call, Throwable t) {
                            Log.d("FailurePostCall", t.getMessage());
                    }
                });
            }
        });
    }
}
