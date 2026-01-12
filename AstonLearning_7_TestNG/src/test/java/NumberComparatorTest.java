import org.example.NumberComparator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NumberComparatorTest {
    @Test
    public void testCompareNumbers() {
        Assert.assertEquals(NumberComparator.compare(5, 3), "5 больше 3");
        Assert.assertEquals(NumberComparator.compare(3, 5), "3 меньше 5");
        Assert.assertEquals(NumberComparator.compare(5, 5), "5 равно 5");
    }
}