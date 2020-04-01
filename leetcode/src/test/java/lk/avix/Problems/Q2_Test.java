package lk.avix.Problems;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Test
public class Q2_Test {

    Q2_AddTwoNumbers solution;

    @BeforeClass
    private void init() {
        solution = new Q2_AddTwoNumbers();
    }

    @Test
    public void testCase1() {
        // Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
        // Output: 7 -> 0 -> 8
        // Explanation: 342 + 465 = 807.

        int[] arr1 = new int[]{2, 4, 3};
        int[] arr2 = new int[]{5, 6, 4};
        String output = solution.add(arr1, arr2);
        Assert.assertEquals(output, "708");
    }

    @Test
    public void testCase2() {
        // l1 = [0,1]
        // l2 = [0,1,2]

        int[] arr1 = new int[]{0, 1};
        int[] arr2 = new int[]{0, 1, 2};
        String output = solution.add(arr1, arr2);
        Assert.assertEquals(output, "022");
    }

    @Test
    public void testCase3() {
        // l1 = []
        // l2 = [0,1]

        int[] arr1 = new int[]{};
        int[] arr2 = new int[]{0, 1};
        String output = solution.add(arr1, arr2);
        Assert.assertEquals(output, "01");
    }

    @Test
    public void testCase4() {
        // l1 = [9,9]
        // l2 = [1]

        int[] arr1 = new int[]{9, 9};
        int[] arr2 = new int[]{1};
        String output = solution.add(arr1, arr2);
        Assert.assertEquals(output, "001");
    }
}
