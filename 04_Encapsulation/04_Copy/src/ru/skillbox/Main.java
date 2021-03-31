package ru.skillbox;

public class Main {

    public static void main(String[] args) {
        Dimensions d1 = new Dimensions();
        d1.setHeight(131);
        Order ord1 = new Order(d1, 10,"ул.Тестовая 15 кв 24",true, "N-123465",  false);
        System.out.println(ord1.print());
        d1.setHeight(9999999);
        ord1.setMass(999);
        System.out.println(d1);
        System.out.println(ord1.print());
    }
}
