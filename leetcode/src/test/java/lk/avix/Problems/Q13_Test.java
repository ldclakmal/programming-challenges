package lk.avix.Problems;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Test
public class Q13_Test {

    Q13_RomanToInteger solution;

    @BeforeClass
    private void init() {
        solution = new Q13_RomanToInteger();
    }

    @Test
    public void testCase1() {
        int num = solution.romanToInt("III");
        Assert.assertEquals(num, 3);
    }

    @Test
    public void testCase2() {
        int num = solution.romanToInt("IV");
        Assert.assertEquals(num, 4);
    }

    @Test
    public void testCase3() {
        int num = solution.romanToInt("IX");
        Assert.assertEquals(num, 9);
    }

    @Test
    public void testCase4() {
        int num = solution.romanToInt("LVIII");
        Assert.assertEquals(num, 58);
    }

    @Test
    public void testCase5() {
        int num = solution.romanToInt("MCMXCIV");
        Assert.assertEquals(num, 1994);
    }
}
