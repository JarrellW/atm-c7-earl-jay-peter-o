import java.util.Map;

public class Checking extends Account {
    /**
     * Constructor
     *
     * @param balance
     * @param accountHolder
     * @param transactionHistory
     */
    public Checking(Double balance, Map transactionHistory, Object accountHolder) {
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
