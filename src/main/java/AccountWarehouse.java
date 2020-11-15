import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class AccountWarehouse {

    private ArrayList<User> users;
    private ArrayList<Account> accounts;

    public AccountWarehouse() {
        this.users = new ArrayList<User>();
        this.accounts = new ArrayList<Account>();
    }

    public String getNewAccountNumber() {
        //inits
        String accountNumber;
        Random rand = new Random();
        int length = 9;
        boolean nonUnique;

        //continue looping until a unique account number is generated
        do {
            //generate account number
            accountNumber = "";
            for(int i = 0; i < length; i++) {
                accountNumber += ((Integer)rand.nextInt(10));
            }

            //make sure uuid is actually unique
            nonUnique = false;
            for(Account a : this.accounts) {
                if(accountNumber.compareTo(a.getAccountNumber()) == 0) {
                    nonUnique = true;
                    break;
                }
            }

        } while (nonUnique);

        return accountNumber;
    }

    public Savings createSavingsAccount(User accountHolder) {
        ArrayList<Transaction> transactionHistory = new ArrayList<Transaction>();
        Savings newAccount = new Savings(0D, transactionHistory, accountHolder, getNewAccountNumber());
        accounts.add(newAccount);
        accountHolder.addAccount(newAccount);
        return newAccount;
    }

    public Checking createCheckingAccount(User accountHolder) {
        ArrayList<Transaction> transactionHistory = new ArrayList<Transaction>();
        Checking newAccount = new Checking(0D, transactionHistory, accountHolder, getNewAccountNumber());
        accounts.add(newAccount);
        accountHolder.addAccount(newAccount);
        return newAccount;
    }

    public Investment createInvestmentAccount(User accountHolder) {
        ArrayList<Transaction> transactionHistory = new ArrayList<Transaction>();
        Investment newAccount = new Investment(0D, transactionHistory, accountHolder, getNewAccountNumber());
        accounts.add(newAccount);
        accountHolder.addAccount(newAccount);
        return newAccount;
    }

}
