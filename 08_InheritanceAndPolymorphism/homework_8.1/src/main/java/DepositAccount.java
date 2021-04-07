//        DepositAccount — депозитный расчётный счёт, в дополнение к условиям BankAccount — нельзя снимать деньги в
//        течение одного месяца после последнего пополнения.
//        Переменную, в которой хранится дата последнего внесения, назовите lastIncome. Тип переменной используйте
//        Calendar или LocalDate.


import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DepositAccount extends BankAccount {


    LocalDate lastIncome = LocalDate.of(2021,02,01);
    LocalDate today = LocalDate.now();

    public void put(double amountToPut) {
        if (amountToPut > 0){
            this.money += amountToPut;
        }
        this.lastIncome = LocalDate.now();
    }

    public void take(double amountToTake){
        long DAYS;
        if (ChronoUnit.DAYS.between(lastIncome,today) >= 30 && amountToTake <= money){
            this.money -= amountToTake;
        }
        System.out.println("it is not possible to receive money");
    }
}
