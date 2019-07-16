package com.pato.alc_challenge_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnAboutAlc, btnMyProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAboutAlc = (Button)findViewById(R.id.btnAboutAlc);
        btnMyProfile = (Button)findViewById(R.id.btnMyProfile);

        //set Action Listeners.
        btnAboutAlc.setOnClickListener(this);
        btnMyProfile.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnAboutAlc:
                Intent aboutAlcIntent = new Intent(MainActivity.this, AboutALC.class);
                startActivity(aboutAlcIntent);
                break;

            case R.id.btnMyProfile:
                Intent myProfIntent = new Intent(MainActivity.this,MyProfile.class);
                startActivity(myProfIntent);
                break;

        }

    }
}
