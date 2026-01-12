import org.example.FactorialCalculator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FactorialCalculatorTest {
    @Test
    public void testFactorialOfPositiveNumber() {
        Assert.assertEquals(FactorialCalculator.calculateFactorial(5), 120);
    }
    @Test
    public void testFactorialOfZero() {
        Assert.assertEquals(FactorialCalculator.calculateFactorial(0), 1);
    }
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testFactorialWithNegative() {
        FactorialCalculator.calculateFactorial(-1);
    }
}
