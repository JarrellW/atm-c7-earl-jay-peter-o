import java.util.ArrayList;
import java.util.Map;

public class Checking extends Account implements Summary{
    /**
     * Constructor
     *
     * @param balance
     * @param accountHolder
     * @param accountNumber
     */
    public Checking(double balance, User accountHolder, String accountNumber) {
        super(balance, accountHolder, accountNumber);
    }

    public String toString(User accountHolder) {
        {
            double balance = this.getBalance();
            return String.format("%s %s\n %s\n%s\n%.2f", accountHolder.getFirstName(), accountHolder.getLastName(), "Savings", this.getAccountNumber(), this.getBalance());

        }
    }
}
