import java.util.Map;

public class Checking extends Account {
    /**
     * Constructor
     *
     * @param balance
     * @param transactionID
     * @param transactionHistory
     */
    public Checking(Double balance, int transactionID, Map transactionHistory) {
        super(balance, transactionID, transactionHistory);
    }
}
