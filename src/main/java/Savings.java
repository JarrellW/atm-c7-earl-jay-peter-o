import java.util.ArrayList;

public class Savings extends Account implements Summary {
    /**
     * Constructor
     *
     * @param balance
     * @param accountNumber
     * @param accountHolder
     */
    public Savings(double balance, User accountHolder, String accountNumber) {
        super(balance, accountHolder, accountNumber);
    }


    public String toString(User accountHolder) {
        {
            double balance = this.getBalance();
            return String.format("%s %s\n %s\n%s\n%.2f", accountHolder.getFirstName(), accountHolder.getLastName(), "Savings", this.getAccountNumber(), this.getBalance());

        }
    }
}
