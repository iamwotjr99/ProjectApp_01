package org.techtown.chattingapp_01;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.tabs.TabLayout;

public class Beginscr_activity extends AppCompatActivity {
    Frag_Main_Join frag_main_join;
    Frag_Main_Login frag_main_login;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_beginscr);

        frag_main_join = new Frag_Main_Join();
        frag_main_login = new Frag_Main_Login();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, frag_main_login).commit();

        TabLayout tab_beginscr = findViewById(R.id.tab_beginscr);
        tab_beginscr.addTab(tab_beginscr.newTab().setText("로그인"));
        tab_beginscr.addTab(tab_beginscr.newTab().setText("회원가입"));

        tab_beginscr.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                Log.d("Beginscr_activiry",
                        "선택된 탭:" + position);
                Fragment selected = null;
                if(position==0){
                    selected = frag_main_login;
                }else if(position == 1){
                    selected= frag_main_join;
                }

                getSupportFragmentManager().beginTransaction().
                        replace(R.id.container, selected).commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
