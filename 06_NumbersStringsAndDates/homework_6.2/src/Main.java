//        byte (целые числа, 1 байт)
//        short (целые числа, 2 байта)
//        int (целые числа, 4 байта)
//        long (целые числа, 8 байтов)
//        float (вещественные числа, 4 байта)
//        double (вещественные числа, 8 байтов)

public class Main {
    public static void main(String[] args) {
        System.out.println("Byte:");
        System.out.println(Byte.MIN_VALUE);
        System.out.println(" " + Byte.MAX_VALUE);
        System.out.println("-----------------");

        System.out.println("Short:");
        System.out.println(Short.MIN_VALUE);
        System.out.println(" " + Short.MAX_VALUE);
        System.out.println("-----------------");

        System.out.println("Integer:");
        System.out.println(Integer.MIN_VALUE);
        System.out.println(" " + Integer.MAX_VALUE);
        System.out.println("-----------------");

        System.out.println("Long:");
        System.out.println(Long.MIN_VALUE);
        System.out.println(" " + Long.MAX_VALUE);
        System.out.println("-----------------");

        System.out.println("Float:");
        System.out.println(-Float.MAX_VALUE);
        System.out.println(" " + Float.MAX_VALUE);
        System.out.println("-----------------");

        System.out.println("Double:");
        System.out.println(-Double.MAX_VALUE);
        System.out.println(" " + Double.MAX_VALUE);
        System.out.println("-----------------");
    }
}
