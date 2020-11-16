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
        this.type = "checking";
    }

    @Override
    public Account getFirstName() {
        return null;
    }

    @Override
    public Account getLastName() {
        return null;
    }

    @Override
    public double compoundInterest() {
        return 0;
    }
/*
    @Override
    public String toString() {
        {
            double balance = this.getBalance();
            return String.format("%s %s\n %s\n%s\n%.2f", accountHolder.getFirstName(), accountHolder.getLastName(), "Checking", this.getAccountNumber(), this.getBalance());

        }
    }

 */


}
