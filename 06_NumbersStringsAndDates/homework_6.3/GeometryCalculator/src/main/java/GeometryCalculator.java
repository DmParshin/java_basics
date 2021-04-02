public class GeometryCalculator {
    // метод должен использовать абсолютное значение radius
    public static double getCircleSquare(double radius) {
        if (radius != 0){
            double square = Math.PI * Math.pow( Math.abs(radius), 2);
            return square;
        }
        return 0;
    }

    // метод должен использовать абсолютное значение radius
    public static double getSphereVolume(double radius) {
        double volume = (4*Math.PI*Math.pow(Math.abs(radius), 3))/3;
        return volume;
    }

    public static boolean isTrianglePossible(double a, double b, double c) {
        if ((a < b + c) && (b < a + c) && (c < a + b)) {
            return true;
        }
        return false;
    }

    // перед расчетом площади рекомендуется проверить возможен ли такой треугольник
    // методом isTrianglePossible, если невозможен вернуть -1.0
    public static double getTriangleSquare(double a, double b, double c) {
        if (isTrianglePossible(a, b, c)){
            double p = (a + b + c) / 2;
            double square = (Math.sqrt(p * (p - a) * (p - b) * (p - c)));
            return square;
        }
        return -1.0;
    }
}
