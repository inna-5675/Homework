import org.example.ArithmeticOperations;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArithmeticOperationsTest {
    @Test
    public void testAddition() {
        Assertions.assertEquals(5, ArithmeticOperations.add(2, 3));
    }
    @Test
    public void testDivisionByZero() {
        Assertions.assertThrows(ArithmeticException.class, () -> {
            ArithmeticOperations.divide(1, 0);
        });
    }
}