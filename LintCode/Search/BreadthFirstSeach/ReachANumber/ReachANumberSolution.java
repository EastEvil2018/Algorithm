package Algorithm.LintCode.Search.BreadthFirstSeach.ReachANumber;

import Algorithm.Public.Solution.Solution;

public class ReachANumberSolution extends Solution {

    public void test()
    {
        int target = 3;

        System.out.println("The target is printed below : " + target);

        int result = reachNumber(target);

        System.out.println("The result is printed below : " + result);


    }

    public int reachNumber(int target) {

        target = Math.abs(target);

        int step = 1, pos = 0;

        while (pos < target) {

            pos += step;

            step++;

        }

        step--;

        if (pos == target)
            return step;

        pos -= target;

        if (pos % 2 == 0) {

            return step;

        } else if ((step + 1) % 2 == 1) {

            return step + 1;

        } else {

            return step + 2;

        }

    }
}
