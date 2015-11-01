/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms.Warmup;

import java.util.Scanner;

/**
 *
 * @author Chanaka
 */
public class Gem_Stones {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = Integer.parseInt(in.nextLine());
        String data[] = new String[N];

        for (int i = 0; i < N; i++) {
            data[i] = in.nextLine();
        }

        int tot_count = 0;
        for (int i = 97; i < 123; i++) {
            char c = (char) i;
            int count = 0;
            for (int j = 0; j < N; j++) {
                String s = data[j];
                int index = s.indexOf(String.valueOf(c));
                if (index == -1) {
                    break;
                } else {
                    count++;
                }
                if (count == N) {
                    tot_count++;
                    count = 0;
                }
            }
        }

        System.out.println(tot_count);
    }
}
