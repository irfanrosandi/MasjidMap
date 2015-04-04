package com.irfanrosandi.masjidmap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class NewsFeedActivity extends Activity {

    private ListView lvCity;
    private Button btnNewBroadcast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_feed_activity);

        lvCity = (ListView) findViewById(R.id.lvCity);
        btnNewBroadcast = (Button) findViewById(R.id.btnNewBroadcast);

        String[] judul = new String[] {"Irfan Rosandi, Pemenang TopCoder Tingkat Dunia", "Dari Konsultan Menjadi Freelancer", "Persiapan Menuju Akhirat", "Perjuangan Menuju Surga", "Siapa Saja Bisa Sukses", "Jalan Sudirman Macet Total", "Jakarta Kota Termacet Di Dunia", "Diskon KFC 50% Hari Ini"};
        ListAdapter myCustomAdapter = new CustomListAdapter(this, judul);
        ListView myListView = (ListView) findViewById(R.id.lvCity);

        myListView.setAdapter(myCustomAdapter);

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //String judul = String.valueOf(parent.getItemAtPosition(position));
                //Toast.makeText(getApplicationContext(), judul, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(NewsFeedActivity.this, HasilBroadcastActivity.class);
                startActivity(intent);
            }
        });

        btnNewBroadcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewsFeedActivity.this, NewBroadcastActivity.class);
                startActivity(intent);
            }
        });

    }

}
