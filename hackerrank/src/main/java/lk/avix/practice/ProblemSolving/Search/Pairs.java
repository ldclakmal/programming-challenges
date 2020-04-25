package lk.avix.practice.ProblemSolving.Search;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Chanaka
 */
public class Pairs {

    static int pairs(ArrayList a, int k) {
        /* Complete this function */
        int count = 0;
        for (int j = 0; j < a.size(); j++) {
            if (a.subList(j, a.size() - 1).contains((int) a.get(j) + k)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;

        String n = in.nextLine();
        String[] n_split = n.split(" ");

        int _a_size = Integer.parseInt(n_split[0]);
        int _k = Integer.parseInt(n_split[1]);

        ArrayList arr_list = new ArrayList();
        int _a_item;
        String next = in.nextLine();
        String[] next_split = next.split(" ");

        for (int _a_i = 0; _a_i < _a_size; _a_i++) {
            _a_item = Integer.parseInt(next_split[_a_i]);
            arr_list.add(_a_item);
        }

        res = pairs(arr_list, _k);
        System.out.println(res);
    }
}
