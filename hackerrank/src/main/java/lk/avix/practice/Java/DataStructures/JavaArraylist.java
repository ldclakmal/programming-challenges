package lk.avix.practice.Java.DataStructures;

import java.util.ArrayList;
import java.util.Scanner;

public class JavaArraylist {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<ArrayList<Integer>> listOfLists = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int lineCount = Integer.parseInt(scanner.next());
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < lineCount; j++) {
                list.add(Integer.parseInt(scanner.next()));
            }
            listOfLists.add(list);
        }

        n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(scanner.next()) - 1;
            int y = Integer.parseInt(scanner.next()) - 1;
            if (listOfLists.size() > x) {
                ArrayList<Integer> list = listOfLists.get(x);
                if (list.size() > y) {
                    System.out.println(list.get(y));
                } else {
                    System.out.println("ERROR!");
                }
            } else {
                System.out.println("ERROR!");
            }
        }
    }
}
