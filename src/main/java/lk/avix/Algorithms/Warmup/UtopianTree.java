package lk.avix.Algorithms.Warmup;

import java.util.Scanner;

/**
 * @author Chanaka
 */
public class UtopianTree {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t_cases = input.nextInt();
        if (t_cases >= 1 && t_cases <= 10) {
            int arr[] = new int[t_cases];
            for (int i = 0; i < t_cases; i++) {
                int temp = input.nextInt();
                if (temp >= 0 && temp <= 60) {
                    arr[i] = temp;
                } else {
                    System.out.println("Invalid Input");
                }
            }

            int height = 1;
            for (int i = 0; i < t_cases; i++) {
                if (arr[i] != 0) {
                    for (int j = 0; j < arr[i]; j++) {
                        if ((j % 2) == 0) {
                            height *= 2;
                        } else {
                            height += 1;
                        }
                    }
                }
                System.out.println(height);
                height = 1;
            }
        }
    }
}
