package lk.avix.Practice.ProblemSolving.Warmup;

import java.util.Scanner;

/**
 * @author Chanaka
 */
public class PlusMinus {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int pos = 0;
        int neg = 0;
        int zero = 0;

        for (int i = 0; i < n; i++) {
            int temp = sc.nextInt();
            if (temp > 0) {
                pos++;
            } else if (temp < 0) {
                neg++;
            } else {
                zero++;
            }
        }

        System.out.printf("%.3f%n", (double) pos / n);
        System.out.printf("%.3f%n", (double) neg / n);
        System.out.printf("%.3f%n", (double) zero / n);
    }
}
