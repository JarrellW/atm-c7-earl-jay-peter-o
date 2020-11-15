import java.util.ArrayList;

public abstract class Account implements Summary {

    private double balance;
    private String accountNumber;
    private User accountHolder;
    private ArrayList<Transaction> transactionHistory;
    //private String accountType;


    /**
     * Constructor
     */
    public Account(double balance, ArrayList<Transaction> transactionHistory, User accountHolder, String accountNumber) {
        this.balance = balance;
        this.transactionHistory = transactionHistory;
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        //this.accountType = accountType;
    }



    /**
     * Getters and Setters
     */
    public double getBalance() {
        return balance;
    }

    public void setBalance(double amount) {
        this.balance = amount;
    }

    public ArrayList<Transaction> getTransactionHistory() {
        return transactionHistory;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * Methods
     */
    public boolean withdraw(double amount ) {

        if (amount <= balance) {
            this.setBalance(this.getBalance() - amount);
            return true;
        }

        //return false(insufficient funds)
        return false;
    }

    public void deposit(double amount) {
        this.setBalance(this.getBalance() + amount);
    }

    public void transfer(double amount, Account targetAccount) {

        targetAccount.setBalance(amount);

    }

    /**
     * method for accounts to spit out information for the user in console
     * @return returns a string with account number, balance, and account name(or maybe type?)
     */
    public String getSummaryLine() {
        //get balance of this account
        double balance = this.getBalance();
        //account number, balance, account name
        return String.format("%s : $%.02f : %s", this.accountNumber, balance, String.valueOf(this.accountHolder)
        + "'s account");
    }


}









