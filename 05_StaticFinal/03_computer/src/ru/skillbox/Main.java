package ru.skillbox;

public class Main {

    public static void main(String[] args) {
        Computer comp1 = new Computer("Notebook", "Lenovo");
        Computer comp2 = new Computer("Notebook", "Apple");
        Computer comp3 = new Computer("Notebook", "Sony");


        comp1.setCpuFrequency(6666);
        comp1.setCpuCores(99);
        comp1.setProcessorManufacturer(ProcessorManufacturer.AMD);
        comp1.setCpuWeight(555);

        comp1.setRamType(RamType.DDR3);
        comp1.setRamSize(8000);
        comp1.setRamWeight(150);

        comp1.setHarddiskType(HarddiskType.SSD);
        comp1.setHddSize(16000);
        comp1.setHddWeight(1500);

        comp1.setDisplayDiagonal(15);
        comp1.setDisplayType(DisplayType.TN);
        comp1.setDisplayWeight(1300);

        comp1.setKeyboardType(KeyboardType.MEMBRANE);
        comp1.setKeyboardLight(false);
        comp1.setKeyboardWeight(140);
// ==========================================
        comp2.setCpuFrequency(6666);
        comp2.setCpuCores(22);
        comp2.setProcessorManufacturer(ProcessorManufacturer.AMD);
        comp2.setCpuWeight(123);

        comp2.setRamType(RamType.DDR4);
        comp2.setRamSize(4222);
        comp2.setRamWeight(150);

        comp2.setHarddiskType(HarddiskType.HDD);
        comp2.setHddSize(14000);
        comp2.setHddWeight(1100);

        comp2.setDisplayDiagonal(12);
        comp2.setDisplayType(DisplayType.IPS);
        comp2.setDisplayWeight(1300);

        comp2.setKeyboardType(KeyboardType.MEMBRANE);
        comp2.setKeyboardLight(false);
        comp2.setKeyboardWeight(140);

// ====================================================

        comp3.setCpuFrequency(6166);
        comp3.setCpuCores(19);
        comp3.setProcessorManufacturer(ProcessorManufacturer.AMD);
        comp3.setCpuWeight(515);

        comp3.setRamType(RamType.DDR4);
        comp3.setRamSize(4000);
        comp3.setRamWeight(150);

        comp3.setHarddiskType(HarddiskType.HDD);
        comp3.setHddSize(11000);
        comp3.setHddWeight(1100);

        comp3.setDisplayDiagonal(15);
        comp3.setDisplayType(DisplayType.VA);
        comp3.setDisplayWeight(1100);

        comp3.setKeyboardType(KeyboardType.MEMBRANE);
        comp3.setKeyboardLight(false);
        comp3.setKeyboardWeight(110);

        System.out.println(comp1.toString());
        System.out.println(comp2.toString());
        System.out.println(comp3.toString());
    }
}
