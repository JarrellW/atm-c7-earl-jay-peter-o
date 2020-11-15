import org.apache.commons.codec.digest.DigestUtils;
import java.util.ArrayList;



public class User {

    //user's first name
    private String firstName;
    //user's last name
    private String lastName;
    //user's unique user ID
    private int uuid;
    //user's hashed password
    private String passwordHash;
    //user's list of accounts
    private ArrayList<Account> accounts;

    public User(String firstName, String lastName, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.passwordHash = DigestUtils.sha256Hex(password);
    }

    public String getPasswordHash() {
        return passwordHash;
    }

}
