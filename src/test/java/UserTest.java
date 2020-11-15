import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void userConstructorTest() {
        UserWarehouse userWarehouse = new UserWarehouse();
        User newUser = new User("peter", "oberg", "password", userWarehouse);
        System.out.println(newUser.getPasswordHash());
    }

    @Test
    public void passwordHashTest() {
        UserWarehouse userWarehouse = new UserWarehouse();
        User newUser = new User("peter", "oberg", "password", userWarehouse);
        String expected = "5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8";
        String actual = newUser.getPasswordHash();

        assertEquals(expected, actual);
    }

    @Test
    public void validatePasswordTest() {
        UserWarehouse userWarehouse = new UserWarehouse();
        User newUser = new User("peter", "oberg", "password", userWarehouse);
        boolean expected = true;
        assertEquals(expected,newUser.validatePassword("password"));
    }

    @Test
    public void printAccountSummaryTest() {
        UserWarehouse userWarehouse = new UserWarehouse();
        AccountWarehouse accountWarehouse = new AccountWarehouse();
        User newUser = new User("peter", "oberg", "password", userWarehouse);

        accountWarehouse.createCheckingAccount(newUser, 10.0);
        accountWarehouse.createInvestmentAccount(newUser, 10.0);

        newUser.printAccountsSummary();
    }

    @Test
    public void printAccountTransactionHistoryTest() {
        UserWarehouse userWarehouse = new UserWarehouse();
        AccountWarehouse accountWarehouse = new AccountWarehouse();
        User newUser = new User("peter", "oberg", "password", userWarehouse);
        accountWarehouse.createCheckingAccount(newUser, 10.0);
        newUser.addAccountTransaction(0, 10.0);
        newUser.addAccountTransaction(0, 5);
        newUser.addAccountTransaction(0, -10);
        double expected = 15d;
        double actual = newUser.getAccountBalance(0);
        //assertEquals(expected, actual, .001);
        newUser.printAccountTransactionHistory(0);
    }
}