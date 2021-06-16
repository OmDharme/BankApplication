import java.util.ArrayList;

public class Bank {

    private String name;
    private ArrayList<Account> accounts;

    public Bank(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public void addAccount(Account account){
        accounts.add(account);
    }

    public Account getAccount(String name){
        for(Account account : accounts){
            if(account.getName().equals(name)){
                return account;
            }
        }
        return null;
    }

    public boolean noAccount(){
        if(accounts.isEmpty()) return true;
        return false;
    }
}
