package org.techtown.chattingapp_01;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CalendarActivity extends AppCompatActivity {
    String intentData1;
    String intentData2;

    ImageButton button;
    CalendarAdapter mAdapter;
    RecyclerView recyclerView;
    List<Constructor> mList = new ArrayList<Constructor>();

    Intent intent;
    Bundle extra;

    LinearLayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_main);

        intent = getIntent();
        extra = getIntent().getExtras();
        intentData1 = intent.getStringExtra("cost");
        intentData2 = intent.getStringExtra("memo");



        button = (ImageButton)findViewById(R.id.btn_add);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CalendarActivity.this, CostActivity.class);
                startActivity(intent);
            }
        });

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://172.23.12.39:5000")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitAPI retrofitService = retrofit.create(RetrofitAPI.class);

        Call<List<Constructor>> call = retrofitService.getCalendar(intentData1, intentData2);
        call.enqueue(new Callback<List<Constructor>>() {
            @Override
            public void onResponse(Call<List<Constructor>> call, Response<List<Constructor>> response) {
                if(response.isSuccessful()) {
                    List<Constructor> res = response.body();
                    for(int i=0; i<res.size(); i++) {
                        mList.add(new Constructor(res.get(i).getCost(), res.get(i).getMemo()));
                        
                        Log.d("onResponse", res.get(i).getCost());
                    }
                    mAdapter.notifyDataSetChanged();
                } else {
                    Log.d("onResponse", "Failure");
                }
            }

            @Override
            public void onFailure(Call<List<Constructor>> call, Throwable t) {
                Log.d("Call<List<Constructor>>", t.getMessage());
            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView_costList);
        mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new CalendarAdapter(this, mList);
        recyclerView.setAdapter(mAdapter);
    }
}
