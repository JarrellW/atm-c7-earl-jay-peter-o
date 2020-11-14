import java.util.LinkedHashMap;
import java.util.Map;

public abstract class Account {

    private Double balance;
    private int transactionID;
    private Map<Integer, Object> transactionHistory;

    /**
     * Constructor: Question, are these even necessary?
     */
    public Account(Double balance, int transactionID, Map transactionHistory) {
        this.balance = balance;
        this.transactionID = transactionID;
        this.transactionHistory = new LinkedHashMap<Integer, Object>();
    }


    /**
     * Getters and Setters
     */


    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public int getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }

    public Map<Integer, Object> getTransactionHistory() {
        return transactionHistory;
    }

    public void setTransactionHistory(Map<Integer, Object> transactionHistory) {
        this.transactionHistory = transactionHistory;
    }

    /**
     * Methods
     */











}
