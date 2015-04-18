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
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.model.LatLng;

import java.io.IOException;
import java.util.ArrayList;

import pl.charmas.android.reactivelocation.ReactiveLocationProvider;
import rx.functions.Action1;

public class MainActivity extends ActionBarActivity implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    private String nama, city;
    private double myLat, myLng;

    private TextView tvLatLng, tvCity;
    private Button btnTimeline, btnLogout, btnSetCity;
    private AlertDialog.Builder alertDialogBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        tvLatLng = (TextView) findViewById(R.id.tvLatLng);
        tvCity = (TextView) (findViewById(R.id.tvCity));
        btnTimeline = (Button) findViewById(R.id.btnTimeline);
        btnLogout = (Button) findViewById(R.id.btnLogout);
        btnSetCity = (Button) findViewById(R.id.btnSetCity);

        ambilDataIntent();

        btnSetCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // getting my latitude and my longitude
                ReactiveLocationProvider locationProvider = new ReactiveLocationProvider(getApplicationContext());
                locationProvider.getLastKnownLocation()
                        .subscribe(new Action1<Location>() {
                            @Override
                            public void call(Location location) {
                                myLat = location.getLatitude();
                                myLng = location.getLongitude();
                                tvLatLng.setText("Lat : " + myLat + " Lng : " + myLng);
                            }
                        });

                // convert my latitude and longitude to a city name
                Geocoder mGeocoder = new Geocoder(getApplicationContext());

                ArrayList<Address> addresses = null;
                try {
                    addresses = (ArrayList<Address>) mGeocoder.getFromLocation(3.5833, 98.6667, 1);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (addresses != null && addresses.size() > 0) {
                    city = addresses.get(0).getLocality();
                    tvCity.setText(city);
                }
                else if (addresses.isEmpty()){
                    Toast.makeText(getApplicationContext(), "address returns empty", Toast.LENGTH_SHORT).show();
                }
                else if(addresses == null){
                    Toast.makeText(getApplicationContext(), "address returns null", Toast.LENGTH_SHORT).show();
                }
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