package com.irfanrosandi.masjidmap;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;


public class HasilBroadcastActivity extends Activity {


    private GoogleMap map;
    private double latitude = 3.58429903;
    private double longitude = 98.66441488;
    private LatLng posisiRumah = new LatLng(latitude, longitude);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hasil_broadcast);
    }

}
