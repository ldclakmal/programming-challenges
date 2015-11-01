/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Miscellaneous.Regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Chanaka
 */
public class HackerRankTweets {

    private static boolean isHackerRankTweet(String s) {
        Matcher m = Pattern.compile("(H|h)(A|a)(C|c)(K|k)(E|e)(R|r)(R|r)(A|a)(N|n)(K|k)").matcher(s);
        if (m.find()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = Integer.parseInt(in.nextLine());
        String data[] = new String[N];
        int count = 0;
        for (int i = 0; i < N; i++) {
            String s = in.nextLine();
            String split[] = s.split(" |#|@");
            for (int j = 0; j < split.length; j++) {
                if (isHackerRankTweet(split[j])) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
