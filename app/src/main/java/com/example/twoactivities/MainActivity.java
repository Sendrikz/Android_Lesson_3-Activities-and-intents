package com.example.twoactivities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    public static final String SEND_MESSAGE = "com.example.android.twoactivities.send.MESSAGE";
    public static final int TEXT_REQUEST = 1;

    private EditText messageEditText;
    private TextView messageReplyHeaderTextView;
    private TextView messageReplyTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        messageEditText = findViewById(R.id.main_editText);
        messageReplyHeaderTextView = findViewById(R.id.text_header_reply);
        messageReplyTextView = findViewById(R.id.text_message_reply);
    }

    public void launchSecondActivity(View view) {
        Log.d(LOG_TAG, "Button SEND clicked");

        Intent intent = new Intent(this, SecondActivity.class);
        String message = messageEditText.getText().toString();
        intent.putExtra(SEND_MESSAGE, message);
        startActivityForResult(intent, TEXT_REQUEST);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Log.d(LOG_TAG, String.format("Get response from second activity intent with request code ",
                TEXT_REQUEST));

        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                String reply = data.getStringExtra(SecondActivity.REPLY_MESSAGE);
                messageReplyTextView.setText(reply);
                messageReplyTextView.setVisibility(View.VISIBLE);
                messageReplyHeaderTextView.setVisibility(View.VISIBLE);
            }
        }
    }
}
