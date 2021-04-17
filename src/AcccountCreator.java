import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

interface TestInterface1 {
    Long getrandomLong();
}

interface TestInterface2{
    boolean getBool(long a);
}

public class AcccountCreator {
    private static long accId;
    static {
        accId = 0L;
    }

    public Set<Account> getAccSet(long num){
        Set<Account> list = new HashSet<>();

        TestInterface1 l = ()-> {
            double rand = Math.random();
            if(rand > 0.4) return Math.round(Math.random() * 10000);
            else if (rand > 0.3) return Math.round(Math.random() * 1000000000);
            else return 0L;
        };

        TestInterface2 bool = (a)-> a == 0;

        for(int i = 0; i < num; i++){
            list.add(new Account(++accId + ""));
        }

        list.forEach(p -> p.setBalance(l.getrandomLong()));

        list.forEach(p -> p.setIslocked(bool.getBool(p.getBalance())));

        return list;
    }
}
