import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class AccountWarehouseTest {

    @Test
    public void getNewAccountNumber() {
        UserWarehouse userWarehouse = new UserWarehouse();
        AccountWarehouse accountWarehouse = new AccountWarehouse();
        User newUser = new User("Ham", "Rabbit", "moreHay", userWarehouse);
        accountWarehouse.createCheckingAccount(newUser, 0);
        accountWarehouse.createCheckingAccount(newUser, 0);

        Assert.assertFalse(newUser.getAccountNumber(0).equals(newUser.getAccountNumber(1)));
    }

    @Test
    public void removeAccount() {
        UserWarehouse userWarehouse = new UserWarehouse();
        AccountWarehouse accountWarehouse = new AccountWarehouse();
        User newUser = new User("peter", "oberg", "password", userWarehouse);
        accountWarehouse.createCheckingAccount(newUser, 10.0);
        accountWarehouse.createSavingsAccount(newUser, 1000);

        accountWarehouse.removeAccount(newUser, newUser.getAccountNumber(0));
        int expected = 1;
        int actual = newUser.getNumAccounts();

        assertEquals(expected, actual);
    }

    @Test
    public void createSavingsAccount() {
        UserWarehouse userWarehouse = new UserWarehouse();
        AccountWarehouse accountWarehouse = new AccountWarehouse();
        User newUser = new User("peter", "oberg", "password", userWarehouse);
        accountWarehouse.createCheckingAccount(newUser, 10.0);

        int expected = 1;
        int actual = newUser.getNumAccounts();

        assertEquals(expected, actual);
    }

    @Test
    public void createCheckingAccount() {
        UserWarehouse userWarehouse = new UserWarehouse();
        AccountWarehouse accountWarehouse = new AccountWarehouse();
        User newUser = new User("peter", "oberg", "password", userWarehouse);
        accountWarehouse.createSavingsAccount(newUser, 10.0);

        int expected = 1;
        int actual = newUser.getNumAccounts();

        assertEquals(expected, actual);
    }

    @Test
    public void createInvestmentAccount() {
        UserWarehouse userWarehouse = new UserWarehouse();
        AccountWarehouse accountWarehouse = new AccountWarehouse();
        User newUser = new User("peter", "oberg", "password", userWarehouse);
        accountWarehouse.createInvestmentAccount(newUser, 10.0);

        int expected = 1;
        int actual = newUser.getNumAccounts();

        assertEquals(expected, actual);
    }
}