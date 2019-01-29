package lk.avix.Algorithms.Warmup;

import java.util.Scanner;

/**
 * @author Chanaka
 */
public class MaximizingXOR {

    static int maxXor(int l, int r) {
        int max = 0;
        for (int i = l; i < r + 1; i++) {
            for (int j = l; j < r + 1; j++) {
                int xor = i ^ j;
                if (xor > max) {
                    max = xor;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;
        int _l;
        _l = Integer.parseInt(in.nextLine());

        int _r;
        _r = Integer.parseInt(in.nextLine());

        res = maxXor(_l, _r);
        System.out.println(res);
    }
}