package com.irfanrosandi.masjidmap;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class RandomPlaceActivity extends ActionBarActivity {

    Button btnRandom;
    TextView tvCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.random_place_activity);

        btnRandom = (Button) findViewById(R.id.btnRandom);
        tvCity = (TextView) findViewById(R.id.tvCity);

        btnRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Random random = new Random();
                final String[] city = {"Medan", "Jakarta", "Bandung", "Surabaya", "Lhokseumawe", "Palembang", "Bekasi"};
                int randomNumber = random.nextInt(city.length);

                tvCity.setText(city[randomNumber]);

            }
        });
    }

  }
