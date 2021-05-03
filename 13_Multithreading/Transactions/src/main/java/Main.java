import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        Bank bank = new Bank();
        Map<String, Account> accounts = new HashMap<>();

        for (int i = 0; i < 50; i++){
            Account account = new Account();
            account.setMoney(100000);
            accounts.put(account.getAccNumber(), account);
            System.out.println("Number:" + account.getAccNumber() + " Money:" + account.getMoney() + " lock:" + account.isLock());
        }
        bank.setAccounts(accounts);
        System.out.println("Total money: " + bank.getSumAllAccounts());

        ArrayList<Thread> threads = new ArrayList<>();
        for(int i = 0; i < 50; i++){
            threads.add(new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        bank.transfer(accounts.keySet().stream().skip(random.nextInt(49 ) + 1).findFirst().get(),
                                accounts.keySet().stream().skip(random.nextInt(49) + 1).findFirst().get(), random.nextInt(80000) + 1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }));
        }
        for(Thread thread:threads){
            thread.start();
        }
        for(Thread thread:threads) {
            thread.join();
        }
        for(Account account:accounts.values()){
            System.out.println("Number:" + account.getAccNumber() + " Money:" + account.getMoney() + " lock:" + account.isLock());
        }
        System.out.println("Total money: " + bank.getSumAllAccounts());
    }
}
