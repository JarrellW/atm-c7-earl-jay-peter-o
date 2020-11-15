import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class CheckingTest {
    private Checking checkingTest1;
    private Checking checkingTest2;
    private UserWarehouse userWarehouseTest;
    private User accountHolderTest1;
    private User accountHolderTest2;
    private AccountWarehouse accountWarehouseTest;
    private final double startingDeposit = 50.00;
    private final double startingDeposit2 = 150.00;

    private String password = "5555";
    private final String accountNumber = "123456789";
    private final String accountNumber2 = "987654321";


    @BeforeEach
    void setUp() {
        ArrayList<Transaction> transactionHistory = new ArrayList<Transaction>();
        ArrayList<User> user = new ArrayList<User>();
        ArrayList<Account> accounts = new ArrayList<Account>();


        this.userWarehouseTest = new UserWarehouse();
        this.accountHolderTest1 = new User("Billy", "Ray", password, userWarehouseTest);
        this.accountHolderTest2 = new User("Leland", "McCullen", password, userWarehouseTest);

        this.accountWarehouseTest = new AccountWarehouse();
        this.checkingTest1 = new Checking(startingDeposit, accountHolderTest1, accountNumber);
        this.checkingTest2 = new Checking(startingDeposit2, accountHolderTest2, accountNumber2);

        checkingTest1.addTransaction(startingDeposit);
        checkingTest2.addTransaction(startingDeposit2);

        accounts.add(checkingTest1);
        accounts.add(checkingTest2);

        accountHolderTest1.addAccount(checkingTest1);
        accountHolderTest1.addAccount(checkingTest2);

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getBalance() {
        double expected = startingDeposit;
        double actual = checkingTest1.getBalance();

        Assert.assertEquals(expected, actual, .00);

    }

    @Test
    void getAccountNumber() {
        String expected = accountNumber;
        String actual = checkingTest1.getAccountNumber();

        Assert.assertEquals(expected, actual);

    }

    @Test
    void withdraw() {

        //Given
        double amount = 10.00;
        double prevAmount = checkingTest1.getBalance();
        double expected = prevAmount - amount;

        //When
        checkingTest1.withdraw(10);
        double actual = checkingTest1.getBalance();

        //Then
        Assert.assertTrue(checkingTest1.withdraw(10));
        Assert.assertEquals(expected, actual, .00);
    }

    @Test
    void deposit() {

        //Given
        double amount = 10.00;
        double prevAmount = checkingTest1.getBalance();
        double expected = prevAmount + amount;

        //When
        checkingTest1.deposit(amount);
        double actual = checkingTest1.getBalance();

        //Then
        Assert.assertEquals(expected, actual, .00);

    }

    @Test
    void transfer() {
        //Given
        double amount = 10.00;
        double prevOriginBalance = checkingTest1.getBalance();
        double prevTargetBalance = checkingTest2.getBalance();

        //When
        double postOriginBalance = prevOriginBalance - amount;
        double postTargetBalance = prevTargetBalance + amount;

        checkingTest1.transfer(amount, checkingTest2);
        double actualOriginBalance = checkingTest1.getBalance();
        double actualTargetBalance = checkingTest2.getBalance();

        //Then

        //Origin
        Assert.assertNotEquals(prevOriginBalance, actualOriginBalance, .00);
        Assert.assertEquals(actualOriginBalance, postOriginBalance, .00);

        //Target
        Assert.assertNotEquals(prevTargetBalance, actualTargetBalance, .00);
        Assert.assertEquals(actualTargetBalance, postTargetBalance, .00);

    }


    @Test
    void getSummaryLine() {

    }

    @Test
    void printTransactionHistory() {
    }

    @Test
    void addTransaction() {
        //Given
        double amount = 10.00;
        double prevOriginBalance = checkingTest1.getBalance();
        double prevTargetBalance = checkingTest2.getBalance();

        //When
        double postOriginBalance = prevOriginBalance - amount;
        double postTargetBalance = prevTargetBalance + amount;

        checkingTest1.transfer(amount, checkingTest2);

        double actualOriginBalance = checkingTest1.getBalance();
        double actualTargetBalance = checkingTest2.getBalance();
    }

    @Test
    void testToString() {
    }
}