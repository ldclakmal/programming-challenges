package lk.avix.Practice.InterviewPreparationKit.Arrays;

/**
 * https://www.hackerrank.com/challenges/2d-array/problem
 */
public class _2DArrayDS {

    public static void main(String[] args) {
        int arr[][] = new int[][]{
                {-9, -9, -9, 1, 1, 1},
                {0, -9, 0, 4, 3, 2},
                {-9, -9, -9, 1, 2, 3},
                {0, 0, 8, 6, 6, 0},
                {0, 0, 0, -2, 0, 0},
                {0, 0, 1, 2, 4, 0}
        };
        int max = hourglassSum(arr);
        System.out.println(max);
    }

    static int hourglassSum(int[][] arr) {
        int maxsum = -1000, jj = 0;
        for (int i = 0; i < 4; i++) {
            int sum = 0;
            for (int j = jj; j < jj + 3; j++) {
                sum += arr[i][j];
                if (j == jj) {
                    sum += arr[i + 1][jj + 1];
                }
                sum += arr[i + 2][j];
            }
            jj = (jj < 3) ? jj + 1 : 0;
            if (sum > maxsum) {
                maxsum = sum;
            }
            if (jj != 0) {
                i--;
            }
        }

        return maxsum;
    }
}
