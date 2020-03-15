package lk.avix.Practice.InterviewPreparationKit.Arrays;

/**
 * https://www.hackerrank.com/challenges/array-left-rotation/problem
 */
public class LeftRotation {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int d = 4;
        int[] rotatedArr = rotateLeft(arr, d);
        for (int i : rotatedArr) {
            System.out.print(i);
            System.out.print(" ");
        }
    }

    static int[] rotateLeft(int[] a, int d) {
        for (int i = 0; i < d; i++) {
            int temp = a[0];
            for (int j = 0; j < a.length - 1; j++) {
                a[j] = a[j + 1];
            }
            a[a.length - 1] = temp;
        }
        return a;
    }
}
