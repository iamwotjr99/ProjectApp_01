package org.techtown.chattingapp_01;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ChatListAdapter extends BaseAdapter {
    private ArrayList<ListViewItem> arrayChatList = new ArrayList<ListViewItem>();

    public ChatListAdapter() {
    }

    @Override
    public int getCount() {
        return arrayChatList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayChatList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    //화면에 보여질 각각의 화면에 보일 뷰 만듦
    //각각의 아이템 데이터 뷰(레이아웃)를 만들어 객체를 만든 다음에 데이터를 넣고 리턴해줌
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_chat_list, parent, false);
        }
        ImageView imageViewIcon = (ImageView) convertView.findViewById(R.id.imageView_item);
        TextView textViewTitle = (TextView) convertView.findViewById(R.id.textView_title);

        ListViewItem listViewItem = arrayChatList.get(position);

        // 아이템 내 각 위젯에 데이터 반영
        imageViewIcon.setImageDrawable(listViewItem.getIcon());
        textViewTitle.setText(listViewItem.getTitle());

        return convertView;
    }

    public void addItem(Drawable icon, String title) {
        ListViewItem item = new ListViewItem();

        item.setIcon(icon);
        item.setTitle(title);

        arrayChatList.add(item);
    }
}
