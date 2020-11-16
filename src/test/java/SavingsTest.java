import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SavingsTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void compoundInterest() {
//Given
        int years = 1;
        UserWarehouse warehouse = new UserWarehouse();
        User accountHolder = new User("Lisa-Ann", "Jenkins", "5555", warehouse);
        Savings savingsTest = new Savings(100, accountHolder, "123456789");

        //When
        double prevBalance = savingsTest.getBalance();
        double predictedBalance = savingsTest.compoundInterest() + prevBalance;

        //Then
        Assert.assertTrue(predictedBalance > prevBalance);
    }

    @Test
    void testToString() {
    }
}