import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class UserWarehouse {

    private static int uuid = 1;
    private ArrayList<User> userList = new ArrayList<User>();

//    public User createUser(String userName, String firstName, String lastName) {
//        User newUser = new User(uuid++, userName, firstName, lastName);
//        userList.add(newUser);
//        return newUser;
//    }

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

    public User addNewUser(String firstName, String lastName, String password) {
        //create new User object and add it to list of Users
        User newUser = new User(firstName, lastName, password, this);
        this.userList.add(newUser);
        return newUser;
    }


}
