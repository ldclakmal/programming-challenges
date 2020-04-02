package lk.avix.Problems;

public class Q7_ReverseInteger {

    public int reverse(int x) {
        try {
            if (x > 0) {
                return Integer.parseInt(new StringBuilder(String.valueOf(x)).reverse().toString());
            }
            return Integer.parseInt(new StringBuilder(String.valueOf(x * -1)).reverse().toString()) * -1;
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
