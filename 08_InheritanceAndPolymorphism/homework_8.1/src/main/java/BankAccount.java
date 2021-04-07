//        BankAccount — пополнение и списание происходит без комиссии. Если передать в метод пополнения
//        отрицательное значение, сумма на счёте не должна измениться. При попытке снять большую
//        сумму, чем есть на счёте, сумма не списывается со счёта, сумма на счёте не изменяется.

public class BankAccount {

  double money = 0;

  public double getAmount() {
    return this.money;
  }

  public void put(double amountToPut) {
    if (amountToPut > 0){
      this.money =+ amountToPut;
    }
  }

  public void take(double amountToTake) {
    if (amountToTake <= this.money){
      this.money -= amountToTake;
    }
  }
}
