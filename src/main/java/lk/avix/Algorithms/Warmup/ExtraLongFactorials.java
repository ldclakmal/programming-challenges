package lk.avix.Algorithms.Warmup;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author Chanaka
 */
public class ExtraLongFactorials {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String fac = factorial(n);
        System.out.println(fac);
    }

    public static String factorial(int n) {
        BigInteger fact = new BigInteger("1");
        for (int i = 1; i <= n; i++) {
            fact = fact.multiply(new BigInteger(i + ""));
        }
        return fact.toString();
    }
}
