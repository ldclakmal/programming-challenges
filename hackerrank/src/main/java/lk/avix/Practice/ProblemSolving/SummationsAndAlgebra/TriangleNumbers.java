package lk.avix.Practice.ProblemSolving.SummationsAndAlgebra;

import java.util.Scanner;

/**
 * NOT COMPLETED..............
 *
 * @author Chanaka
 */
public class TriangleNumbers {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int T, K;
        T = in.nextInt();
        int C[] = new int[T];
        for (int i = 0; i < T; i++) {
            C[i] = in.nextInt();
        }

        for (int k = 0; k < C.length; k++) {

            for (int i = C[k]; i < C[k] + 1; i++) {
                int number = 1;
                for (int j = 0; j <= i; j++) {
                    System.out.print(number + " ");
                    if (number % 2 == 0) {
                        System.out.println(number + ":" + j);
                        break;
                    }
                    number = number * (i - j) / (j + 1);
                }
                System.out.println();
            }
        }
    }
}
