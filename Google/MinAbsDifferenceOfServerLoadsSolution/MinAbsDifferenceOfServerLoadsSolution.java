package Algorithm.Google.MinAbsDifferenceOfServerLoadsSolution;

import Algorithm.Public.Solution.Solution;
import org.junit.Assert;

public class MinAbsDifferenceOfServerLoadsSolution extends Solution {
    @Override
    public void test() {
        int[] testcase1 = new int[]{1, 2, 3, 4, 5};
        Assert.assertTrue(minAbs(testcase1) == 1);
    }

    private int minAbs(int[] loads) {
        int len = loads.length;
        int sum = 0;

        for (int load : loads)
            sum += load;

        int target = sum / 2;

        int[][] dp = new int[target + 1][len];

        for (int i = 0; i < target + 1; i++) {
            if (i >= loads[0])
                dp[i][0] = loads[0];
        }

        for (int i = 1; i < len; i++) {
            for (int w = 0; w < target + 1; w++) {
                if (w < loads[i])
                    dp[w][i] = dp[w][i - 1];
                else
                    dp[w][i] = Math.max(dp[w][i - 1], dp[w - loads[i]][i - 1] + loads[i]);
            }
        }

        int best = dp[target][len - 1];

        return sum - 2 * best;

    }
}
