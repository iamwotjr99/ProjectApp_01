package org.techtown.chattingapp_01;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import org.techtown.chattingapp_01.ListViewItem;
import org.techtown.chattingapp_01.R;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class ChatListAdapter extends RecyclerView.Adapter<ChatListAdapter.ViewHolder> {
    private List<ListViewItem> mList = new ArrayList<ListViewItem>();

    public ChatListAdapter(Context context, List<ListViewItem> mList) {
        this.mList = mList;
    }

    @NonNull
    @Override
    public ChatListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.frag_chatlist, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ChatListAdapter.ViewHolder holder, int position) {
        ListViewItem listViewItem = mList.get(position);
        holder.tV_roomName.setText(listViewItem.getTitle());
        holder.iV_roomIcon.setImageDrawable(listViewItem.getIcon());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tV_roomName;
        ImageView iV_roomIcon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tV_roomName = itemView.findViewById(R.id.imageView_room);
            iV_roomIcon = itemView.findViewById((R.id.textView_room));
        }
    }
}
