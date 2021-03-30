public class Main {

    public static void main(String[] args) {
        Basket basket1 = new Basket();
        basket1.add("Milk", 40);
        basket1.add("Oil", 140, 2,2.5);
        basket1.add("Salt", 7, 2.5);
        basket1.print("");

        Basket basket2 = new Basket();
        basket2.add("Sugar", 80);
        basket2.add("Bread", 20, 3,5.0);
        basket2.add("Salt", 7, 1.5);
        basket2.print("");
    }
}
