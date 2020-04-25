package lk.avix.practice.Java.Introduction;

import java.util.Scanner;

/**
 * @author Chanaka
 */
public class JavaEndOfFile {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = 0;
        while (in.hasNextLine()) {
            count++;
            System.out.println(count + " " + in.nextLine());
        }
    }
}
