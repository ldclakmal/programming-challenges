package lk.avix.practice.Java.Strings;

public class JavaSubstringComparisons {

    public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";
        for (int i = 0; i <= s.length() - k; i++) {
            String temp = s.substring(i, i + k);
            if (!smallest.isEmpty()) {
                int smallestCompare = smallest.compareTo(temp);
                if (smallestCompare > 0) {
                    smallest = temp;
                }
            } else {
                smallest = temp;
            }

            int largestCompare = largest.compareTo(temp);
            if (largestCompare < 0) {
                largest = temp;
            }
        }

        return smallest + "\n" + largest;
    }
}
