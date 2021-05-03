import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Bank {

    private Map<String, Account> accounts;
    private final Random random = new Random();

    public synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount)
        throws InterruptedException {
        Thread.sleep(1000);
        return random.nextBoolean();
    }

    public synchronized void transfer(String fromAccountNum, String toAccountNum, long amount) throws InterruptedException {

        if(amount < 50000 && accounts.get(fromAccountNum).getMoney() >= amount && !accounts.get(fromAccountNum).isLock() && !accounts.get(toAccountNum).isLock()){
            accounts.get(fromAccountNum).setMoney(accounts.get(fromAccountNum).getMoney() - amount);
            accounts.get(toAccountNum).setMoney(accounts.get(toAccountNum).getMoney() + amount);
        }else if (amount >= 50000 && accounts.get(fromAccountNum).getMoney() >= amount && isFraud(fromAccountNum, toAccountNum, amount)){
            accounts.get(fromAccountNum).setLock();
            accounts.get(toAccountNum).setLock();
        }else if (amount >= 50000 && accounts.get(fromAccountNum).getMoney() >= amount && !isFraud(fromAccountNum, toAccountNum, amount)){
            accounts.get(fromAccountNum).setMoney(accounts.get(fromAccountNum).getMoney() - amount);
            accounts.get(toAccountNum).setMoney(accounts.get(toAccountNum).getMoney() + amount);
        }
    }

    public long getBalance(String accountNum) {
        return accounts.get(accountNum).getMoney();
    }

    public long getSumAllAccounts() {
        return accounts.entrySet().stream().map(e -> e.getValue().getMoney()).reduce((long) 0, Long::sum) ;
    }

    public Map<String, Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Map<String, Account> accounts) {
        this.accounts = accounts;
    }

}
