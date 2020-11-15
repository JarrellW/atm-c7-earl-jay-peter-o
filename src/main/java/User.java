import org.apache.commons.codec.digest.DigestUtils;
import java.util.ArrayList;



public class User {

    //user's first name
    private String firstName;
    //user's last name
    private String lastName;
    //user's unique user ID
    private String uuid;
    //user's hashed password
    private String passwordHash;
    //user's list of accounts
    private ArrayList<Account> accounts;

    /**
     *
     * @param firstName user's first name
     * @param lastName user's last name
     * @param password user's password, stored as a hash
     */
    public User(String firstName, String lastName, String password, UserWarehouse uWarehouse) {
        //set user's name
        this.firstName = firstName;
        this.lastName = lastName;
        //store hash of user's pw
        this.passwordHash = DigestUtils.sha256Hex(password);
        //get unique user id
        this.uuid = uWarehouse.getNewUserUUID();
        //create list of user accounts
        this.accounts = new ArrayList<Account>();
        //print log message
        System.out.println("New user " + lastName + ", " + firstName + ", " +
                "with ID " + this.uuid + " created");
    }

    /**
     * boolean to check if password is correct when logging in
     * @param password the password entered by user on attempted login
     * @return returns true if hash of password parameter matches the user in question's password hash
     */
    public boolean validatePassword(String password) {
        //password that is being checked for validity
        String inputPasswordHash;
        //converting password string into hash
        inputPasswordHash = DigestUtils.sha256Hex(password);
        //checking attempted password hash against this user's hashed password
        if(inputPasswordHash.equals(this.passwordHash)) {
            return true;
        } else {
            return false;
        }
    }

    public void printAccountsSummary() {
        System.out.printf("\n%s's accounts summary\n", this.firstName);
        for(int i = 0; i < this.accounts.size(); i++) {
            System.out.printf("%d) account number %s\n", i+1, this.accounts.get(i).getSummaryLine());
        }
        System.out.println();
    }

    public void printAccountTransactionHistory(int accountIndex) {
        this.accounts.get(accountIndex).printTransactionHistory();
    }

    public void addAccount(Account anAccount) {
        this.accounts.add(anAccount);
    }

    public double getAccountBalance(int accountIndex) {
        return this.accounts.get(accountIndex).getBalance();
    }

    /**
     * Method to get the account number of a particular account, useful for transfers
     * @param accountIndex index of the account in user's account list
     * @return returns specific account number in string form
     */
    public String getAccountNumber(int accountIndex) {
        return this.accounts.get(accountIndex).getAccountNumber();
    }

    /**
     * method to add transaction to a particular account in a user's accounts list
     * @param accountIndex index of account where transaction is occurring
     * @param amount amount of money balance is adjusted by
     */
    public void addAccountTransaction(int accountIndex, double amount) {
        this.accounts.get(accountIndex).addTransaction(amount);
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public String getUUID() {
        return uuid;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public int getNumAccounts() {
        return accounts.size();
    }
}
