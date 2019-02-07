package lk.avix.Practice.InterviewPreparationKit.WarmUpChallenges;

/**
 * https://www.hackerrank.com/challenges/counting-valleys
 */
public class CountingValleys {

    public static void main(String[] args) {
        int n = 8;
        String s = "UDDDUDUU";
        int countOfValleys = countingValleys(n, s);
        System.out.println(countOfValleys);
    }

    static int countingValleys(int n, String s) {
        int countValleys = 0;
        int seaLevel = 0;
        boolean down = false;

        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == 'U') {
                seaLevel += 1;
                down = false;
            } else {
                seaLevel -= 1;
                down = true;
            }
            if (seaLevel == -1) {
                if (down) {
                    countValleys += 1;
                }
            }
        }

        return countValleys;
    }
}
