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

    /**
     * method to remove an account from the accountWarehouse master list of accounts and the user's personal
     * account list
     * @param accountHolder current user closing their selected account
     * @param accountNumber unique account number to identify from list which account to close
     */
    public void removeAccount(User accountHolder, String accountNumber) {
<<<<<<< HEAD
        for(Account a : accounts) {
            if(a.getAccountNumber().equals(accountNumber)) {
                accounts.remove(a);
                accountHolder.removeAccountFromUserList(a);
=======
        /**
         * I have no idea why this for each loop threw a ConcurrentModificationException but the
         * for loop below works just fine
         */
//        for(Account a : this.accounts) {
//            if(a.getAccountNumber().equals(accountNumber)) {
//                accounts.remove(a);
//                accountHolder.removeAccountFromUserList(a);
//            }
//        }
        //iterate through accounts list until account with number matching account to remove's account number is found
        for(int i = 0; i < accounts.size(); i++) {
            if(accounts.get(i).getAccountNumber().equals(accountNumber)) {
                //call method to remove same account from user list before removing from master list
                accountHolder.removeAccountFromUserList(accounts.get(i));
                //remove from master list
                accounts.remove(accounts.get(i));
>>>>>>> ba894b977819f1d3d65f29d553605f29d5f3855b
                break;
            }
        }
    }

    public Savings createSavingsAccount(User accountHolder, double startingDeposit) {
        ArrayList<Transaction> transactionHistory = new ArrayList<Transaction>();
        Savings newAccount = new Savings(startingDeposit, accountHolder, getNewAccountNumber());
        accounts.add(newAccount);
        accountHolder.addAccount(newAccount);
        return newAccount;
    }

    public Checking createCheckingAccount(User accountHolder, double startingDeposit) {
        ArrayList<Transaction> transactionHistory = new ArrayList<Transaction>();
        Checking newAccount = new Checking(startingDeposit, accountHolder, getNewAccountNumber());
        accounts.add(newAccount);
        accountHolder.addAccount(newAccount);
        return newAccount;
    }

    public Investment createInvestmentAccount(User accountHolder, double startingDeposit) {
        ArrayList<Transaction> transactionHistory = new ArrayList<Transaction>();
        Investment newAccount = new Investment(startingDeposit, accountHolder, getNewAccountNumber());
        accounts.add(newAccount);
        accountHolder.addAccount(newAccount);
        return newAccount;
    }

}
