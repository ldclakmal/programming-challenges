package lk.avix.Problems;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Test
public class Q7_Test {

    Q7_ReverseInteger solution;

    @BeforeClass
    private void init() {
        solution = new Q7_ReverseInteger();
    }

    @Test
    public void testCase1() {
        int output = solution.reverse(123);
        Assert.assertEquals(output, 321);
    }

    @Test
    public void testCase2() {
        int output = solution.reverse(-123);
        Assert.assertEquals(output, -321);
    }

    @Test
    public void testCase3() {
        int output = solution.reverse(120);
        Assert.assertEquals(output, 21);
    }

    @Test
    public void testCase4() {
        int output = solution.reverse(1534236469);
        Assert.assertEquals(output, 0);
    }
}
