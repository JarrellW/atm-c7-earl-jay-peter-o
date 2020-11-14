import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public abstract class Account {

    private Double balance;
    private int transactionID = 0;
    private Object accountHolder;
    private ArrayList<Object> transactionHistory;

    /**
     * Constructor
     */
    public Account(Double balance, Map transactionHistory, Object accountHolder) {
        this.balance = balance;
        this.transactionHistory = new ArrayList<Object>();
        this.accountHolder = accountHolder;
    }

    /*
    public Account() {
        this.transactionID = 0;
    }

     */


    /**
     * Getters and Setters
     */
    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double amount) {
        this.balance = balance;
    }

    //Every account object starts at id=0
    //Getter increments and returns id.
    //Make sure this actually works in practice.
    public int getTransactionID() {
        this.transactionID++;
        return transactionID;
    }

    public ArrayList<Object> getTransactionHistory() {
        return transactionHistory;
    }

    /**
     * Methods
     */
    public boolean withdraw(double amount) {
        //If amount <= balance.
        //Subtract amount from balance, call setBalance to update balance, return true.

        if (balance != null && amount <= balance) {
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
