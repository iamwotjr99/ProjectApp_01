package org.techtown.chattingapp_01;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private Frag_Calendar frag_calendar;
    private Frag_ChatList frag_chatList;
    private Frag_FriendList frag_friendList;
    private BottomNavigationView bottomNavigationView;
    private String mUserName;
    private String mUserEmail;
    private String mUserPassword;
    private String mUserProfile;
    private int mUserID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUserName = getIntent().getExtras().getString("userName");
        mUserEmail = getIntent().getExtras().getString("userEmail");
        mUserPassword = getIntent().getExtras().getString("userPassword");
        mUserProfile = getIntent().getExtras().getString("userProfile");
        mUserID = getIntent().getExtras().getInt("userID");

        Bundle bundle = new Bundle();
        bundle.putString("userName", mUserName);
        bundle.putString("userEmail", mUserEmail);
        bundle.putString("userPassword", mUserPassword);
        bundle.putString("userProfile", mUserProfile);
        bundle.putInt("userID", mUserID);

        frag_friendList = new Frag_FriendList();
        frag_friendList.setArguments(bundle);

        frag_chatList = new Frag_ChatList();
        frag_chatList.setArguments(bundle);

        frag_calendar = new Frag_Calendar();
        frag_calendar.setArguments(bundle);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.lobby_container, frag_friendList)
                .commit();

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.tab_friend_list);
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.tab_friend_list:
                                getSupportFragmentManager().beginTransaction()
                                        .replace(R.id.lobby_container, frag_friendList)
                                        .commit();
                                return true;

                            case R.id.tab_chat_list:
                                getSupportFragmentManager().beginTransaction()
                                        .replace(R.id.lobby_container, frag_chatList)
                                        .commit();
                                return true;

                            case R.id.tab_expend:
                                getSupportFragmentManager().beginTransaction()
                                        .replace(R.id.lobby_container, frag_calendar)
                                        .commit();
                                return true;
                        }
                        return false;
                    }
                });
    }
}