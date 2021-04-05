public class TwoDimensionalArray {
    public static char symbol = 'X';

    public static char[][] getTwoDimensionalArray(int size) {

        //TODO: Написать метод, который создаст двумерный массив char заданного размера.
        // массив должен содержать символ symbol по диагоналям, пример для size = 3
        // [X,  , X]
        // [ , X,  ]
        // [X,  , X]
        if (size != 0) {
            char[][] array = new char[size][size];
            int x = 0;
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++){
                    array[i][j] = 32;
                }
                array[i][x] = symbol;
                array[i][(array[i].length - 1) - i] = symbol;
                x++;
            }
            return array;
        }
        else return new char[0][0];
    }
}
