package lk.avix.Practice.ProblemSolving.Sorting;

import java.util.Scanner;

/**
 * @author Chanaka
 */
public class IntrotoTutorialChallanges {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int v = in.nextInt();
        int n = in.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println(_LinearSearch(arr, v));
    }

    private static int _LinearSearch(int A[], int x) {
        for (int i = 0; i < A.length; i++) {
            if (A[i] == x) {
                return i;
            }
        }
        return -1;
    }
}
