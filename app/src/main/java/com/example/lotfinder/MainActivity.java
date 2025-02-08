package com.example.lotfinder;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.lotfinder.models.ParkingLot;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText searchLocation;
    private ImageView searchButton;  // Fixed: ImageView instead of Button
    private Button findParkingButton;
    private RecyclerView parkingRecyclerView;
    private ParkingAdapter adapter;
    private List<ParkingLot> parkingLots;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchLocation = findViewById(R.id.searchLocation);
        searchButton = findViewById(R.id.searchButton);
        findParkingButton = findViewById(R.id.findParkingButton);
        parkingRecyclerView = findViewById(R.id.parkingRecyclerView);

        // Initialize parking lots list
        parkingLots = new ArrayList<>();
        populateSampleParkingData();

        // Set up RecyclerView
        adapter = new ParkingAdapter(parkingLots, this::openParkingDetails);
        parkingRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        parkingRecyclerView.setAdapter(adapter);

        searchButton.setOnClickListener(v -> performSearch());
        findParkingButton.setOnClickListener(v -> performSearch());
    }

    private void openParkingDetails(ParkingLot parkingLot) {
    }

    private void populateSampleParkingData() {
        parkingLots.add(new ParkingLot("Beach Parking", "$5/hour", "500m", 20, true));
        parkingLots.add(new ParkingLot("City Mall", "$3/hour", "1km", 50, false));
        parkingLots.add(new ParkingLot("Underground Lot", "$4/hour", "700m", 10, false));
    }

    private void performSearch() {
        String query = searchLocation.getText().toString().trim();
        if (!query.isEmpty()) {
            List<ParkingLot> filteredList = new ArrayList<>();
            for (ParkingLot lot : parkingLots) {
                if (lot.getName().toLowerCase().contains(query.toLowerCase())) {
                    filteredList.add(lot);
                }
            }
            adapter.updateList(filteredList);
        }
    }
}
