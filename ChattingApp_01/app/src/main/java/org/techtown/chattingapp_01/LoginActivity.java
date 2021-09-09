package org.techtown.chattingapp_01;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class LoginActivity extends Activity {
    Button btn_sign_in;
    EditText username_input;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sgin_up);

        username_input = findViewById(R.id.username_input);
        btn_sign_in = findViewById(R.id.sign_in_button);

        btn_sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, ChatActivity.class);
                intent.putExtra("username", username_input.getText().toString());
                startActivity(intent);
                finish();
            }
        });

        //user name 입력 후 키보드 내리기
        username_input.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {

                String userName = textView.getText().toString();

                if(userName.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "please input your name!", Toast.LENGTH_SHORT).show();
                    textView.clearFocus();
                    textView.setFocusable(false);
                    textView.setFocusableInTouchMode(true);
                    textView.setFocusable(true);

                    return true;
                }

                switch (i) {

                    default:


                        return false;
                }
            }
        });
    }
}
