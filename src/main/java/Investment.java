public class Investment extends Account {
    private double r = Math.random()/50;
    private double n = 364;
    private double aggregate;


    /**
     * Constructor
     *
     * @param balance
     * @param accountHolder
     * @param accountNumber
     */

    public Investment(double balance, User accountHolder, String accountNumber) {
        super(balance, accountHolder, accountNumber);
        this.type = "investment";
        this.interestPercent = r * 100;
        this.accrued = compoundInterest();
    }

    @Override
    public Account getFirstName() {
        return null;
    }

    @Override
    public Account getLastName() {
        return null;
    }

    public double compoundInterest() {
        double principal = this.getBalance();
        double amount = principal * Math.pow(1 + (r / n), n * 1);
        this.accrued = amount - principal;
        this.aggregate = amount + principal;
        return accrued;
    }
/*
    @Override
    public String toString() {
        {
            double balance = this.getBalance();
            return String.format("%s %s\n %s\n%s\n%.2f\nCurrent interest rate is: %1.1f\n" +
                    "With current balance as principal,\ncompounded daily," +
                    "\nthis account will accrue: $%.2f in 1 year.",
                    accountHolder.getFirstName(), accountHolder.getLastName(), "Investment",
                    this.getAccountNumber(), this.getBalance(), interestPercent, accrued);

        }
    }

 */
}
