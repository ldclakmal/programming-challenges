package lk.avix.Practice.Java.Introduction;

import java.util.Scanner;

/**
 * @author Chanaka
 */
public class JavaLoopsI {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        scanner.close();
        for (int i = 1; i <= 10; i++) {
            System.out.println(N + " x " + i + " = " + N*i);
        }
    }
}
