/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms.Search;

import java.util.Scanner;

/**
 *
 * @author Chanaka
 */
public class Lonely_Integer {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = Integer.parseInt(in.nextLine());
        String data[] = in.nextLine().split(" ");

        for (int i = 0; i < 101; i++) {
            int count = 0;
            for (int j = 0; j < data.length; j++) {
                if (i == Integer.parseInt(data[j])) {
                    count++;
                }
            }
            if (count == 1) {
                System.out.println(i);
            }
        }
    }
//    static int lonelyinteger(int[] a) {
//        return 0;
//
//    }
//
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int res;
//
//        int _a_size = Integer.parseInt(in.nextLine());
//        int[] _a = new int[_a_size];
//        int _a_item;
//        String next = in.nextLine();
//        String[] next_split = next.split(" ");
//
//        for (int _a_i = 0; _a_i < _a_size; _a_i++) {
//            _a_item = Integer.parseInt(next_split[_a_i]);
//            _a[_a_i] = _a_item;
//        }
//
//        res = lonelyinteger(_a);
//        System.out.println(res);
//
//    }
}
