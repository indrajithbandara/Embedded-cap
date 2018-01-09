package com.example.hadri_santos.aula11broadcastsender;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public static final String CUSTOM_INTENT = "hadrizia.custom.intent.action.TEST";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.btn_send_broadcast);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(CUSTOM_INTENT);
        sendBroadcast(intent);
        Log.d("broadcast", "sent: " + intent.getAction());
    }
}
