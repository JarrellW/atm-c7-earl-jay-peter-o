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

    public void addAccount(Account anAccount) {
        this.accounts.add(anAccount);
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public String getUUID() {
        return uuid;
    }
}
