package com.example.herztour;

public class Location {

    private String name;
    private String address;
    private int imageResourceId;
    private String typeOfLocation;
    private final String NO_TYPE = "";
    private int sound;

    /**
     * Crate new location object
     *
     * @param name    as name of location
     * @param address as address of location
     * @param image   as image resource for specific location
     */

    public Location(String name, String address, int image) {
        this.name = name;
        this.address = address;
        this.imageResourceId = image;
    }

    /**
     * Crate new location object
     *
     * @param name    as name of location
     * @param address as address of location
     * @param image   as image resource for specific location
     * @param type    as type of location (hiking, restaurant etc.)
     */

    public Location(String name, String address, int image, String type) {
        this.name = name;
        this.address = address;
        this.imageResourceId = image;
        this.typeOfLocation = type;
    }

    /**
     * Crate new location object
     *
     * @param name    as name of location
     * @param address as address of location
     * @param image   as image resource for specific location
     * @param type    as type of location (hiking, restaurant etc.)
     */

    public Location(String name, String address, int image, String type, int sound) {
        this.name = name;
        this.address = address;
        this.imageResourceId = image;
        this.typeOfLocation = type;
        this.sound = sound;
    }

    public boolean isType() {
        return typeOfLocation != NO_TYPE;
    }

    //Getters
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public String getTypeOfLocation() {
        return typeOfLocation;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    public void setTypeOfLocation(String typeOfLocation) {
        this.typeOfLocation = typeOfLocation;
    }

    public int getSound() {
        return sound;
    }

    public void setSound(int sound) {
        this.sound = sound;
    }
}
