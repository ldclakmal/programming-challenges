/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java.Introduction;

import java.util.Scanner;

/**
 *
 * @author Chanaka
 */
public class JavaEndoffile {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = 0;
        while (in.hasNextLine()) {
            count++;
            System.out.println(count + " " + in.nextLine());
        }
    }
}
