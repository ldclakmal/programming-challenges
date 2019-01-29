/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java.BigNumber;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author Chanaka
 */
public class JavaBigInteger {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();

        BigInteger bigA = new BigInteger(a);
        BigInteger bigB = new BigInteger(b);

        BigInteger bigSum = bigA.add(bigB);
        BigInteger bigProduct = bigA.multiply(bigB);

        System.out.println(bigSum);
        System.out.println(bigProduct);
    }
}
