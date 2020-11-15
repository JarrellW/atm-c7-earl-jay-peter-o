import java.util.ArrayList;

public class Savings extends Account implements Summary {
    /**
     * Constructor
     *
     * @param balance
     * @param transactionHistory
     * @param accountHolder
     */
    public Savings(double balance, ArrayList<Transaction> transactionHistory, User accountHolder, String accountNumber) {
        super(balance, transactionHistory, accountHolder, accountNumber);
    }


    public String toString(User accountHolder) {
        {
            double balance = this.getBalance();
            return String.format("%s %s\n %s\n%s\n%.2f", accountHolder.getFirstName(), accountHolder.getLastName(), "Savings", this.getAccountNumber(), this.getBalance());

        }
    }
}
