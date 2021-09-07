package org.techtown.chattingapp_01;

import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.TextInputEditText;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import io.socket.client.Socket;
import io.socket.emitter.Emitter;

public class ChatActivity extends AppCompatActivity {
    private static final String TAG = "ChatActivity";

    private Socket mSocket;
    private List<Message> mMessages = new ArrayList<Message>();
    private RecyclerView.Adapter mAdapter;
    private RecyclerView mMessagesView;

    private TextInputEditText mInputMessageView;
    private Handler mTypingHandler = new Handler();

    private boolean mTyping = false;

    private static final int TYPING_TIMER_LENGTH = 600;
    private String mUsername;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_main);

        mUsername = getIntent().getExtras().getString("username");

        ChatApplication app = (ChatApplication) getApplication();
        mSocket = app.getSocket();
        mSocket.on("new message", onNewMessage);
        //mSocket.on("typing", onTyping);
        //mSocket.on("stop typing", onStopTyping);
        mSocket.connect();

        mAdapter = new ChatAdapter(this, mMessages);
        mMessagesView = findViewById(R.id.rv_message_list);
        mMessagesView.setLayoutManager(new LinearLayoutManager(this));
        mMessagesView.setAdapter(mAdapter);

        mInputMessageView = findViewById(R.id.et_message);
        mInputMessageView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (null == mUsername) {
                    return;
                }
                if(!mSocket.connected()) {
                    return;
                }

                if(!mTyping) {
                    mTyping = true;
                } try {
                    JSONObject data = new JSONObject();
                    data.put("username", mUsername);
                    mSocket.emit("typing", data);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            // mTypingHandler
            // mTypingHandler.postDelayed(onTypingTimeout, TYPING_TIMER_LENGTH);

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        Button sendButton = findViewById(R.id.btn_send);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attemptSend();
            }
        });
    }

    private void attemptSend() {
        if (null == mUsername) {
            return;
        }
        if (!mSocket.connected()) {
            return;
        }

        mTyping = false;

        String message = mInputMessageView.getText().toString().trim();
        if(TextUtils.isEmpty(message)) {
            mInputMessageView.requestFocus();
            return;
        }

        mInputMessageView.setText("");
        addMessage(mUsername, message);

        try {
            JSONObject data = new JSONObject();
            data.put("username", mUsername);
            data.put("message", message);

            mSocket.emit("new message", data);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private Emitter.Listener onNewMessage = new Emitter.Listener() {
        @Override
        public void call(Object... args) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    JSONObject data = (JSONObject) args[0];
                    String username;
                    String message;
                    try {
                        username = data.getString("username");
                        message = data.getString("message");
                    } catch (JSONException e) {
                        Log.e(TAG, e.getMessage());
                        return;
                    }

                    // removeTyping(username);
                    addMessage(username, message);
                }
            });
        }
    };

    private void addMessage(String username, String message) {
        mMessages.add(new Message.Builder(Message.TYPE_MESSAGE)
                .username(username)
                .message(message)
                .build());
        mAdapter.notifyItemInserted(mMessages.size() - 1);
        scrollToBottom();
    }

    private Runnable onTypingTimeout = new Runnable() {
        @Override
        public void run() {
            if (!mTyping) {
                return;
            }
            mTyping = false;
            try {
                JSONObject data = new JSONObject();
                data.put("username", mUsername);
                mSocket.emit("stop typing", data);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    };

    private void scrollToBottom() {
        mMessagesView.scrollToPosition(mAdapter.getItemCount() - 1);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        mSocket.disconnect();
    }
}
