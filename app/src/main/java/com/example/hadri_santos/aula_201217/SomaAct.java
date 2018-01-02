package com.example.hadri_santos.aula_201217;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class SomaAct extends AppCompatActivity {
    public static final int ZERO = 0;
    TextView first_value;
    TextView second_value;
    int result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soma);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        first_value = findViewById(R.id.first_value);
        second_value = findViewById(R.id.second_value);

        FloatingActionButton fab = findViewById(R.id.sum);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int f_value = ZERO;
                int s_value = ZERO;

                if(!first_value.getText().toString().equals("")){
                    f_value = Integer.parseInt(String.valueOf(first_value.getText()));
                }

                if(!second_value.getText().toString().equals("")) {
                    s_value = Integer.parseInt(String.valueOf(second_value.getText()));
                }

                int result = f_value + s_value;

                Bundle bundle = new Bundle();
                bundle.putString("result", String.valueOf(result));

                Intent it = new Intent(SomaAct.this,
                        MainActivity.class);
                it.putExtras(bundle);

                setResult(MainActivity.SUM_ACTIVITY_REQUEST_CODE, it);
                finish();
            }
        });

        FloatingActionButton cancel = findViewById(R.id.cancel_action);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(SomaAct.this,
                        MainActivity.class);
                startActivity(it);
                finish();
            }
        });
    }
}
