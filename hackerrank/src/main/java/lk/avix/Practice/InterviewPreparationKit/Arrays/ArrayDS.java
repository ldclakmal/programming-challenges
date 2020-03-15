package lk.avix.Practice.InterviewPreparationKit.Arrays;

/**
 * https://www.hackerrank.com/challenges/arrays-ds/problem
 */
public class ArrayDS {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int[] reverseArr = reverseArray(arr);
        for (int i : reverseArr) {
            System.out.print(i);
            System.out.print(" ");
        }
    }

    static int[] reverseArray(int[] a) {
        for (int i = 0; i < a.length / 2; i++) {
            int temp = a[i];
            a[i] = a[a.length - i - 1];
            a[a.length - i - 1] = temp;
        }
        return a;
    }
}
