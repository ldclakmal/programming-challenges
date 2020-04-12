package lk.avix.Practice.Java.Strings;

import java.util.Scanner;

public class JavaStringsIntroduction {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        String B = sc.next();
        System.out.println(A.length() + B.length());
        System.out.println(A.codePointAt(0) > B.codePointAt(0) ? "Yes" : "No");
        System.out.println(A.substring(0, 1).toUpperCase() + A.substring(1) + " " +
                                   B.substring(0, 1).toUpperCase() + B.substring(1));
    }
}
