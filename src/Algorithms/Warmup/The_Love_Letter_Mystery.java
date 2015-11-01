/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms.Warmup;

import java.util.Scanner;

/**
 *
 * @author Chanaka
 */
public class The_Love_Letter_Mystery {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test_cases = Integer.parseInt(sc.nextLine());
        String input[] = new String[test_cases];

        for (int i = 0; i < test_cases; i++) {
            input[i] = sc.nextLine();
        }

        int count = 0;
        int k = 0;
        for (int i = 0; i < test_cases; i++) {
            char c[] = input[i].toCharArray();

            while (isPalindrome(c) != -1) {
                k = isPalindrome(c);
                if (k == -1) {
                    break;
                } else {
                    c[k] = (char) (c[k] - 1);
                    count++;
                }
            }
            System.out.println(count);
            count = 0;
        }
    }

    public static int isPalindrome(char[] word) {
        int i = 0;
        int j = word.length - 1;
        while (j > i) {
            if (word[i] != word[j]) {
                if (word[i] > word[j]) {
                    char temp = word[j];
                    word[j] = word[i];
                    word[i] = temp;
                }
                return j;
            }
            ++i;
            --j;
        }
        return -1;
    }
}
