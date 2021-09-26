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

import org.techtown.chattingapp_01.R;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class ChatListAdapter extends RecyclerView.Adapter<ChatListAdapter.ViewHolder> {

    public interface OnItemClickListener {
        void onItemClick(View v, int position);
    }

    private List<Room> mList;

    private OnItemClickListener mListener = null;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mListener = listener;
    }

    public ChatListAdapter(Context context, List<Room> chatList) {
        this.mList = chatList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_chat_list, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Room chatList = mList.get(position);
        holder.tV_roomName.setText(chatList.getRoomName());
        holder.iV_roomProfile.setImageURI(chatList.getRoomProfile());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tV_roomName;
        ImageView iV_roomProfile;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tV_roomName = itemView.findViewById(R.id.textView_room);
            iV_roomProfile = itemView.findViewById((R.id.imageView_room));

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if(position != RecyclerView.NO_POSITION) {
                        if(mListener != null) {
                            mListener.onItemClick(v, position);
                        }
                    }
                }
            });
        }
    }
}
