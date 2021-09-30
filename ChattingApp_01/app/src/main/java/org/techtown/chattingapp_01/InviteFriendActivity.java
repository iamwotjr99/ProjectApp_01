package org.techtown.chattingapp_01;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
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

public class InviteFriendActivity extends AppCompatActivity {

    private FriendsRecyclerViewAdapter adapter;
    private List<Friends> friendsList = new ArrayList<Friends>();

    private String intentRoomName;
    private String mUsername;
    private int mUserID;
    private int roomID;
    private int frUserID;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invite_friend);

        mUsername = getIntent().getExtras().getString("userName");
        mUserID = getIntent().getExtras().getInt("userID");
        roomID = getIntent().getExtras().getInt("roomID");
        intentRoomName = getIntent().getExtras().getString("roomName");

        ImageButton btnBackImg = findViewById(R.id.imgButton_back);
        btnBackImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ServerURL.RETROFIT_SERVER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);

        Call<List<Friends>> getFriendCall = retrofitAPI.getFriends(mUserID);

        getFriendCall.enqueue(new Callback<List<Friends>>() {
            @Override
            public void onResponse(Call<List<Friends>> call, Response<List<Friends>> response) {
                if (response.isSuccessful()) {
                    List<Friends> friends = response.body();
                    for(int i = 0; i < friends.size(); i++) {
                        // 친구 목록에 중복으로 계속 add 되는 오류 해결
                        if(friends.size() != friendsList.size()){
                            friendsList.add(new Friends(friends.get(i).getFr_name(),
                                    friends.get(i).getFr_profile(),
                                    friends.get(i).getFriend_id()));
                            adapter.notifyDataSetChanged();
                        }
                    }
                } else {
                    Log.d("getFriendCall", "Fail");
                }

            }

            @Override
            public void onFailure(Call<List<Friends>> call, Throwable t) {
                Log.d("Get Friends Data", t.getMessage());
            }
        });

        RecyclerView recyclerView = findViewById(R.id.recyclerView_inviteFriend);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplication());
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new FriendsRecyclerViewAdapter(getApplication(),friendsList);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new FriendsRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                frUserID = friendsList.get(position).getFriend_id();
                Log.d("position", String.valueOf(friendsList.get(position).getFriend_id()));

                Call<Room> postInvite = retrofitAPI.postInvite(frUserID, roomID);

                postInvite.enqueue(new Callback<Room>() {
                    @Override
                    public void onResponse(Call<Room> call, Response<Room> response) {
                        if(response.isSuccessful()) {
                            Log.d("PostInvite", "Success!!");
                        }
                    }

                    @Override
                    public void onFailure(Call<Room> call, Throwable t) {
                        Log.d("PostInvite", t.getMessage());
                    }
                });
            }
        });
    }
}
