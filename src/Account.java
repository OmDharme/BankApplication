public class Account {

    private String name;
    private String accountID;
    private int balance;

    public Account(String name, String accountID) {
        this.name = name;
        this.accountID = accountID;
        this.balance = 0;
    }

    public int getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }

    public void deposit(int money){
        balance += money;
        System.out.println(money + " rupees has been deposited.");
    }
    
    public void withdraw(int money){
        if(money>balance){
            System.out.println("Insufficient funds.");
        }else{
            balance -= money;
            System.out.println(money + " rupees has been withdrawn");
        }
    }

    
}
