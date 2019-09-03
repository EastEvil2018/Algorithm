package Algorithm.Amazon.RollDiceSolution;

import Algorithm.Public.Solution.Solution;

public class RollDiceSolution extends Solution {

    @Override
    public void test() {

        org.junit.Assert.assertTrue(rollDice(new int[]{1, 2, 3}) == 2);
        org.junit.Assert.assertTrue(rollDice(new int[]{1, 1, 6}) == 2);
        org.junit.Assert.assertTrue(rollDice(new int[]{1, 6, 2, 3}) == 3);
    }

    public int rollDice(int[] dices) {
        int res = 0;

        int[] counts = new int[7];

        for (int dice : dices)
            counts[7 - dice]++;

        int min = Integer.MAX_VALUE;

        for (int i = 1; i <= 6; i++) {
            int noMoveNum = counts[7 - i];
            int doubleMoveNum = counts[i];
            int singleMoveNum = dices.length - noMoveNum - doubleMoveNum;

            int total = doubleMoveNum * 2 + singleMoveNum;
            if (total < min)
                min = total;
        }

        return min;

    }
}
