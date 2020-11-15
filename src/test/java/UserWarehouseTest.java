import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserWarehouseTest {

    @Test
    public void getNewUserUUID() {
        UserWarehouse userWarehouse = new UserWarehouse();
        AccountWarehouse accountWarehouse = new AccountWarehouse();
        User hamRabbit = new User("Ham", "Rabbit", "moreHay", userWarehouse);
        User newUser = new User("peter", "oberg", "password", userWarehouse);

        Assert.assertFalse(hamRabbit.getUUID().equals(newUser.getUUID()));
    }

    @Test
    public void addNewUser() {
        UserWarehouse userWarehouse = new UserWarehouse();
        AccountWarehouse accountWarehouse = new AccountWarehouse();
        User ham = userWarehouse.addNewUser("Ham", "Rabbit", "moreHay");
        User peter = userWarehouse.addNewUser("Peter", "Oberg", "password");

        int expected = 2;
        int actual = userWarehouse.getUserList().size();

        assertEquals(expected, actual);
    }

    @Test
    public void userLogin() {
        UserWarehouse userWarehouse = new UserWarehouse();
        AccountWarehouse accountWarehouse = new AccountWarehouse();
        User ham = userWarehouse.addNewUser("Ham", "Rabbit", "moreHay");
        User peter = userWarehouse.addNewUser("Peter", "Oberg", "password");

        assertEquals(ham, userWarehouse.userLogin(ham.getUUID(), "moreHay"));
    }
}