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

//        System.out.println("Arithmetic.sum = " + Arithmetic.sum(5, 2));
//        System.out.println("Arithmetic.difference = " + Arithmetic.difference(5, 2));
//        System.out.println("Arithmetic.multiplication = " + Arithmetic.multiplication(5, 2));
//        System.out.println("Arithmetic.averageValue = " + Arithmetic.averageValue(5, 2));
//        System.out.println("Arithmetic.max = " + Arithmetic.max(5, 2));
//        System.out.println("Arithmetic.min = " + Arithmetic.min(5, 2));
//
//        Printer printer1 = new Printer();
//        printer1.append("Первая проверка", "Док1", 123);
//        printer1.append("Вторая проверка",213);
//        printer1.append("Третья проверка", "Док2");
//        printer1.append("Четвертая проверка");
//        System.out.println("\n" + "Количество страниц в очереди: " + printer1.getPagesCount());
//        System.out.println("\n" + "Количество документов в очереди: " + printer1.getDocumentsCount());
//        printer1.print("Очередь печати:");
//        printer1.print("Очередь печати после очистки:");
//        System.out.println("\n" + "Общее количество распечатанных документов: " + printer1.getTotalDocsHistory());
    }
}
