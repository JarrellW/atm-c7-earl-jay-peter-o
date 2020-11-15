import java.util.ArrayList;

public abstract class Account {

    private double balance;
    private int transactionID = 0;
    private String accountNumber;
    private Object accountHolder;
    private ArrayList<Transaction> transactionHistory;


    /**
     * Constructor
     */
    public Account(double balance, ArrayList<Transaction> transactionHistory, Object accountHolder) {
        this.balance = balance;
        this.transactionHistory = transactionHistory;
        this.accountHolder = accountHolder;
    }



    /**
     * Getters and Setters
     */
    public double getBalance() {
        return balance;
    }

    public void setBalance(double amount) {
        this.balance = balance;
    }

    //Every account object starts at id=0
    //Getter increments and returns id.
    //Make sure this actually works in practice.
    public int getTransactionID() {
        this.transactionID++;
        return transactionID;
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
    public boolean withdraw(double amount) {
        //If amount <= balance.
        //Subtract amount from balance, call setBalance to update balance, return true.

        if (amount <= balance) {
            balance = balance - amount;
            return true;
        }
        //Else return false(insufficient funds)

        return false;
    }

    public void deposit(double amount) {
        balance += amount;

    }

    public void transfer(double amount, Object targetAccount) {
        //call setBalance of targetAccount passed and += amount.

        //targetAccount.setBalance(getBalance() + amount);
    }

    //Accounts should be opened and closed by user class.

    /**
     * Override toString().
     * Will write once transaction object is figured out
     */

    @Override
    public abstract String toString();

















}
