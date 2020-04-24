package lk.avix.problems;

import java.util.HashMap;

public class Q13_RomanToInteger {

    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int num = 0;
        int prevNum = 0;
        int sum = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            num = map.get(s.charAt(i));
            sum = num >= prevNum ? sum + num : sum - num;
            prevNum = num;
        }
        return sum;
    }
}
