import java.util.Objects;

public class Account {
    private static Long number = 0L;
    private final Long accId;
    private Long balance;
    private boolean islocked;

    public Account(Long balance, boolean islocked) {
        accId = ++number;
        this.balance = balance;
        this.islocked = islocked;
    }

    public Account() {
        accId = ++number;
    }

    public Long getAccId() {
        return accId;
    }

//    public void setNumber(String number) {
//        this.number = number;
//    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
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
                "number='" + number + '\'' +
                ", balance=" + balance +
                ", islocked=" + islocked +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        Account account = (Account) o;
        return getAccId().equals(account.getAccId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAccId());
    }
}
