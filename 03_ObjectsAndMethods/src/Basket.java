public class Basket {

    private static int count = 0;
    private String items = "";
    private int totalPrice = 0;
    private int limit;

    private static double allTotalPrice;
    private static int allTotalCount;

    private double totalWeight = 0; // Добавляем переменную общего веса

    public Basket() {
        increaseCount(1);
        items = "Список товаров:";
        this.limit = 1000000;
    }

    public Basket(int limit) {
        this();
        this.limit = limit;
    }

    public Basket(String items, int totalPrice, double totalWeight) {
        this();
        this.items = this.items + items;
        this.totalPrice = totalPrice;
        this.totalWeight = totalWeight;
    }

    public static int getCount() {
        return count;
    }

    public static void increaseCount(int count) {
        Basket.count = Basket.count + count;
    }

    public static void increaseAllTotalCount(int count) {Basket.allTotalCount = Basket.allTotalCount + count;}

    public static void increaseAllTotalPrice(int count, int price) {Basket.allTotalPrice = Basket.allTotalPrice + (count * price);}

    public static double allAveragePrice(){ return allTotalPrice / allTotalCount; }

    public static double allAveragePriceBasket() { return allTotalPrice / count; }

    public void add(String name, int price) {
        add(name, price, 1, 0);
    }

    public void add(String name, int price, double weight){  // Добавляем метод с параметром веса и отсутствием количества
        add(name, price, 1, weight);
    }

    public void add(String name, int price, int count, double weight) {
        boolean error = false;
        if (contains(name)) {
            error = true;
        }

        if (totalPrice + count * price >= limit) {
            error = true;
        }

        if (error) {
            System.out.println("Error occured :(");
            return;
        }

        items = items + "\n" + name + " - " +
            count + " шт. - " + price +  " у.е" + " - " + weight +  " g";
        totalPrice = totalPrice + count * price;
        totalWeight = totalWeight + count * weight;

        increaseAllTotalCount(count);
        increaseAllTotalPrice(count, price);
    }

    public void clear() {
        items = "";
        totalPrice = 0;
        totalWeight = 0;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public double getTotalWeight() {
        return totalWeight;
    }

    public boolean contains(String name) {
        return items.contains(name);
    }

    public void print(String title) {
        System.out.println(title);
        if (items.isEmpty()) {
            System.out.println("Корзина пуста");
        } else {
            System.out.println(items);
        }
        System.out.println("Total Price: " + this.getTotalPrice());
        System.out.println("Total Weight: " + this.getTotalWeight());
        System.out.println("All Total Count: " + Basket.allTotalCount);
        System.out.println("All Total Price: " + Basket.allTotalPrice);
        System.out.println("All Average Price: " + Basket.allAveragePrice());
        System.out.println("All Average per Basket: " + Basket.allAveragePriceBasket());
    }
}
