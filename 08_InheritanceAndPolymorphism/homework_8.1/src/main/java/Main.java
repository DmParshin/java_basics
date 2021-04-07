public class Main {
    public static void main(String[] args) {

        BankAccount bankAccount = new BankAccount();
        bankAccount.put(1000);
        System.out.println("bankAccount = " + bankAccount.getAmount());
        bankAccount.take(350);
        System.out.println("bankAccount = " + bankAccount.getAmount());

        CardAccount cardAccount = new CardAccount();
        cardAccount.put(550);
        System.out.println("cardAccount = " + cardAccount.getAmount());
        cardAccount.take(100);
        System.out.println("cardAccount = " + cardAccount.getAmount());

        DepositAccount depositAccount = new DepositAccount();
        depositAccount.put(111);
        System.out.println("depositAccount = " + depositAccount.getAmount());
        depositAccount.take(112);

        BankAccount bankAccount1 = new BankAccount();
        bankAccount.send(bankAccount1, 649);
        System.out.println("bankAccount = " + bankAccount.getAmount());
        System.out.println("bankAccount1 = " + bankAccount1.getAmount());

    }
}
