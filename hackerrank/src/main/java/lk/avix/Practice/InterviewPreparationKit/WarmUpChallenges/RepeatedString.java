package lk.avix.Practice.InterviewPreparationKit.WarmUpChallenges;

/**
 * https://www.hackerrank.com/challenges/repeated-string
 */
public class RepeatedString {

    public static void main(String[] args) {
        String s = "a";
        long n = 1000000000000L;
        long result = repeatedString(s, n);
        System.out.println(result);
    }

    static long repeatedString(String s, long n) {
        int countPerPart = 0;
        int length = s.length();
        char[] charArray = s.toCharArray();

        for (char c : charArray) {
            if (c == 'a') {
                countPerPart++;
            }
        }

        long noOfRepetitions = n / length;
        long remainder = n % length;

        long repetitionCount = countPerPart * noOfRepetitions;

        for (int i = 0; i < remainder; i++) {
            if (charArray[i] == 'a') {
                repetitionCount++;
            }
        }

        return repetitionCount;
    }
}
