package lk.avix.practice.Java.Strings;

import java.util.Scanner;

public class JavaStringReverse {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        System.out.println(isPalindrome(A) ? "Yes" : "No");
    }

    private static boolean isPalindrome(String s) {
        if (s.length() < 2) return true;
        return s.charAt(0) == s.charAt(s.length() - 1) && isPalindrome(s.substring(1, s.length() - 1));
    }
}
