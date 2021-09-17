package org.techtown.chattingapp_01;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RequiresApi(api = Build.VERSION_CODES.O)
public class ChatAdapter extends RecyclerView.Adapter {
    private List<Message> mMessages;
    private String userName;
    private DateTimeFormatter dateTime = DateTimeFormatter.ofPattern("HH:mm");
    // private DateTimeFormatter dateTime2 = DateTimeFormatter.ofPattern("HH:mm");
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
            LocalDateTime now = LocalDateTime.now();
            ((SenderViewHolder)holder).senderMsg.setText(message.getMessage());
            ((SenderViewHolder)holder).senderName.setText(message.getUsername());
            ((SenderViewHolder)holder).senderTime.setText(dateTime.format(now));
        } else {
            LocalDateTime now = LocalDateTime.now();
            ((ReceiverViewHolder)holder).receiverMsg.setText(message.getMessage());
            ((ReceiverViewHolder)holder).receiverName.setText(message.getUsername());
            ((ReceiverViewHolder)holder).receiverTime.setText(dateTime.format(now));
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

            receiverMsg = (TextView) itemView.findViewById(R.id.receiver_msg);
            receiverName = (TextView) itemView.findViewById(R.id.receiver_name);
            receiverTime = itemView.findViewById(R.id.receiver_msg_time);
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
            senderTime = itemView.findViewById(R.id.sender_msg_time);
        }
    }

    public void addChat(Message message) {
        mMessages.add(message);
        notifyItemInserted(mMessages.size() - 1);
    }
}
