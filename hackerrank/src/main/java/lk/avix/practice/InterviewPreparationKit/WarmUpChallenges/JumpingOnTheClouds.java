package lk.avix.practice.InterviewPreparationKit.WarmUpChallenges;

/**
 * https://www.hackerrank.com/challenges/jumping-on-the-clouds
 */
public class JumpingOnTheClouds {

    public static void main(String[] args) {
        int[] c = new int[]{0, 0, 1, 0, 0, 1, 0};  //4
        int noOfJumps = jumpingOnClouds(c);
        System.out.println(noOfJumps);
    }

    static int jumpingOnClouds(int[] c) {
        int noOfJumps = -1;

        for (int i = 0; i < c.length; i++) {
            noOfJumps += 1;
            if (i + 2 < c.length) {
                if (c[i + 2] == 0) {
                    i += 1;
                }
            }
        }
        return noOfJumps;
    }
}
