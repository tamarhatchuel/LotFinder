package com.example.lotfinder;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ParkingDetailsActivity extends AppCompatActivity {
    private TextView parkingName, parkingPrice, parkingDistance, parkingAvailability;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parking_details);

        parkingName = findViewById(R.id.parkingName);
        parkingPrice = findViewById(R.id.parkingPrice);
        parkingDistance = findViewById(R.id.parkingDistance);
        parkingAvailability = findViewById(R.id.parkingAvailability);

        // Get data from Intent
        String name = getIntent().getStringExtra("PARKING_NAME");
        String price = getIntent().getStringExtra("PARKING_PRICE");
        String distance = getIntent().getStringExtra("PARKING_DISTANCE");
        int availability = getIntent().getIntExtra("PARKING_AVAILABILITY", 0);

        // Set data to TextViews
        parkingName.setText("Name: " + name);
        parkingPrice.setText("Price: " + price);
        parkingDistance.setText("Distance: " + distance);
        parkingAvailability.setText("Available spots: " + availability);
    }
}
