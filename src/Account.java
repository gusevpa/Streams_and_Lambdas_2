import java.util.Objects;

public class Account {
    private static int number = 0;
    private final int accId;
    private int balance;
    private boolean islocked = false;

    public Account(int balance, boolean islocked) {
        accId = ++number;
        this.balance = balance;
        this.islocked = islocked;
    }

    public Account() {
        accId = ++number;
    }

    public int getAccId() {
        return accId;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        if(balance <= 0) {
            this.balance = 0;
            this.islocked = true;
        }else this.balance = balance;
    }

    public void changeBalance(int change) {
        balance = balance + change;
        if(balance <= 0) {
            this.islocked = true;
        }
    }

    public boolean islocked() {
        return islocked;
    }

    public void setIslocked(boolean islocked) {
        this.islocked = islocked;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accId='" + accId + '\'' +
                ", balance=" + balance +
                ", islocked=" + islocked +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        Account account = (Account) o;
        return getAccId() == account.getAccId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAccId());
    }
}
