package com.irfanrosandi.masjidmap;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

public class MainActivity extends ActionBarActivity implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    private TextView tvWelcome;
    private String nama;
    private Button btnViewMap, btnTimeline, btnLogout, btnSetCity;
    private AlertDialog.Builder alertDialogBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        tvWelcome = (TextView) findViewById(R.id.tvWelcome);
        btnViewMap = (Button) findViewById(R.id.btnViewMap);
        btnTimeline = (Button) findViewById(R.id.btnTimeline);
        btnLogout = (Button) findViewById(R.id.btnLogout);
        btnSetCity = (Button) findViewById(R.id.btnSetCity);

        ambilDataIntent();

        tvWelcome.setText("Hi " + nama + ", Welcome to the App!");


        btnSetCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ActivityMyCity.class);
                startActivity(intent);
            }
        });


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

                alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);

                alertDialogBuilder.setTitle("Exit");

                alertDialogBuilder.setMessage("Yakin mau keluar bro?");

                alertDialogBuilder.setCancelable(false);

                alertDialogBuilder.setIcon(android.R.drawable.star_off);

                alertDialogBuilder.setPositiveButton("Ya Gue Mau Keluar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                        startActivity(intent);
                    }
                });

                alertDialogBuilder.setNegativeButton("Ga Jadi Bro", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                AlertDialog alertDialog = alertDialogBuilder.create();

                alertDialog.show();
            }
        });
    }

    private void ambilDataIntent(){
        Intent intent = getIntent();
        nama = intent.getStringExtra("keyNama");
    }

    @Override
    public void onConnected(Bundle bundle) {

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }
}