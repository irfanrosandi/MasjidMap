package com.irfanrosandi.masjidmap;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    private TextView tvWelcome;
    private String nama;
    private Button btnViewMap, btnTimeline, btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        tvWelcome = (TextView) findViewById(R.id.tvWelcome);
        btnViewMap = (Button) findViewById(R.id.btnViewMap);
        btnTimeline = (Button) findViewById(R.id.btnTimeline);
        btnLogout = (Button) findViewById(R.id.btnLogout);

        Intent intent = getIntent();
        nama = intent.getStringExtra("keyNama");

        tvWelcome.setText("Hi " + nama + ", Welcome to the App!");

        btnViewMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentBukaMapActivity = new Intent("com.irfanrosandi.masjidmap.MapActivity");
                startActivity(intentBukaMapActivity);
            }
        });

        btnTimeline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TimelineActivity.class);
                startActivity(intent);
            }
        });

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

    }

}