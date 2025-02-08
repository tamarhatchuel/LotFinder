package com.example.lotfinder.models;

public class ParkingLot {
    private String name;
    private String price;
    private String distance;
    private int availability;
    private boolean isPremium; // Determines if it's a premium parking lot

    // Constructor
    public ParkingLot(String name, String price, String distance, int availability, boolean isPremium) {
        this.name = name;
        this.price = price;
        this.distance = distance;
        this.availability = availability;
        this.isPremium = isPremium;
    }

    // Getters
    public String getName() { return name; }
    public String getPrice() { return price; }
    public String getDistance() { return distance; }
    public int getAvailability() { return availability; }
    public boolean isPremium() { return isPremium; }
}
