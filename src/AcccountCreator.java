import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

interface TestInterface1 {
    Long getrandomLong();
}

interface TestInterface2{
    boolean getBool();
}

public class AcccountCreator {
    private static Long accId;
    static {
        accId = 0L;
    }

    public Set<Account> getAccSet(int num){
        Set<Account> list = new HashSet<>();

        for(int i = 0; i < num; i++){
            TestInterface1 l = ()-> {
                double rand = Math.random();
                if(rand > 0.4) return Math.round(Math.random() * 10000);
                else if (rand > 0.3) return Math.round(Math.random() * 1000000000);
                else return 0L;
            };

            TestInterface2 bool = ()-> l.getrandomLong() > 0;

            list.add(new Account(++accId + "", l.getrandomLong(), bool.getBool()));
        }
        return list;
    }
}
