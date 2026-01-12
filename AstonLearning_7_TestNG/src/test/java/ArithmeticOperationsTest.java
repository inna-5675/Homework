import org.example.ArithmeticOperations;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ArithmeticOperationsTest {
    @Test
    public void testAddition() {
        Assert.assertEquals(ArithmeticOperations.add(2, 3), 5);
    }
    @Test(expectedExceptions = ArithmeticException.class)
    public void testDivisionByZero() {
        ArithmeticOperations.divide(1, 0);
    }
}

