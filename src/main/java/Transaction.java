
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

    /**
     * method to create a summaryLine for a particular transaction, to be printed in the
     * Account.printTransactionHistory method
     * @return returns summaryLine for transaction
     */
    public String getSummaryLine() {
        String summaryLine = String.format("$%.02f from %o to %o", amount, originAccount, targetAccount);
        return summaryLine;
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
