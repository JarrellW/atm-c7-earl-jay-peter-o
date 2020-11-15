
public class Transaction {
    private double amount;
    private Account originAccount;
    private Account targetAccount;

    public Transaction(double amount, Account originAccount) {
        this.amount = amount;
        this.originAccount = originAccount;
    }

    public Transaction(double amount, Account originAccount, Account targetAccount) {
        this.amount = amount;
        this.originAccount = originAccount;
        this.targetAccount = targetAccount;
    }


    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Account getOriginAccount() {
        return originAccount;
    }

    public void setOriginAccount(Account originAccount) {
        this.originAccount = originAccount;
    }

    public Account getTargetAccount() {
        return targetAccount;
    }

    public void setTargetAccount(Account targetAccount) {
        this.targetAccount = targetAccount;
    }
}
