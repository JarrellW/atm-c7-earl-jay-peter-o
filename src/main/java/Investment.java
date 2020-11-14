import java.util.Map;

public class Investment extends Account {
    /**
     * Constructor
     *
     * @param balance
     * @param accountHolder
     * @param transactionHistory
     */
    public Investment(Double balance, Map transactionHistory, Object accountHolder) {
        super(balance, transactionHistory, transactionHistory);
    }
}
