package org.techtown.chattingapp_01;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
    private RecyclerView recyclerView;
    private ChatListAdapter mAdapter;
    private List<Room> mLsit = new ArrayList<Room>();

    private Button button;
    private EditText editText_roomName;
    private String imageUri;

    private int mUserID;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roomname_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ServerURL.RETROFIT_SERVER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitAPI retrofitService = retrofit.create(RetrofitAPI.class);

        mUserID = getIntent().getExtras().getInt("userID");

        editText_roomName = (EditText) findViewById(R.id.editText_roomName_input);
        button = (Button) findViewById(R.id.imageButton_roomName_add);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String roomName = editText_roomName.getText().toString();

                Call<Room> call = retrofitService.postChatList(mUserID, roomName);
                call.enqueue(new Callback<Room>() {
                    @Override
                    public void onResponse(Call<Room> call, Response<Room> response) {
                        if(response.isSuccessful()) {
                            // Room res = response.body();
                            finish();
                        } else {
                            Log.d("ResponsePostCall", "실패");
                        }
                    }

                    @Override
                    public void onFailure(Call<Room> call, Throwable t) {
                        Log.d("FailurePostCall", t.getMessage());
                    }
                });
            }
        });
    }
}
