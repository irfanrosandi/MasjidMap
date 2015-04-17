package com.irfanrosandi.masjidmap;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

public class ActivityMyCity extends ActionBarActivity {

    TextView tvCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_city);

        tvCity = (TextView) findViewById(R.id.tvCity);

        Geocoder gCoder = new Geocoder(this);

        ArrayList<Address> addresses = null;
        try {
            addresses = (ArrayList<Address>) gCoder.getFromLocation(3.5833, 98.6667, 1); // lat long jakarta
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (addresses != null && addresses.size() > 0) {
            tvCity.setText(addresses.get(0).getLocality());
        }

    }
}
