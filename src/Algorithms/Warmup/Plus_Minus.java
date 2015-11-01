/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms.Warmup;

import java.util.Scanner;

/**
 *
 * @author Chanaka
 */
public class Plus_Minus {

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
