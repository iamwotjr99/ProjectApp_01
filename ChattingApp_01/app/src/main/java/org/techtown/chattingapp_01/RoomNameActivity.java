package org.techtown.chattingapp_01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RoomNameActivity extends Activity {
    RecyclerView recyclerView;
    ChatListAdapter mAdapter;
    List<ListViewItem> mLsit = new ArrayList<ListViewItem>();

    ImageButton imageButton;
    EditText editText_roomName;
    String imageUri;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roomname_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://172.23.12.39:5000")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitAPI retrofitService = retrofit.create(RetrofitAPI.class);

        editText_roomName = (EditText) findViewById(R.id.editText_roomName_input);
        imageButton = (ImageButton) findViewById(R.id.imageButton_roomName_add);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String roomName = editText_roomName.getText().toString();

                Call<ListViewItem> call = retrofitService.postChatList(roomName);
                call.enqueue(new Callback<ListViewItem>() {
                    @Override
                    public void onResponse(Call<ListViewItem> call, Response<ListViewItem> response) {
                        if(response.isSuccessful()) {
                            ListViewItem res = response.body();
                            Log.d("onResponse", res.getTitle());
                            Intent intent = new Intent(RoomNameActivity.this, RoomNameActivity.class);
                            intent.putExtra("roomName", roomName);
                            startActivity(intent);
                        } else {
                            Log.d("ResponsePostCall", "실패");
                        }
                    }

                    @Override
                    public void onFailure(Call<ListViewItem> call, Throwable t) {
                        Log.d("FailurePostCall", t.getMessage());
                    }
                });
            }
        });
    }
}
