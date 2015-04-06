package com.irfanrosandi.masjidmap;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends Activity implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    private TextView tvWelcome;
    private String nama;
    private Button btnViewMap, btnTimeline, btnLogout;
    private AlertDialog.Builder alertDialogBuilder;

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