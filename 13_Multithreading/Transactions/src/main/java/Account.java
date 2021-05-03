import java.util.Random;

public class Account {

    Random random = new Random();

    private long money;
    private String accNumber;
    private boolean lock;

    public Account() {
        this.money = 0;
        this.accNumber = String.valueOf(random.nextInt(999999999) + 1000000000);
        this.lock = false;
    }

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    public String getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(String accNumber) {
        this.accNumber = accNumber;
    }

    public boolean isLock() {
        return lock;
    }

    public void setLock() {
        this.lock = true;
    }
}
