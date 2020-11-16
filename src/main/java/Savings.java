public class Savings extends Account  {
    private double r = Math.random()/100;
    private double n = 12;
    private double aggregate;


    /**
     * Constructor
     *
     * @param balance
     * @param accountNumber
     * @param accountHolder
     */
    public Savings(double balance, User accountHolder, String accountNumber) {
        super(balance, accountHolder, accountNumber);
        this.type = "savings";
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
        accrued = amount - principal;
        this.aggregate = amount + principal;
        return accrued;
    }


   /*
    public String toString() {
        {
            double balance = this.getBalance();
            return (String.format("%s %s\n %s\n%s\n%.2f\nCurrent interest rate is: %1.1f\n" +
                            "With current balance as principal,\ncompounded monthly," +
                            "\nthis account will accrue: $%.2f in 1 year.",
                    accountHolder.getFirstName(), accountHolder.getLastName(), "Savings",
                    this.getAccountNumber(), this.getBalance(), interestPercent, accrued));
        }
    }

    */
}
