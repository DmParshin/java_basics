package ru.skillbox;

import javax.annotation.processing.Processor;

public class Computer {

    public final String vendor;
    public final String name;

    public ProcessorManufacturer processorManufacturer;
    public int cpuFrequency;
    public int cpuCores;
    public double cpuWeight;

//    public RamType ramType;
//    public int ramSize;
//    public double ramWeight;

    public HarddiskType harddiskType;
    public int hddSize;
    public double hddWeight;

    public DisplayType displayType;
    public int displayDiagonal;
    public double displayWeight;

    public KeyboardType keyboardType;
    public boolean keyboardLight;
    public double keyboardWeight;

    public double weight;

    public Computer(String name, String vendor){
        this.name = name;
        this.vendor = vendor;
    }

    public ProcessorManufacturer getProcessorManufacturer() {
        return processorManufacturer;
    }

    public void setProcessorManufacturer(ProcessorManufacturer processorManufacturer) {
        this.processorManufacturer = processorManufacturer;
    }

    public int getCpuFrequency() {
        return cpuFrequency;
    }

    public void setCpuFrequency(int cpuFrequency) {
        this.cpuFrequency = cpuFrequency;
    }

    public int getCpuCores() {
        return cpuCores;
    }

    public void setCpuCores(int cpuCores) {
        this.cpuCores = cpuCores;
    }

    public double getCpuWeight() {
        return cpuWeight;
    }

    public void setCpuWeight(double cpuWeight) {
        this.cpuWeight = cpuWeight;
        weight = weight + cpuWeight;
    }

//    public RamType getRamType() {
//        return ramType;
//    }
//
//    public void setRamType(RamType ramType) {
//        this.ramType = ramType;
//    }
//
//    public int getRamSize() {
//        return ramSize;
//    }
//
//    public void setRamSize(int ramSize) {
//        this.ramSize = ramSize;
//    }
//
//    public double getRamWeight() {
//        return ramWeight;
//    }
//
//    public void setRamWeight(double ramWeight) {
//        this.ramWeight = ramWeight;
//        weight = weight + ramWeight;
//    }

    public HarddiskType getHarddiskType() {
        return harddiskType;
    }

    public void setHarddiskType(HarddiskType harddiskType) {
        this.harddiskType = harddiskType;
    }

    public int getHddSize() {
        return hddSize;
    }

    public void setHddSize(int hddSize) {
        this.hddSize = hddSize;
    }

    public double getHddWeight() {
        return hddWeight;
    }

    public void setHddWeight(double hddWeight) {
        this.hddWeight = hddWeight;
        weight = weight + hddWeight;
    }

    public DisplayType getDisplayType() {
        return displayType;
    }

    public void setDisplayType(DisplayType displayType) {
        this.displayType = displayType;
    }

    public int getDisplayDiagonal() {
        return displayDiagonal;
    }

    public void setDisplayDiagonal(int displayDiagonal) {
        this.displayDiagonal = displayDiagonal;
    }

    public double getDisplayWeight() {
        return displayWeight;
    }

    public void setDisplayWeight(double displayWeight) {
        this.displayWeight = displayWeight;
        weight = weight + displayWeight;
    }

    public KeyboardType getKeyboardType() {
        return keyboardType;
    }

    public void setKeyboardType(KeyboardType keyboardType) {
        this.keyboardType = keyboardType;
    }

    public boolean isKeyboardLight() {
        return keyboardLight;
    }

    public void setKeyboardLight(boolean keyboardLight) {
        this.keyboardLight = keyboardLight;
    }

    public double getKeyboardWeight() {
        return keyboardWeight;
    }

    public void setKeyboardWeight(double keyboardWeight) {
        this.keyboardWeight = keyboardWeight;
        weight = weight + keyboardWeight;
    }

    public String toString(){
        return "Название - " + name
                + "\nПроизводитель - " + vendor
                + "\nЧастота процессора - " + cpuFrequency
                + "\nКоличество ядер - " + cpuCores
                + "\nВес процессора - " + cpuWeight
                + "\nТип RAM - " + Ram.getRamType()
                + "\nОбъем RAM - " + Ram.getRamSize()
                + "\nВес RAM - " + Ram.getRamWeight()
                + "\nТип HDD - " + harddiskType
                + "\nОбъем HDD - " + hddSize
                + "\nВес HDD - " + hddWeight
                + "\nДиагональ экрана - " + displayDiagonal
                + "\nТип экрана - " + displayType
                + "\nВес экрана - " + displayWeight
                + "\nТип клавиатуры - " + keyboardType
                + "\nПодсветка - " + keyboardLight
                + "\nВес клавиатуры - " + keyboardWeight
                + "\nОбщий вес - " + weight
                + "\n- - - - - - - - - - "
                ;
    }
}
