package ru.skillbox;

public class ArithmeticCalculator {
    public int x;
    public int y;

    public ArithmeticCalculator(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void calc(Operation operation){
        switch (operation) {
            case ADD:
                System.out.println(x + " " + y);
                System.out.println(operation);
                System.out.println(x + y);
                break;
            case SUBTRACT:
                System.out.println(x + " " + y);
                System.out.println(operation);
                System.out.println(x - y);
                break;
            case MULTIPLY:
                System.out.println(x + " " + y);
                System.out.println(operation);
                System.out.println(x * y);
                break;
        }
    }
//        if (operation == Operation.ADD){
//            System.out.println(x + " " + y);
//            System.out.println(operation);
//            System.out.println(x + y);
//        }
//        else if (operation == Operation.SUBTRACT){
//            System.out.println(x + " " + y);
//            System.out.println(operation);
//            System.out.println(x - y);
//        }
//        if (operation == Operation.MULTIPLY){
//            System.out.println(x + " " + y);
//            System.out.println(operation);
//            System.out.println(x * y);
//        }
//    }


}
