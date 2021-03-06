import java.util.ArrayList;
import java.util.List;

interface TestInterface1 {
    int getrandomLong();
}

public class AccountCreator {

    public List<Account> getAccSet(int num){
        List<Account> list = new ArrayList<>();

        TestInterface1 l = ()-> {
            double rand = Math.random();
            if(rand > 0.4) return Math.toIntExact(Math.round(Math.random() * 10000));
            else if (rand > 0.3) return Math.toIntExact(Math.round(Math.random() * 1000000000));
            else return 0;
        };

        for(int i = 0; i < num; i++){
            list.add(new Account());
        }

        list.forEach(p -> p.setBalance(l.getrandomLong()));

        System.out.println("Successfully generated ArrayList containing " + list.size() + " uniq objects");
        return list;
    }
}
