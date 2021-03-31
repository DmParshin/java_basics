package ru.skillbox;

public class Country {
    public String name;
    public int area;
    public String capital;
    public boolean accessToSea;

    public Country(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getArea() {
        return area;
    }

    public String getCapital() {
        return capital;
    }

    public boolean isAccessToSea() {
        return accessToSea;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public void setAccessToSea(boolean accessToSea) {
        this.accessToSea = accessToSea;
    }
}
