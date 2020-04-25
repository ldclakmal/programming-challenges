package lk.avix.practice.ProblemSolving.Warmup;

import java.util.Scanner;

/**
 * @author Chanaka
 */
public class DiagonalDifference {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count1 = 0;
        int count2 = 1;
        int sum1 = 0;
        int sum2 = 0;

        for (int i = 0; i < n * n; i++) {
            int val = sc.nextInt();

            if (i == n * count1 + count1) {
                sum1 += val;
                if (count1 < n) {
                    count1++;
                }
            }

            if (i == (n * (count2) - (count2))) {
                sum2 += val;
                if (count2 < n) {
                    count2++;
                }
            }

        }

        System.out.println(Math.abs(sum1 - sum2));
    }
}
