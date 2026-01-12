import org.example.TriangleAreaCalculator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TriangleAreaCalculatorTest {
    @Test
    public void testValidTriangleArea() {
        Assert.assertEquals(TriangleAreaCalculator.calculateArea(3, 4, 5), 6.0);
    }

    @Test
    public void testInvalidTriangleArea() {
        Assert.assertEquals(TriangleAreaCalculator.calculateArea(1, 2, 3), -1);
    }
}