import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void userConstructorTest() {
        User newUser = new User("peter", "oberg", "password");
        System.out.println(newUser.getPasswordHash());
    }

    @Test
    public void passwordHashTest() {
        User newUser = new User("peter", "oberg", "password");
        String expected = "5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8";
        String actual = newUser.getPasswordHash();

        assertEquals(expected, actual);
    }

}