//        DepositAccount — депозитный расчётный счёт, в дополнение к условиям BankAccount — нельзя снимать деньги в
//        течение одного месяца после последнего пополнения.
//        Переменную, в которой хранится дата последнего внесения, назовите lastIncome. Тип переменной используйте
//        Calendar или LocalDate.


import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DepositAccount extends BankAccount {


    private LocalDate lastIncome = LocalDate.now();
    private LocalDate today = LocalDate.now();

    protected void put(double amountToPut) {
        if (amountToPut > 0){
             money = money + (amountToPut);
        }
        lastIncome = LocalDate.now();
    }

    protected void take(double amountToTake){
        long DAYS;
        if (ChronoUnit.DAYS.between(lastIncome,today) >= 30 && amountToTake <= getAmount()){
            money = money - amountToTake;
        }else System.out.println("it is not possible to receive money");
    }
}
