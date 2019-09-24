package Algorithm.Google.WateringFlowersSolution;

import Algorithm.Public.Solution.Solution;
import org.junit.Assert;

public class WateringFlowersSolution extends Solution {
    @Override
    public void test() {
        int[] testcase1 = new int[]{2, 4, 5, 1, 2};
        Assert.assertTrue(wateringFlowers(testcase1, 6) == 17);
        int[] testcase2 = new int[]{1, 1, 2};
        Assert.assertTrue(wateringFlowers(testcase2, 3) == 7);
    }

    private int wateringFlowers(int[] flowers, int capacity) {
        int steps = 0;

        int curCapacity = capacity;

        for (int i = 0; i < flowers.length; i++) {
            if (flowers[i] > capacity)
                return -1;

            if (flowers[i] > curCapacity) {
                steps += 2 * i;
                curCapacity = capacity;
            }
            curCapacity -= flowers[i];
            steps++;
        }

        return steps;
    }
}
