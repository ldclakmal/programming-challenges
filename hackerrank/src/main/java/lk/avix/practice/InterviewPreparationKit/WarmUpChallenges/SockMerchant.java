package lk.avix.practice.InterviewPreparationKit.WarmUpChallenges;

import java.util.HashMap;
import java.util.Map;

/**
 * https://www.hackerrank.com/challenges/sock-merchant
 */
public class SockMerchant {

    public static void main(String[] args) {
        int n = 9;
        int[] ar = new int[]{10, 20, 20, 10, 10, 30, 50, 10, 20};
        int count = sockMerchant(n, ar);
        System.out.println(count);
    }

    static int sockMerchant(int n, int[] ar) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap();
        for (int i : ar) {
            if (map.get(i) != null) {
                count++;
                map.remove(i);
            } else {
                map.put(i, 1);
            }
        }
        return count;
    }
}
