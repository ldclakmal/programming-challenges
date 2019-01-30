package lk.avix.Practice.Java.BigNumber;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @author Chanaka
 */
public class JavaBigDecimal {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s[] = new String[n + 2];
        for (int i = 0; i < n; i++) {
            s[i] = sc.next();
        }
        for (int i = 0; i < n; i++) {
            int index = i;

            for (int j = i + 1; j < n; j++) {

                BigDecimal bi2 = new BigDecimal(s[j]);
                BigDecimal bi3 = new BigDecimal(s[index]);

                if (bi2.compareTo(bi3) > 0) {
                    index = j;
                }
            }
            String smallerNumber = s[index];
            s[index] = s[i];
            s[i] = smallerNumber;

        }
        for (int i = 0; i < n; i++) {
            System.out.println(s[i]);
        }
    }

}
