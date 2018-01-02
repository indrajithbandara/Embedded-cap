package com.example.hadri_santos.aula_201217;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    protected static final int SUM_ACTIVITY_REQUEST_CODE = 100;
    public static final String SUM_FRAGMENT = "SUM_FRAGMENT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button fab = findViewById(R.id.sum_begin);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,
                        SomaAct.class);
                startActivityForResult(i, SUM_ACTIVITY_REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SUM_ACTIVITY_REQUEST_CODE) {

            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            fragmentTransaction.replace(R.id.frame, new SumFragment(), SUM_FRAGMENT);

            fragmentTransaction.commit();

            fragmentManager.executePendingTransactions();

            Bundle extra = data.getExtras();

            if (extra != null) {
                SumFragment fragment = (SumFragment) fragmentManager.findFragmentByTag(SUM_FRAGMENT);
                if (fragment != null) {
                    View fragment_view = fragment.getView();
                    TextView t = fragment_view.findViewById(R.id.result);
                    t.setText((extra.getString("result")));
                }
            }
        }
    }
}
