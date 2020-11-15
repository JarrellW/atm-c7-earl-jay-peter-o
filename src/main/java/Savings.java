import java.util.Map;

public class Savings extends Account {
    /**
     * Constructor
     *
     * @param balance
     * @param accountHolder
     * @param transactionHistory
     */
    public Savings(Double balance, Map transactionHistory, Object accountHolder) {
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
