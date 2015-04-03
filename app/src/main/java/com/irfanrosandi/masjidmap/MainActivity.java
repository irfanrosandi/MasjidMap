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
    private Button btnViewMap, btnRandomPlace, btnListCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        tvWelcome = (TextView) findViewById(R.id.tvWelcome);
        btnViewMap = (Button) findViewById(R.id.btnViewMap);
        btnRandomPlace = (Button) findViewById(R.id.btnRandomPlace);
        btnListCity = (Button) findViewById(R.id.btnListCity);

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

        btnRandomPlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.irfanrosandi.masjidmap.RandomPlaceActivity");
                startActivity(intent);
            }
        });

        btnListCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NewsFeedActivity.class);
                startActivity(intent);
            }
        });

    }

}