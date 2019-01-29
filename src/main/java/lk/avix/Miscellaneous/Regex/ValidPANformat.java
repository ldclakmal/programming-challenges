package lk.avix.Miscellaneous.Regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Chanaka
 */
public class ValidPANformat {

    private static boolean isValidPAN(String s) {
        if (s.length() > 10) {
            return false;
        }
        Matcher m = Pattern.compile("[A-Z][A-Z][A-Z][A-Z][A-Z][0-9][0-9][0-9][0-9][A-Z]").matcher(s);
        if (m.find()) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = Integer.parseInt(in.nextLine());
        String data[] = new String[N];

        for (int i = 0; i < N; i++) {
            String s = in.nextLine();
            System.out.println(isValidPAN(s) ? "YES" : "NO");
        }
    }
}
