package com.example.android.tourguide;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

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
        if(bundle != null ) {
            int name = bundle.getInt("name");
            int address = bundle.getInt("address");
            int image = bundle.getInt("image");
            setIncomingIntent(name, address, image);
        }
    }

    /**
     *
     * @param placeName name of location gotten from Intent
     * @param placeAddress address of location gotten from Intent
     */
    private void setIncomingIntent(int placeName, int placeAddress, int image) {
        // Find and set name text
        TextView name = findViewById(R.id.info_name);
        name.setText(placeName);

        // Find and set address text
        TextView address = findViewById(R.id.info_address);
        address.setText(placeAddress);

        // Find and set image
        ImageView imageView = findViewById(R.id.info_image);
        imageView.setImageResource(image);
    }
}