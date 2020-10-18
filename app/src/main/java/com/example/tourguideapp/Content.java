package com.example.tourguideapp;

public class Content {
    private String PlaceName;
    private String Description;
    private String Address;
    private String PhoneNumber;
    private int ImageResId;

    public Content(String placeName, String description, String address, String phoneNumber, int imageResId) {
        PlaceName = placeName;
        Description = description;
        Address = address;
        PhoneNumber = phoneNumber;
        ImageResId = imageResId;
    }

    public String getPlaceName() {
        return PlaceName;
    }

    public String getDescription() {
        return Description;
    }

    public String getAddress() {
        return Address;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public int getImageResId() {
        return ImageResId;
    }
}
