import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Account> accounts = new AccountCreator().getAccSet(69000000);

        int accountsSize = accounts.size();

        LocalDateTime start1Time = LocalDateTime.now();
        List<Account> nonEmptyAccounts = accounts.stream()
                .filter(Account::islocked)
                .collect(Collectors.toList());

        int nonEmptyAccountsSize = nonEmptyAccounts.size();
        nonEmptyAccounts = null;

        List<Account> accountsWithTooMuchMoney = accounts.stream()
                .filter(p -> !p.islocked())
                .filter(p -> p.getBalance() >= 100000000)
                .collect(Collectors.toList());

        int accountsWithTooMuchMoneySize = accountsWithTooMuchMoney.size();
        accountsWithTooMuchMoney = null;

        System.out.println("First sorting complete with result:");
        System.out.println((double) nonEmptyAccountsSize/accountsSize + " vs " + (double) accountsWithTooMuchMoneySize/accountsSize);
        LocalDateTime finish1Time = LocalDateTime.now();
        Duration d1 = Duration.between(start1Time, finish1Time);

        LocalDateTime start2Time = LocalDateTime.now();
        List<Account> nonEmptyAccounts2 = accounts.stream()
                .filter(Account::islocked)
                .collect(Collectors.toList());

        int nonEmptyAccountsSize2 = nonEmptyAccounts2.size();
        nonEmptyAccounts2 = null;

        List<Account> accountsWithTooMuchMoney2 = accounts.stream()
                .filter(p -> !p.islocked())
                .filter(p -> p.getBalance() >= 100000000)
                .collect(Collectors.toList());

        int accountsWithTooMuchMoneySize2 = accountsWithTooMuchMoney2.size();
        accountsWithTooMuchMoney2 = null;
        accounts = null;

        System.out.println("Second sorting complete with result:");
        System.out.println((double) nonEmptyAccountsSize2/accountsSize + " vs " + (double) accountsWithTooMuchMoneySize2/accountsSize);
        LocalDateTime finish2Time = LocalDateTime.now();
        Duration d2 = Duration.between(start2Time, finish2Time);

        System.out.println("as First: " + d1.getNano()/1000000 + " ms\nvs \nas Second: " + d2.getNano()/1000000 + " ms");
    }
}
