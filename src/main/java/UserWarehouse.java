import java.util.ArrayList;

public class UserWarehouse {

    private ArrayList<User> userList = new ArrayList<User>();

    public UserWarehouse(ArrayList<User> userList) {
        this.userList = userList;
    }

    public void addUser(int uuid, String firstName, String lastName) {
        User newUser = new User(uuid, firstName, lastName);
        userList.add(newUser);
    }
}
