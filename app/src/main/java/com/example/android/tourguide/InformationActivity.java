package com.example.android.tourguide;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class InformationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        getIncomingIntent();
    }

    /**
     * Method to get extras from incoming Intent
     */
    private void getIncomingIntent() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String name = bundle.getString("name");
            String address = bundle.getString("address");
            int image = bundle.getInt("image");

            setIncomingIntent(name, address, image);
        }
    }

    /**
     *
     * @param placeName name of location gotten from Intent
     * @param placeAddress address of location gotten from Intent
     * @param image
     */
    private void setIncomingIntent(String placeName, String placeAddress, int image) {
        // Find and set text
    }
}