package lk.avix.practice.Java.Introduction;

import java.util.Scanner;

/**
 * @author Chanaka
 */
class Solution {

    public static void main(String[] argh) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String IP = in.next();
            System.out.println(IP.matches(new JavaRegex().pattern));
        }

    }
}

public class JavaRegex {

    public static final String pattern
            = "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
            + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
            + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
            + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
}
