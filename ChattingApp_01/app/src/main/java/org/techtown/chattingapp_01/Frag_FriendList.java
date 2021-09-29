package org.techtown.chattingapp_01;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Frag_FriendList extends Fragment {
    private String mUserName;
    private String mUserEmail;
    private String mUserPassword;
    private String mUserProfile;
    private int mUserID;
    private ImageView imageProfile;
    private TextView tvName;
    private ImageButton btnSearch;
    private ImageButton btnAddFriend;
    private Uri mUserProfileUri;
    private FriendsRecyclerViewAdapter adapter;
    private List<Friends> friendsList = new ArrayList<Friends>();
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.frag_friendlist, container, false);

            mUserName = getArguments().getString("userName");
            mUserEmail = getArguments().getString("userEmail");
            mUserPassword = getArguments().getString("userPassword");
            mUserProfile = getArguments().getString("userProfile");
            mUserID = getArguments().getInt("userID");

            imageProfile = view.findViewById(R.id.image_profile);
            tvName = view.findViewById(R.id.tv_name);
            btnSearch = view.findViewById(R.id.btn_search);
            btnAddFriend = view.findViewById(R.id.btn_addFriend);

            // mUserProfileUri = Uri.parse(mUserProfile);

            imageProfile.setImageURI(mUserProfileUri);
            tvName.setText(mUserName);

            btnAddFriend.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), AddFriendActivity.class);
                    intent.putExtra("userName", mUserName);
                    intent.putExtra("userEmail", mUserEmail);
                    intent.putExtra("userPassword", mUserPassword);
                    intent.putExtra("userProfile", mUserProfile);
                    intent.putExtra("userID", mUserID);
                    startActivity(intent);
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
                                        friends.get(i).getFr_profile()));
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

            RecyclerView recyclerView = view.findViewById(R.id.recyclerView_friendList);

            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
            recyclerView.setLayoutManager(linearLayoutManager);

            adapter = new FriendsRecyclerViewAdapter(getContext(),friendsList);
            recyclerView.setAdapter(adapter);

            return view;
        }
}

