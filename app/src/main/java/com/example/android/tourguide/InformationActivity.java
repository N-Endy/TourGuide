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
        if(getIntent().hasExtra("bundleExtra") ) {
            Log.v("intents", "getIncomingIntent: Yes it has intent!");
            Bundle bundle = getIntent().getExtras();
            int name = bundle.getInt("name");
            Log.i("name", "getIncomingIntent: " + name);
            int address = bundle.getInt("address");
            Log.i("address", "getIncomingIntent: " + address);
            setIncomingIntent(String.valueOf(name), String.valueOf(address));
        }
    }

    /**
     *
     * @param placeName name of location gotten from Intent
     * @param placeAddress address of location gotten from Intent
     */
    private void setIncomingIntent(String placeName, String placeAddress) {
        // Find and set name text
        TextView name = findViewById(R.id.info_name);
        name.setText(placeName);

        // Find and set address text
        TextView address = findViewById(R.id.info_address);
        address.setText(placeAddress);

        // Find and set image
        ImageView imageView = findViewById(R.id.info_image);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            int image = bundle.getInt("image");
            imageView.setImageResource(image);
        }
    }
}