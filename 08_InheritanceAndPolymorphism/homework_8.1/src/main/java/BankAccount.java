//        BankAccount — пополнение и списание происходит без комиссии. Если передать в метод пополнения
//        отрицательное значение, сумма на счёте не должна измениться. При попытке снять большую
//        сумму, чем есть на счёте, сумма не списывается со счёта, сумма на счёте не изменяется.

public class BankAccount {

  protected double money;

  protected double getAmount() {
    return this.money;
  }

  protected void put(double amountToPut) {
    if (amountToPut > 0){
      money = money + amountToPut;
    }
  }

  protected void take(double amountToTake) {
    if (amountToTake <= money){
      money = money - amountToTake;
    }
  }
}
