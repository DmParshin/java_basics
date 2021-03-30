package ru.skillbox;

public class Elevator {
    int currentFloor = 1;
    int minFloor;
    int maxFloor;

    public Elevator(int minFloor, int maxFloor){
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
    }

    public int getCurrentFloor(){
        return (currentFloor);
    }

    public void moveDown(){
        currentFloor = currentFloor > minFloor ? currentFloor - 1 : currentFloor;
    }

    public void moveUp(){
        currentFloor = currentFloor < maxFloor ? currentFloor + 1 : currentFloor;
    }

    public void move(int floor){
        if ((floor >= minFloor && floor <= maxFloor) && (floor != currentFloor)){
            if (floor > currentFloor){
                for (int i = currentFloor; i < floor; i++) {
                    moveUp();
                    System.out.println("Текущий этаж: " + currentFloor);
                }
            }
            if (floor >= minFloor && floor < currentFloor){
                for (int i = currentFloor; i > floor; i--){
                    moveDown();
                    System.out.println("Текущий этаж: " + currentFloor);
                }
            }
        }
        else if (floor == currentFloor){
            return;
        }
        else {
            System.out.println("Error, введите корректный номер этажа. Текущий этаж: " + currentFloor);
        }
    }

}
