//Габариты — ширина, высота и длина — должны храниться в отдельном иммутабельном классе Dimensions.
//Создайте класс Dimensions с соответствующими полями и реализуйте в нём метод вычисления объёма груза
//width height length
package ru.skillbox;

public class Dimensions {
    private final double wight;
    private final double height;
    private final double length;

    public Dimensions(double wight, double height, double length) {
        this.wight = wight;
        this.height = height;
        this.length = length;
    }

    public Dimensions() {
        wight = 0;
        height = 0;
        length = 0;
    }

    public Dimensions setWight(double wight){
        return new Dimensions(wight, height, length);
    }

    public Dimensions setHeight(double height){
        return new Dimensions(wight, height, length);
    }

    public Dimensions setLength(double length){
        return new Dimensions(wight, height, length);
    }

    public double getWight() {
        return wight;
    }

    public double getHeight() {
        return height;
    }

    public double getLength() {
        return length;
    }

    public double size(){
        return (wight * height * length);
    }

    public String print(){
        return "Ширина - " + wight + " Высота - " + height + " Длина - " + length;
    }
}
