//Создайте класс Arithmetic в проекте 03_ObjectsAndMethods, содержащий конструктор, принимающий два числа типа int и сохраняющий
// их в параметрах.
//        В созданном классе реализуйте методы, вычисляющие различные величины из переданных в конструктор класса чисел, а именно:
//        сумму чисел,
//        разность чисел,
//        произведения чисел,
//        среднее значение этих чисел,
//        максимальное из двух чисел,
//        минимальное из двух чисел.
//        Имена методов придумайте самостоятельно.


public class Arithmetic {
    public static int x;
    public static int y;

    public Arithmetic(int a, int b){
        x = a;
        y = b;
    }

    public static int Sum(int x, int y) { return (x + y); } //  сумма

    public static int Raz(int x, int y) { return (x - y); } //  разность

    public static int Umn(int x, int y) { return (x * y); } //  произведение

    public static double SrZnach(double x, double y) { return ((x + y) / 2); }   //  среднее значение

    public static int Max(int x, int y) {   //  максимальное значение
        if (x > y)
            return x;
        return (y);
    }

    public static int Min(int x, int y) {   //  минимальное значение
        if (x < y)
            return x;
        return (y);
    }
}
