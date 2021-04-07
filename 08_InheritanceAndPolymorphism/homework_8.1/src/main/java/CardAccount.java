//        CardAccount — карточный счёт, в дополнение к условиям BankAccount — при снятии денег должна взиматься
//        комиссия 1% от суммы списания. Пример: при попытке снять со счёта 100 рублей должен списаться 101 рубль.

public class CardAccount extends BankAccount {

    protected void take(double amountToTake){
        if (amountToTake + (amountToTake / 100) <= getAmount()){
            money = money - (amountToTake + (amountToTake / 100));
        }
    }

}
