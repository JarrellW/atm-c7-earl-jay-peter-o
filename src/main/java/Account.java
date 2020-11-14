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

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    //Every account object starts at id=0
    //Setter increments and returns id.
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
        //Else return false(insufficient funds)
        return false;
    }

    public void deposit(double amount) {
        // balance += amount;
    }

    public void transfer(double amount, Object account) {
        //call setBalance of account parameter passed and += amount.
    }

    //Accounts should be opened and closed by user class.

    /**
     * Override toString().
     */

    @Override
    public String toString() {
        return null;
    }

















}
