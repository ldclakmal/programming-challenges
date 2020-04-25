package lk.avix.practice.Java.Introduction;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author Chanaka
 */
public class JavaDatatypes {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = Integer.parseInt(in.nextLine());
        while (in.hasNextLine()) {
            BigInteger number = new BigInteger(in.nextLine().trim());
            int bitLength = number.bitLength();
            System.out.println(bitLength);
            int len = bitLength / 8;
            StringBuilder output = new StringBuilder(number.toString() + " can be fitted in:\n");
            switch (len) {
                case 0:
                    output.append("* byte\n");
                case 1:
                    output.append("* short\n");
                case 2:
                case 3:
                    output.append("* int\n");
                case 4:
                case 5:
                case 6:
                case 7:
                    output.append("* long");
                    System.out.println(output);
                    break;
                default:
                    System.out.println(number.toString() + " can't be fitted anywhere.");
            }
        }
    }
}
