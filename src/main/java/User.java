import java.util.ArrayList;

public class User {

    private String firstName;
    private String lastName;
    private String userName;
    private int uuid;

    public User(int uuid, String userName, String firstName, String lastName) {
        this.uuid = uuid;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
    }


}
