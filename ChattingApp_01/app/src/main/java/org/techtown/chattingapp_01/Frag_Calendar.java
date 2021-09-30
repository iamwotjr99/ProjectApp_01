package org.techtown.chattingapp_01;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Frag_Calendar extends Fragment {
    private int mCost;
    private String mMemo;
    private int mUserId;

    private ImageButton button;
    private CalendarAdapter mAdapter;
    private RecyclerView recyclerView;
    private List<Constructor> mList = new ArrayList<Constructor>();

    private LinearLayoutManager mLayoutManager;

    private String date;
    private long mNow;
    private Date mDate;
    private SimpleDateFormat mFormat = new SimpleDateFormat("yyyy.MM.dd");

    private TextView textView_date;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_calendar, container, false);

        mCost = getArguments().getInt("cost");
        mMemo = getArguments().getString("memo");
        mUserId = getArguments().getInt("userID");

        textView_date = view.findViewById(R.id.textView_date);
        textView_date.setText(getTime());

        button = view.findViewById(R.id.btn_add);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CostActivity.class);
                intent.putExtra("user_id", mUserId);
                startActivity(intent);
            }
        });

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ServerURL.RETROFIT_SERVER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitAPI retrofitService = retrofit.create(RetrofitAPI.class);

        Call<List<Constructor>> call = retrofitService.getCalendar(mCost, mMemo, getTime());
        call.enqueue(new Callback<List<Constructor>>() {
            @Override
            public void onResponse(Call<List<Constructor>> call, Response<List<Constructor>> response) {
                if(response.isSuccessful()) {
                    List<Constructor> res = response.body();
                    for(int i=0; i<res.size(); i++) {
                        mList.add(new Constructor(res.get(i).getCost(), res.get(i).getMemo()));
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

        recyclerView = view.findViewById(R.id.recyclerView_costList);
        mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new CalendarAdapter(getContext(), mList);
        recyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new CalendarAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                int cost = mCost;
                String memo = mMemo;
                Call<Constructor> call = retrofitService.deleteCalendar(getTime(), mUserId);
                call.enqueue(new Callback<Constructor>() {
                    @Override
                    public void onResponse(Call<Constructor> call, Response<Constructor> response) {
                        if(response.isSuccessful()) {
                            Constructor constructorResult = response.body();
                            mList.remove(position);
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

        return view;
    }

    private String getTime() {
        mNow = System.currentTimeMillis();
        mDate = new Date(mNow);
        date = mFormat.format(mDate);
        return date;
    }
}
