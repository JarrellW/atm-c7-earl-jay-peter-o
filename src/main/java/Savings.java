import java.util.Map;

public class Savings extends Account {
    /**
     * Constructor
     *
     * @param balance
     * @param transactionID
     * @param transactionHistory
     */
    public Savings(Double balance, int transactionID, Map transactionHistory) {
        super(balance, transactionID, transactionHistory);
    }
}
