package Algorithm.AppFolio.ClockDirectionSolution;

import Algorithm.Public.Solution.Solution;
import org.junit.Assert;

public class ClockDirectionSolution extends Solution {
    @Override
    public void test() {
        Assert.assertTrue(clockDirection(12, 12) == true);
        Assert.assertTrue(clockDirection(1, 3) == false);
        Assert.assertTrue(clockDirection(12, 1) == false);
        Assert.assertTrue(clockDirection(1, 12) == true);
    }

    private boolean clockDirection(int hour, int minute) {
        // for a given hour and minute whose values are from 1 - 12
        // determine whether going clockwise or anticlockwise makes the distance between two pointers shorter
        // if clockwise, return true, otherwise false
        if (hour == minute || Math.abs(hour - minute) == 6)
            return true;

        int dif = 12 - hour;
        int minFixed = (minute + dif) % 12;

        if (minFixed <= 6)
            return false;

        return true;
    }
}
