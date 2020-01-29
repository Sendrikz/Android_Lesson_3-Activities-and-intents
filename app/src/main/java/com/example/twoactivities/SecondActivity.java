package com.example.twoactivities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    private static final String LOG_TAG = SecondActivity.class.toString();

    public static final String REPLY_MESSAGE = "com.example.twoactivities.reply.Message";

    private EditText messageReplyEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        messageReplyEditText = findViewById(R.id.text_reply);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.SEND_MESSAGE);
        TextView textView = findViewById(R.id.text_message);
        textView.setText(message);
    }

    public void sendReplyToMainActivity(View view) {
        Log.d(LOG_TAG, "Button REPLY click");
        String replyMessage = messageReplyEditText.getText().toString();

        Intent replyIntent = new Intent();
        replyIntent.putExtra(REPLY_MESSAGE, replyMessage);
        setResult(RESULT_OK, replyIntent);
        finish();
    }
}
