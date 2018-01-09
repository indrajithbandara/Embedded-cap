package com.example.hadri_santos.aula11_broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ClassReceiver classReceiver;
    private IntentFilter intentFilter;
    public static final String CUSTOM_INTENT = "hadrizia.custom.intent.action.TEST";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        classReceiver = new ClassReceiver();
        intentFilter = new IntentFilter(CUSTOM_INTENT);
        registerReceiver(classReceiver, intentFilter);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(classReceiver);
    }

    private class ClassReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            TextView textView = findViewById(R.id.tv_broadcast_receiver);
            textView.setText("detected: " + intent.getAction());
            Log.d("broadcast", "detected: " + intent.getAction());
        }
    }
}
