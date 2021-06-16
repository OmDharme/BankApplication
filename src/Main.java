import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank("XYZ");

        int choice=-1;
        System.out.println("Welcome to XYZ Bank");
        Account currentAccount = null;
        showMenu();
        choice = sc.nextInt();

        while(choice!=0){

            if(choice==1){

                if(currentAccount==null){
                    System.out.println("Add an account first");
                }else{
                    System.out.println("How much do you wish to deposit?");
                    currentAccount.deposit(sc.nextInt());
                }
            }else if(choice==2){

                if(currentAccount==null){
                    System.out.println("Add an account first");
                }else{
                    System.out.println("How much do you wish to withdraw");
                    currentAccount.withdraw(sc.nextInt());
                }
            }else if(choice==3){

                if(currentAccount==null){
                    System.out.println("Add an account first");
                }else{
                    System.out.println("Current balance is " + currentAccount.getBalance());
                }
            }else if(choice==4){

                while(true){
                    System.out.println("Enter name for your new account");
                    String nameAccount = sc.next();
                    if(bank.getAccount(nameAccount)!=null){
                        System.out.println("An account by that name already exists, enter a new name.");
                        continue;
                    }
                    System.out.println("Enter accountID for your new account");
                    String idAccount = sc.next();
                    Account newAccount = new Account(nameAccount, idAccount);
                    bank.addAccount(newAccount);
                    System.out.println("New account by name " + nameAccount + " is created");
                    currentAccount = newAccount;
                    break;
                }
            }else if(choice==5){

                if(currentAccount==null){
                    System.out.println("There are no accounts in this bank");
                }else{
                    System.out.println("Enter name of the account you wish to remove");
                    String nameAccount = sc.next();
                    if(bank.getAccount(nameAccount) == null){
                        System.out.println("No such account exists");
                    }else if(bank.getAccount(nameAccount).getName() != currentAccount.getName()){
                        bank.getAccounts().remove(bank.getAccount(nameAccount));
                        System.out.println("Account by the name " + nameAccount + " has been removed");
                    }else{
                        bank.getAccounts().remove(bank.getAccount(nameAccount));
                        System.out.println("Account by the name " + nameAccount + " has been removed");
                        choice=6;
                        currentAccount=null;
                        continue;
                    }
                }
            }else if(choice==6){

                while(true){
                    if(bank.noAccount()) break;
                    System.out.println("Enter name of the account you wish to access");
                    String nameAccount = sc.next();
                    if(bank.getAccount(nameAccount)==null){
                        System.out.println("No such account exists");
                        continue;
                    }else{
                        currentAccount = bank.getAccount(nameAccount);
                        break;
                    }
                }

            }else if(choice==7){
                if(bank.noAccount()){
                    System.out.println("No accounts");
                }else{
                    for(Account account : bank.getAccounts()){
                        System.out.println("Account name: " + account.getName() + ", Balance = " + account.getBalance());
                    }
                    System.out.println();
                    System.out.println("Current account you are accessing is: " + currentAccount.getName() + ", Balance = " + currentAccount.getBalance());
                }
            }

            showMenu();
            choice = sc.nextInt();
        }
        System.out.println("---------Thank You------------");

    }

    public static void showMenu(){
        System.out.println();
        System.out.println("========================================");
        System.out.println();
        System.out.println("Enter an option");
        System.out.println("0 - Quit");
        System.out.println("1 - Deposit money");
        System.out.println("2 - Withdraw money");
        System.out.println("3 - Check balance");
        System.out.println("4 - Add account");
        System.out.println("5- Delete account");
        System.out.println("6 - Access other accounts");
        System.out.println("7 - Give information on my accounts");
        System.out.println();
        System.out.println("========================================");
        System.out.println();
    }


}
