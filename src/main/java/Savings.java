import java.util.ArrayList;

public class Savings extends Account {
    /**
     * Constructor
     *  @param balance
     * @param transactionHistory
     * @param accountHolder
     */
    public Savings(Double balance, ArrayList<Transaction> transactionHistory, Object accountHolder) {
        super(balance, transactionHistory, accountHolder);
    }

    /**
     * Override toString().
     * Will write once transaction object is figured out
     */
    @Override
    public String toString() {
        return null;
    }
}
