import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class UserWarehouse {

    private ArrayList<User> userList = new ArrayList<User>();

    public UserWarehouse() {
        this.userList = new ArrayList<User>();
    }

    public String getNewUserUUID() {

        //inits
        String uuid;
        Random rand = new Random();
        int length = 5;
        boolean nonUnique;

        //continue looping until a unique UUID is generated
        do {
            //generate uuid
            uuid = "";
            for(int i = 0; i < length; i++) {
                uuid += ((Integer)rand.nextInt(10));
            }

            //make sure uuid is actually unique
            nonUnique = false;
            for(User u : this.userList) {
                if(uuid.compareTo(u.getUUID()) == 0) {
                    nonUnique = true;
                    break;
                }
            }

        } while (nonUnique);

        return uuid;
    }

    /**
     * Creates a new user object and adds it to the list of users with a first name, last name, and hashed pw
     * @param firstName the user's first name
     * @param lastName the user's last name
     * @param password the user's password
     * @return newUser
     */
    public User addNewUser(String firstName, String lastName, String password) {
        //create new User object and add it to list of Users
        User newUser = new User(firstName, lastName, password, this);
        this.userList.add(newUser);
        return newUser;
    }

    /**
     * if userID is valid and password matches userID, return User object associated with that unique user ID
     * @param userID the unique user ID, needed for login
     * @param password the password associated with unique user ID
     * @return User
     */
    public User userLogin(String userID, String password) {
        //search through list of users
        for(User u : this.userList) {
            //if unique user ID matches an existing uuid
            if(u.getUUID().equals(userID) && u.validatePassword(password)) {
                //return User that is currently being evaluated in for each loop
                return u;
            }
        }
        //if loop executes without if statement ever being satisfied, return null
        return null;
    }


}
