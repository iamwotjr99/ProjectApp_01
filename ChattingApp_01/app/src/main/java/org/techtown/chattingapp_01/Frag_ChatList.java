package org.techtown.chattingapp_01;

import static android.media.CamcorderProfile.get;

import android.content.Intent;
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

import org.techtown.chattingapp_01.ListViewItem;
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
    RecyclerView recyclerView;
    ChatListAdapter mAdapter;
    LinearLayoutManager mLayoutManager;
    List<ListViewItem> mList = new ArrayList<ListViewItem>();

    ImageButton imageButton;
    ImageView imageView_room;
    String roomName;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_chatlist, container, false);

        roomName = getArguments().getString("roomName");
        imageView_room = view.findViewById((R.id.textView_room));

        imageView_room = view.findViewById(R.id.imageView_room);
        imageButton = view.findViewById(R.id.imageButton_chatList_add);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), RoomNameActivity.class);
                startActivity(intent);
            }
        });

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://172.23.12.39:5000")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitAPI retrofitService = retrofit.create(RetrofitAPI.class);

        Call<List<ListViewItem>> call = retrofitService.getChatList(roomName);
        call.enqueue(new Callback<List<ListViewItem>>() {
            @Override
            public void onResponse(Call<List<ListViewItem>> call, Response<List<ListViewItem>> response) {
                if(response.isSuccessful()) {
                    List<ListViewItem> res = response.body();
                    Log.d("Frag_ChatList", res.get(0).getTitle());
                    for(int i=0; i<res.size(); i++) {
                        mList.add(new ListViewItem(res.get(i).getTitle()));
                    }
                    mAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<ListViewItem>> call, Throwable t) {
                Log.d("Call<List<Constructor>>", t.getMessage());
            }
        });

        recyclerView = view.findViewById(R.id.recyclerView_chatList);
        mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new ChatListAdapter(getContext(), mList);
        recyclerView.setAdapter(mAdapter);

        return view;
    }
}
