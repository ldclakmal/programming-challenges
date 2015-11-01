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
public class Diagonal_Difference {

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
