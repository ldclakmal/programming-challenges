package lk.avix.Algorithms.Implementation;

import java.util.Scanner;

/**
 * @author Chanaka
 */
public class AngryProfessor {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        for (int i = 0; i < N; i++) {
            int x = in.nextInt();
            int t = in.nextInt();
            int count = 0;
            for (int j = 0; j < x; j++) {
                if (in.nextInt() <= 0) {
                    count++;
                }
            }
            if (count < t) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
