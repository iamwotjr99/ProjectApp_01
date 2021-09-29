package org.techtown.chattingapp_01;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    private String date;
    private long mNow;
    private Date mDate;
    private SimpleDateFormat mFormat = new SimpleDateFormat("yyyy.MM.dd");

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cost_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ServerURL.RETROFIT_SERVER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitAPI retrofitService = retrofit.create(RetrofitAPI.class);

        today_cost = (EditText) findViewById(R.id.editText_cost_input);
        today_memo = (EditText) findViewById(R.id.editText_memo_input);
        btn_save = (ImageButton) findViewById(R.id.btn_save);
        btn_delete = (ImageButton) findViewById(R.id.btn_delete);

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int cost = Integer.parseInt(today_cost.getText().toString());
                String memo = today_memo.getText().toString();

                Call<Constructor> call = retrofitService.postCalendar(cost, memo, date);
                call.enqueue(new Callback<Constructor>() {
                    @Override
                    public void onResponse(Call<Constructor> call, Response<Constructor> response) {
                        if(response.isSuccessful()) {
                            Constructor constructorResult = response.body();
                            Intent intent = new Intent(CostActivity.this, Frag_Calendar.class);
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

    private String getTime() {
        mNow = System.currentTimeMillis();
        mDate = new Date(mNow);
        date = mFormat.format(mDate);
        return date;
    }
}
