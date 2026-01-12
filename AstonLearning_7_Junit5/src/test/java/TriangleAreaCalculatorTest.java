import org.example.TriangleAreaCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleAreaCalculatorTest {
    @Test
    public void testValidTriangleArea() {
        Assertions.assertEquals(6.0, TriangleAreaCalculator.calculateArea(3, 4, 5));
    }

    @Test
    public void testInvalidTriangleArea() {
        Assertions.assertEquals(-1, TriangleAreaCalculator.calculateArea(1, 2, 3));
    }
}
