/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms.Implementation;

import java.util.Scanner;

/**
 *
 * @author Chanaka
 */
public class Angry_Professor {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        for (int i = 0; i < N; i++) {
            int x = in.nextInt();
            int t = in.nextInt();
            int count = 0;
            for (int j = 0; j < x; j++) {
                if (in.nextInt() <= 0) {
                    count++;
                }
            }
            if (count < t) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
