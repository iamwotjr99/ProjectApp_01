package org.techtown.chattingapp_01;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter {
    private List<Message> mMessages;
    private String userName;
    // private int[] mUsernameColors;

    public ChatAdapter(Context context, List<Message> messages, String userName) {
        mMessages = messages;
        this.userName = userName;
        // mUsernameColors = context.getResources().getIntArray(R.array.username_clo)
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // int layout = -1;
        if (viewType == Message.TYPE_SENDER) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main_chat_me
                    , parent, false);
            return new SenderViewHolder(view);
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main_chat_other,
                    parent, false);
            return new ReceiverViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Message message = mMessages.get(position);

        if (holder.getClass() == SenderViewHolder.class) {
            ((SenderViewHolder)holder).senderMsg.setText(message.getMessage());
            ((SenderViewHolder)holder).senderName.setText(message.getUsername());
        } else {
            ((ReceiverViewHolder)holder).receiverMsg.setText(message.getMessage());
            ((ReceiverViewHolder)holder).receiverName.setText(message.getUsername());
        }
    }


    @Override
    public int getItemCount() {
        return mMessages.size();
    }

    @Override
    public int getItemViewType(int position) {
        if(mMessages.get(position).getUsername().equals(this.userName)) {
            Log.d("Sender", "Success");
            return Message.TYPE_SENDER;
        } else {
            Log.d("Receiver", "Success");
            return Message.TYPE_RECEIVER;
        }
    }

    /*public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mUsernameView;
        private TextView mMessageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mUsernameView = (TextView) itemView.findViewById(R.id.username);
            mMessageView = (TextView) itemView.findViewById(R.id.message);
        }

        public void setUsername(String username) {
            if (null == mUsernameView) {
                return;
            }
            mUsernameView.setText(username);
        }

        public void setMessage(String message) {
            if (null == mMessageView) {
                return;
            }
            mMessageView.setText(message);
        }
    }*/

    public static class ReceiverViewHolder extends RecyclerView.ViewHolder {

        private TextView receiverMsg;
        private TextView receiverName;
        private TextView receiverTime;
        private ImageView receiverProfile;


        public ReceiverViewHolder(@NonNull View itemView) {
            super(itemView);

            receiverMsg = (TextView) itemView.findViewById(R.id.reciever_msg);
            receiverName = (TextView) itemView.findViewById(R.id.reciever_name);
            receiverTime = itemView.findViewById(R.id.reciever_time);
        }
    }

    public static class SenderViewHolder extends RecyclerView.ViewHolder {

        private TextView senderMsg;
        private TextView senderName;
        private TextView senderTime;
        private ImageView senderProfile;

        public SenderViewHolder(@NonNull View itemView) {
            super(itemView);

            senderMsg = (TextView) itemView.findViewById(R.id.sender_msg);
            senderName = (TextView) itemView.findViewById(R.id.sender_name);
            senderTime = itemView.findViewById(R.id.sender_time);
        }
    }

    public void addChat(Message message) {
        mMessages.add(message);
        notifyItemInserted(mMessages.size() - 1);
    }
}
