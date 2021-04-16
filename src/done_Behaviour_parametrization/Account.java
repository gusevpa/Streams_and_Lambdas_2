package done_Behaviour_parametrization;

import java.util.Objects;

public class Account {
    private String number;
    private Long balance;
    private boolean islocked;

    public Account(String number, Long balance, boolean islocked) {
        this.number = number;
        this.balance = balance;
        this.islocked = islocked;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        Account account = (Account) o;
        return islocked() == account.islocked() && getNumber().equals(account.getNumber()) && Objects.equals(getBalance(), account.getBalance());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumber(), getBalance(), islocked());
    }
}
