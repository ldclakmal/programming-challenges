package lk.avix.Java.Introduction;

import java.util.Scanner;

/**
 * @author Chanaka
 */
public class JavaLoops {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = Integer.parseInt(in.nextLine());
        String data[] = new String[3];
        for (int i = 0; i < N; i++) {
            data = in.nextLine().split(" ");
            int a = Integer.parseInt(data[0]);
            for (int j = 0; j < Integer.parseInt(data[2]); j++) {
                a += Math.pow(2, j) * Integer.parseInt(data[1]);
                System.out.print(a + " ");
            }
        }
    }
}
