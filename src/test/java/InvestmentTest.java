import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InvestmentTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void compoundInterestTest() {
        //Given
        int years = 1;
        UserWarehouse warehouse = new UserWarehouse();
        User accountHolder = new User("Lisa-Ann", "Jenkins", "5555", warehouse);
        Investment investmentTest = new Investment(100, accountHolder, "123456789");

        //When
        double prevBalance = investmentTest.getBalance();
        double predictedBalance = investmentTest.compoundInterest() + prevBalance;

        //Then
        Assert.assertTrue(predictedBalance > prevBalance);
    }

    @Test
    void ToStringTest() {
    }
}