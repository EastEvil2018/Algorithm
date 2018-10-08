package Algorithm.LintCode.Search.BackTracking.TowerOfHanoiSolution;

import Algorithm.Public.Solution.Solution;

import java.util.ArrayList;
import java.util.List;

public class TowerOfHanoiSolution extends Solution {

    public void test()
    {
        int num = 3;

        System.out.println("Test For " + num);

        towerOfHanoi(num);

    }

    public List<String> towerOfHanoi(int n) {
        // write your code here

        List<String> result = new ArrayList<>();

        helper(result, n, 'A', 'C', 'B');

        return result;
    }


    public void helper(List<String> result, int num, char from, char to, char mid)
    {
        if (num == 1)
        {
            String output = "from " + from + " " + "to " + to;
            System.out.println(output);
            result.add(output);
            return;
        }

        helper(result, num - 1, from, mid, to);
        String output = "from " + from + " " + "to " + to;
        System.out.println(output);
        result.add(output);
        helper(result, num - 1, mid, to, from);
    }

}
