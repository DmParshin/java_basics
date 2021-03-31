package ru.skillbox;

public class Main {

    public static void main(String[] args) {
        Dimensions dim1 = new Dimensions(1,2,3);
        dim1 = dim1.setHeight(131);
        Order ord1 = new Order(dim1, 10,"ул.Тестовая 15 кв 24",true, "N-123465",  false);
        System.out.println(ord1);
        ord1 = ord1.setMass(999);
        System.out.println(ord1);
    }
}
