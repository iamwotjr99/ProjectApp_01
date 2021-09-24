package org.techtown.chattingapp_01;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class ChatListActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<ListViewItem> arrayList;
    ChatListAdapter mAdapter;

    Button btn_add;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatlist_main);

        mAdapter = new ChatListAdapter();

        listView = (ListView) findViewById(R.id.recyclerView_chatList);
//        arrayList = new ArrayList<ListViewItem>();
//
//        final ArrayAdapter<ListViewItem> arrayAdapter = new ArrayAdapter<ListViewItem>(this, R.layout.item_chat_list, arrayList);
//
//        arrayAdapter.notifyDataSetChanged();

        listView.setAdapter(mAdapter);

        // 아이템 추가
        mAdapter.addItem(ContextCompat.getDrawable(this, R.drawable.btn_person), "user");

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ListViewItem item = (ListViewItem) parent.getItemAtPosition(position) ;

                String titleStr = item.getTitle() ;
                Drawable iconDrawable = item.getIcon() ;

                String str = (String)parent.getItemAtPosition(position);
                Toast.makeText(ChatListActivity.this, str + "을 클릭했습니다.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ChatListActivity.this, ChatActivity.class);
                startActivity(intent);
                finish();
            }
        });

        
    }
}