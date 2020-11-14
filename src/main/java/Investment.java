import java.util.Map;

public class Investment extends Account {
    /**
     * Constructor
     *
     * @param balance
     * @param transactionID
     * @param transactionHistory
     */
    public Investment(Double balance, int transactionID, Map transactionHistory) {
        super(balance, transactionID, transactionHistory);
    }
}
