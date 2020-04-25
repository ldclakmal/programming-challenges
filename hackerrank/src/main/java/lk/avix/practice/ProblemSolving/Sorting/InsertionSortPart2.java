package lk.avix.practice.ProblemSolving.Sorting;

import java.util.Scanner;

/**
 * @author Chanaka
 */
public class InsertionSortPart2 {

    public static void insertIntoSorted(int[] A) {
        for (int i = 1; i < A.length; i++) {
            int tmp = A[i];
            int idx = i - 1;
            while (idx >= 0 && A[idx] > tmp) {
                A[idx + 1] = A[idx];
                idx -= 1;
            }
            A[idx + 1] = tmp;
            printArray(A);
        }
    }

    /* Tail starts here */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int[] ar = new int[s];
        for (int i = 0; i < s; i++) {
            ar[i] = in.nextInt();
        }
        insertIntoSorted(ar);
    }

    private static void printArray(int[] ar) {
        for (int n : ar) {
            System.out.print(n + " ");
        }
        System.out.println("");
    }
}
