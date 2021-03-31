package ru.skillbox;

public class Order {
    private final Dimensions dimensions;
    private final double mass;
    private final String address;
    private final boolean overturn;
    private final String regnumber;
    private final boolean fragile;

    public Order(Dimensions dimensions,double mass, String address, boolean overturn, String regnumber, boolean fragile) {
        this.dimensions = dimensions;
        this.mass = mass;
        this.address = address;
        this.overturn = overturn;
        this.regnumber = regnumber;
        this.fragile = fragile;
    }

    public Order setAddress(String address){
        return new Order(dimensions,mass,address,overturn,regnumber,fragile);
    }

    public Order setMass(double mass){
        return new Order(dimensions,mass,address,overturn,regnumber,fragile);
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public double getMass() {
        return mass;
    }

    public String getAddress() {
        return address;
    }

    public boolean isOverturn() {
        return overturn;
    }

    public String getRegnumber() {
        return regnumber;
    }

    public boolean isFragile() {
        return fragile;
    }

    public String print(){
        return  (dimensions +
                "\nМасса - " + mass +
                "\nАдрес - " + address +
                "\nМожно переворачивать? - " + overturn +
                "\nРегистрационный номер - " +regnumber +
                "\nХрупкое? - " + fragile );
    }

}
