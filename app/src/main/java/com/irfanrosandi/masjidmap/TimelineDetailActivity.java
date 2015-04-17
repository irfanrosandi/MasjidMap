package com.irfanrosandi.masjidmap;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class TimelineDetailActivity extends ActionBarActivity {


    private GoogleMap map;
    private double latitude = 3.58429903;
    private double longitude = 98.66441488;
    private LatLng posisiRumah = new LatLng(latitude, longitude);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timeline_detail_activity);

        if(terkoneksiInternet()){
            // Cek apakah map ada apa tidak
            if(map == null){
                map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();

                if(map == null){
                    Toast.makeText(getApplicationContext(), "Sorry, gak bisa buat map bro", Toast.LENGTH_SHORT).show();
                }
            }

            map.addMarker(new MarkerOptions()
                            .position(posisiRumah)
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE))
                            .title("Rumah gua")
                            .snippet("Jalan Blang Malo")
            );

            map.animateCamera(CameraUpdateFactory.newLatLngZoom(posisiRumah, 15));
            //map.setMyLocationEnabled(true);
        }
        else if(!terkoneksiInternet()){
            Toast.makeText(getApplicationContext(), "Pastikan smartphone nya terkoneksi ke internet bro..", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean terkoneksiInternet(){
        ConnectivityManager connManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connManager.getActiveNetworkInfo();

        if(networkInfo != null && networkInfo.isConnected())
            return true;
        else
            return false;
    }

}

