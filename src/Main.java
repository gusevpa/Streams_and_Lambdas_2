import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Set<Account> accountsAsSet = new AcccountCreator().getAccSet(1000000);

        LocalDateTime start1Time = LocalDateTime.now();
        Set<Account> nonEmptyAccounts = accountsAsSet.stream()
                .filter(p -> p.getBalance() > 0)
                .collect(Collectors.toSet());

        Set<Account> accountsWithTooMuchMoney = accountsAsSet.stream()
                .filter(p -> !p.islocked())
                .filter(p -> p.getBalance() >= 100000000)
                .collect(Collectors.toSet());

        System.out.println((double) nonEmptyAccounts.size()/accountsAsSet.size() + " vs " + (double) accountsWithTooMuchMoney.size()/accountsAsSet.size());

        LocalDateTime finish1Time = LocalDateTime.now();
        Duration d1 = Duration.between(start1Time, finish1Time);

        List<Account> accountsAsList = new ArrayList<>(accountsAsSet);

        LocalDateTime start2Time = LocalDateTime.now();
        List<Account> nonEmptyAccounts2 = accountsAsList.stream()
                .filter(p -> p.getBalance() > 0)
                .collect(Collectors.toList());

        List<Account> accountsWithTooMuchMoney2 = accountsAsList.stream()
                .filter(p -> !p.islocked())
                .filter(p -> p.getBalance() >= 100000000)
                .collect(Collectors.toList());

        System.out.println((double) nonEmptyAccounts2.size()/accountsAsSet.size() + " vs " + (double) accountsWithTooMuchMoney2.size()/accountsAsSet.size());
        LocalDateTime finish2Time = LocalDateTime.now();
        Duration d2 = Duration.between(start2Time, finish2Time);

        System.out.println("as Set: " + d1.getNano()/1000000 + " ms\nvs \nas List: " + d2.getNano()/1000000 + " ms \n but WHY?");
    }
}
