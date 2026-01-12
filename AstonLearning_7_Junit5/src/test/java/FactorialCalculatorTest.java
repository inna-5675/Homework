import org.example.FactorialCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FactorialCalculatorTest {
    @Test
    public void testFactorialOfPositiveNumber() {
        Assertions.assertEquals(120, FactorialCalculator.calculateFactorial(5));
    }
    @Test
    public void testFactorialOfZero() {
        Assertions.assertEquals(1, FactorialCalculator.calculateFactorial(0));
    }
    @Test
    public void testFactorialWithNegative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            FactorialCalculator.calculateFactorial(-1);
        });
    }
}
