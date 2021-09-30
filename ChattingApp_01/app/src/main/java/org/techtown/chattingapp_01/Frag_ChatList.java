package org.techtown.chattingapp_01;

import static android.media.CamcorderProfile.get;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.techtown.chattingapp_01.RetrofitAPI;
import org.techtown.chattingapp_01.RoomNameActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Frag_ChatList extends Fragment {
    private RecyclerView recyclerView;
    private ChatListAdapter mAdapter;
    private LinearLayoutManager mLayoutManager;
    private List<Room> mList = new ArrayList<Room>();

    private ImageButton imageButton;
    private ImageView imageView_room;
    private String roomName;

    private String mUserName;
    private String mUserEmail;
    private String mUserPassword;
    private String mUserProfile;
    private int mUserID;
    private int roomID;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_chatlist, container, false);

        mUserName = getArguments().getString("userName");
        mUserEmail = getArguments().getString("userEmail");
        mUserPassword = getArguments().getString("userPassword");
        mUserProfile = getArguments().getString("userProfile");
        mUserID = getArguments().getInt("userID");

        // roomName = getArguments().getString("roomName");
        imageView_room = view.findViewById((R.id.textView_room));

        imageView_room = view.findViewById(R.id.imageView_room);
        imageButton = view.findViewById(R.id.imageButton_chatList_add);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), RoomNameActivity.class);
                intent.putExtra("userID", mUserID);
                startActivity(intent);
            }
        });

        String roomProfileString = "android.resource://org.techtown.chattingapp_01/drawable/" + "img_person";
        Uri roomProfileUri = Uri.parse(roomProfileString);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ServerURL.RETROFIT_SERVER_URL)
                .addConverterFactory(new NullOnEmptyConverterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitAPI retrofitService = retrofit.create(RetrofitAPI.class);

        // Log.d("mUserID", String.valueOf(mUserID));
        Call<List<Room>> call = retrofitService.getChatList(mUserID);
        call.enqueue(new Callback<List<Room>>() {
            @Override
            public void onResponse(Call<List<Room>> call, Response<List<Room>> response) {
                if(response.isSuccessful()) {
                    List<Room> res = response.body();
                    for(int i=0; i<res.size(); i++) {
                        if(mList.size() != res.size()) {
                            mList.add(new Room(roomProfileUri, res.get(i).getRoomName(),
                                    res.get(i).getRoomID()));
                            mAdapter.notifyDataSetChanged();
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Room>> call, Throwable t) {
                Log.d("Call<List<Constructor>>", t.getMessage());
            }
        });

        recyclerView = view.findViewById(R.id.recyclerView_chatList);
        mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new ChatListAdapter(getContext(), mList);
        recyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new ChatListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                roomID = mList.get(position).getRoomID();
                roomName = mList.get(position).getRoomName();
                Log.d("setOnItemClickListener", String.valueOf(mList.get(position).getRoomID()));
                Intent intent = new Intent(getContext(), ChatActivity.class);
                intent.putExtra("userName", mUserName);
                intent.putExtra("userID", mUserID);
                intent.putExtra("roomID", roomID);
                intent.putExtra("roomName", roomName);
                startActivity(intent);
            }
        });

        return view;
    }
}
