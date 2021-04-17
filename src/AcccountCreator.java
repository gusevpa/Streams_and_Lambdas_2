import java.util.ArrayList;
import java.util.List;

interface TestInterface1 {
    Long getrandonLong ();
}

interface TestInterface2{
    boolean getBool();
}

public class AcccountCreator {
    private static Long accId;
    static {
        accId = 0L;
    }

    public List<Account> getAccList(int num){
        List <Account> list = new ArrayList<>();

        for(int i = 0; i < num; i++){
            TestInterface1 l = ()-> {
                double rand = Math.random();
                if(rand > 0.4) return Math.round(Math.random() * 10000);
                else if (rand > 0.3) return Math.round(Math.random() * 1000000000);
                else return 0L;
            };

            TestInterface2 bool = ()-> l.getrandonLong() > 0;

            list.add(new Account(++accId + "", l.getrandonLong(), bool.getBool()));
        }
        return list;
    }
}
