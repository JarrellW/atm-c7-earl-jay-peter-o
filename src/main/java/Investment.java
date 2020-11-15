import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

public class Investment extends Account implements Summary {
    private double APY;
    private double n = 12;

    /**
     * Constructor
     *
     * @param balance
     * @param accountHolder
     * @param accountNumber
     */
    public Investment(double balance, User accountHolder, String accountNumber) {
        super(balance, accountHolder, accountNumber);
    }

    public double compoundInterest(int years) {
        Random rando = new Random();
        double principal = this.getBalance();
        this.APY = rando.nextDouble() * 5;

        double amount = principal * Math.pow(1 + (this.APY / n), n * years);
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
