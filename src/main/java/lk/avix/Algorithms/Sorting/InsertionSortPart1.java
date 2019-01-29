/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms.Sorting;

import java.util.Scanner;

/**
 *
 * @author Chanaka
 */
public class InsertionSortPart1 {

    public static void insertIntoSorted(int[] A) {
        boolean swapped;
        int n = A.length;
        int newLimit = n;
        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (A[i - 1] > A[i]) {
                    int temp = A[i];
                    A[i] = A[i - 1];
                    printArray(A);
                    A[i - 1] = temp;
                    swapped = true;
                    newLimit = n - 1;
                }
            }
            n = newLimit;
        } while (swapped);
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
        printArray(ar);
    }

    private static void printArray(int[] ar) {
        for (int n : ar) {
            System.out.print(n + " ");
        }
        System.out.println("");
    }
}
