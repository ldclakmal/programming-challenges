package lk.avix.Java.Introduction;

import java.util.Scanner;

/**
 * @author Chanaka
 */
public class JavaStdinandStdout2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        double y = sc.nextDouble();
        sc.nextLine();
        String s = sc.nextLine();

        System.out.println("String: " + s);
        System.out.println("Double: " + y);
        System.out.println("Int: " + x);
    }
}
