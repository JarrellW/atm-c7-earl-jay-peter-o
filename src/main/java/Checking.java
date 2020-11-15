import java.util.ArrayList;
import java.util.Map;

public class Checking extends Account {
    /**
     * Constructor
     *
     * @param balance
     * @param accountHolder
     * @param transactionHistory
     */
    public Checking(double balance, ArrayList<Transaction> transactionHistory, User accountHolder, String accountNumber) {
        super(balance, transactionHistory, accountHolder, accountNumber);
    }

    public String toString(User accountHolder) {
        {
            double balance = this.getBalance();
            return String.format("%s %s\n %s\n%s\n%.2f", accountHolder.getFirstName(), accountHolder.getLastName(), "Savings", this.getAccountNumber(), this.getBalance());

        }
    }
}
