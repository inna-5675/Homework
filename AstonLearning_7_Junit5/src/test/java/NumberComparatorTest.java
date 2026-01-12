import org.example.NumberComparator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NumberComparatorTest {
    @Test
    public void testCompareNumbers() {
        Assertions.assertEquals("5 больше 3", NumberComparator.compare(5, 3));
        Assertions.assertEquals("3 меньше 5", NumberComparator.compare(3, 5));
        Assertions.assertEquals("5 равно 5", NumberComparator.compare(5, 5));
    }
}