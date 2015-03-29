package com.irfanrosandi.masjidmap;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class LoginActivity extends ActionBarActivity {

    Button btnLogin, btnAbout;
    EditText etNama;
    String nama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnAbout = (Button) findViewById(R.id.btnAbout);
        etNama = (EditText) findViewById(R.id.etEnterName);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                nama = etNama.getText().toString();
                Intent intent = new Intent("com.irfanrosandi.masjidmap.MainActivity");
                intent.putExtra("keyNama", nama);
                startActivity(intent);
            }
        });

        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.irfanrosandi.masjidmap.AboutActivity");
                startActivity(intent);
            }
        });
    }


}
