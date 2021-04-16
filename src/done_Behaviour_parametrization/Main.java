package done_Behaviour_parametrization;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Account> accounts = new AcccountCreator().getAccList(50000);

        List<Account> nonEmptyAccounts = accounts.stream()
                .filter(p -> p.getBalance() > 0)
                .collect(Collectors.toList());

        List<Account> accountsWithTooMuchMoney = accounts.stream()
                .filter(p -> !p.islocked())
                .filter(p -> p.getBalance() >= 100000000)
                .collect(Collectors.toList());

        System.out.println((double) nonEmptyAccounts.size()/accounts.size() + " vs " + (double) accountsWithTooMuchMoney.size()/accounts.size());
    }
}
