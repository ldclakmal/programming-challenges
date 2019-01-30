package lk.avix.Algorithms.Strings;

import java.util.Scanner;

/**
 * @author Chanaka
 */
public class Pangrams {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = String.valueOf(in.nextLine());
        boolean flag = true;

        for (char ch = 'A'; ch <= 'Z'; ch++) {
            if (s.indexOf(ch) < 0 && s.indexOf((char) (ch + 32)) < 0) {
                flag = false;
                break;
            }
        }

        if (flag) {
            System.out.println("pangram");
        } else {
            System.out.println("not pangram");
        }
    }
}
