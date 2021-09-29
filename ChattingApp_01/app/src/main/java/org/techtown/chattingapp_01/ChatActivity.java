package org.techtown.chattingapp_01;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
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

    private EditText mInputMessageView;
    private Handler mTypingHandler = new Handler();

    private boolean mTyping = false;

    private static final int TYPING_TIMER_LENGTH = 600;
    private String mUsername;
    private int mUserID;
    private int roomID;
    private String intentRoomName;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_personalchat);

        mUsername = getIntent().getExtras().getString("username");
        mUserID = getIntent().getExtras().getInt("userID");
        roomID = getIntent().getExtras().getInt("roomID");
        intentRoomName = getIntent().getExtras().getString("roomName");

        ChatApplication app = (ChatApplication) getApplication();
        mSocket = app.getSocket();
        mSocket.on("new message", onNewMessage);
        //mSocket.on("typing", onTyping);
        //mSocket.on("stop typing", onStopTyping);
        mSocket.connect();

        mAdapter = new ChatAdapter(this, mMessages, mUsername);
        mMessagesView = findViewById(R.id.personal_recyclerView_chat);
        mMessagesView.setLayoutManager(new LinearLayoutManager(this));
        mMessagesView.setAdapter(mAdapter);

        mInputMessageView = findViewById(R.id.editText_input);
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

        Button sendButton = findViewById(R.id.button_send);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Working Button", "Success");
                attemptSend();
            }
        });

        //ENTER 키 누르면 메세지 보내짐
        EditText enterMsg = (EditText) findViewById(R.id.editText_input);
        enterMsg.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int KeyCode, KeyEvent event) {
                switch (KeyCode) {
                    case KeyEvent.KEYCODE_ENTER:
                        enterMsg.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Log.d("Working Button", "Success");
                                attemptSend();
                            }
                        });
                        break;
                }
                return false;
            }
        });
    }

    private void attemptSend() {
        if (null == mUsername) {
            return;
        }
        if (!mSocket.connected()) {
            Log.d("Working attemptSend()", "fail");
            return;
        }

        mTyping = false;

        String message = mInputMessageView.getText().toString().trim();
        Log.d("Working attemptSend()", "Success");
        if(TextUtils.isEmpty(message)) {
            mInputMessageView.requestFocus();
            return;
        }

        mInputMessageView.setText("");
        addMessage(mUsername, message);

        try {
            JSONObject data = new JSONObject();
            data.put("user_id", mUserID);
            data.put("username", mUsername);
            data.put("message", message);
            data.put("room_id", roomID);

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
