package lk.avix.practice.Java.DataStructures;

import java.util.ArrayList;
import java.util.Scanner;

public class JavaList {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(scanner.next()));
        }

        n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            String operator = scanner.next();
            int index = Integer.parseInt(scanner.next());
            if (operator.equals("Insert")) {
                int value = Integer.parseInt(scanner.next());
                list.add(index, value);
            } else {
                list.remove(index);
            }
        }

        for (int i : list) {
            System.out.print(i + " ");
        }
    }
}
