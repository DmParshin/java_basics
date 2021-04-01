package ru.skillbox;

public class Ram {
    private static RamType ramType;
    private static int ramSize;
    private static double ramWeight;

    public Ram(RamType ramType, int ramSize, double ramWeight) {
        this.ramType = ramType;
        this.ramSize = ramSize;
        this.ramWeight = ramWeight;
    }

    public static RamType getRamType() {
        return ramType;
    }

    public static int getRamSize() {
        return ramSize;
    }

    public static double getRamWeight() {
        return ramWeight;
    }
}
