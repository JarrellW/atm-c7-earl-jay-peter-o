import java.util.ArrayList;

public class Savings extends Account implements Summary {
    private double APY = 0.70;
    private double n = 4;

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

    public double compoundInterest(int years) {
        double principal = this.getBalance();
        double amount = principal * Math.pow(1 + (APY / n), n * years);
        double compAmount = amount - principal;
        double aggregateAmount = amount + principal;
        return aggregateAmount;
    }


    public String toString(User accountHolder) {
        {
            double balance = this.getBalance();
            return String.format("%s %s\n %s\n%s\n%.2f", accountHolder.getFirstName(), accountHolder.getLastName(), "Savings", this.getAccountNumber(), this.getBalance());

        }
    }
}
