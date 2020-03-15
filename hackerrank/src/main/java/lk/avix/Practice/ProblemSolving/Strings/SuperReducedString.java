package lk.avix.Practice.ProblemSolving.Strings;

import java.util.Scanner;

/**
 * @author Chanaka
 */
public class SuperReducedString {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = String.valueOf(in.nextLine());
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                s = s.substring(0, i) + s.substring(i + 2, s.length());
                i--;
            }
        }
        System.out.println(s);
    }
}
