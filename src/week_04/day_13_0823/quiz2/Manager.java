package week_04.day_13_0823.quiz2;

import java.util.ArrayList;
import java.util.Arrays;

public class Manager {
    ArrayList<Account> accounts = new ArrayList<>();

    public Manager() {
        accounts.add(new Account("test", "test"));
        accounts.add(new Account("test1", "test1"));
        accounts.add(new Account("test2", "test2"));
    }

    public Account getAccount(int index){
        Account account = accounts.get(index);
        return account;
    }

    public boolean loginSuccess(Account account){
        boolean success = false;

        for(Account acc : this.accounts){
            if(acc.equals(account)){
                success = true;
                break;
            }
        }
        return success;
    }
}
