package Algorithm.LintCode.Search.BackTracking.FactorizationSolution;

import Algorithm.Public.Solution.Solution;
import Algorithm.Public.Utills.PrintUtills;

import java.util.ArrayList;
import java.util.List;

public class FactorizationSolution extends Solution {

    public void test()
    {
        int testNum = 100;

        System.out.println("Begin Test for Factorization for " + testNum);

        PrintUtills.printListOfIntegerList(getFactors(testNum));

    }

    public List<List<Integer>> getFactors(int n) {
        // write your code here

        List<List<Integer>> result = new ArrayList<>();

        if (n <= 3)
            return result;

        dfs(result, new ArrayList<Integer>(), n, 2);

        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> candidate, int n, int start)
    {
        if (n == 1)
        {
            if (candidate.size() != 1)
                result.add(new ArrayList<Integer>(candidate));
            return;
        }

        for (int i = start; i <= Math.sqrt(n); i++)
        {
            if (n % i == 0)
            {
                candidate.add(i);

                dfs(result, candidate, n / i, i);

                candidate.remove(candidate.size() - 1);
            }
        }

        if (n >= start)
        {
            candidate.add(n);
            dfs(result, candidate, 1, n);
            candidate.remove(candidate.size() - 1);
        }
    }
}
