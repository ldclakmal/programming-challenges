package lk.avix.Practice.ProblemSolving.Regex;

import java.util.Scanner;

/**
 * @author Chanaka
 */
public class FindHackerRank {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = Integer.parseInt(in.nextLine());
        String data[] = new String[N];

        for (int i = 0; i < N; i++) {
            data[i] = in.nextLine();
        }

        for (int i = 0; i < data.length; i++) {
            if (data[i].startsWith("hackerrank") && data[i].endsWith("hackerrank")) {
                System.out.println("0");
            } else if (data[i].startsWith("hackerrank")) {
                System.out.println("1");
            } else if (data[i].endsWith("hackerrank")) {
                System.out.println("2");
            } else {
                System.out.println("-1");
            }
        }
    }
}
