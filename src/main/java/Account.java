import java.util.ArrayList;

public abstract class Account implements Summary {

    private double balance;
    private final String accountNumber;
    private final User accountHolder;
    private final ArrayList<Transaction> transactionHistory;
    //private String accountType;


    /**
     * Constructor
     */
    public Account(double balance, User accountHolder, String accountNumber) {
        this.balance = balance;
        this.transactionHistory = new ArrayList<Transaction>();
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
    }



    /**
     * Getters and Setters
     */
    public double getBalance() {
        return balance;
    }

    public void setBalance(double amount) {
        this.balance = amount;
    }

    public ArrayList<Transaction> getTransactionHistory() {
        return transactionHistory;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * Methods
     */
    public boolean withdraw(double amount ) {

        if (amount <= balance) {
            this.setBalance(this.getBalance() - amount);
            return true;
        }

        //return false(insufficient funds)
        return false;
    }

    public void deposit(double amount) {
        this.setBalance(this.getBalance() + amount);
    }

    public void transfer(double amount, Account targetAccount) {

        this.withdraw(amount);
        targetAccount.deposit(amount);
    }

    /**
     * method for accounts to spit out information for the user in console
     * @return returns a string with account number, balance, and account name(or maybe type?)
     */
    public String getSummaryLine() {
        //get balance of this account
        double balance = this.getBalance();
        //account number, balance, account name
        return String.format("%s : $%.02f : %s", this.accountNumber, balance, String.valueOf(this.accountHolder)
        + "'s account");
    }

    /**
     * method that is called in User.printAccountTransactionHistory to print transaction history
     */
    public void printTransactionHistory() {
        System.out.printf("\nTransaction history for account %s\n", this.accountNumber);
        //prints a summary line for every transaction in this account's transaction history
        //starting with the most recent transaction and going backwards
        for(int i = this.transactionHistory.size() - 1; i >= 0; i--) {
            System.out.printf(this.transactionHistory.get(i).getSummaryLine());
        }
        System.out.println();
    }

    /**
     * method to add a new transaction to an existing account's transaction history
     * @param amount amount of money target account balance will be adjusted by
     */
    public void addTransaction(double amount) {
        //create a new transaction object and add it to transaction history
        Transaction newTransaction = new Transaction(amount, this);
        this.transactionHistory.add(newTransaction);
    }


}









