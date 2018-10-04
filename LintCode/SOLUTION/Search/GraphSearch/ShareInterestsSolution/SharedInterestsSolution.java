package Algorithm.LintCode.SOLUTION.Search.GraphSearch.ShareInterestsSolution;

import Algorithm.LintCode.SOLUTION.Solution;

import java.util.ArrayList;
import java.util.List;

public class SharedInterestsSolution implements Solution {

    int maxProduct = 0;

    int maxNumOfPairs = 0;

    public void run()
    {
        // Here we should write some test cases

        List<Integer> from = new ArrayList<Integer>();

        from.add(1);
        from.add(1);
        from.add(2);
        from.add(2);
        from.add(2);
//        from.add(4);
//        from.add(4);

        List<Integer> to = new ArrayList<Integer>();

        to.add(2);
        to.add(2);
        to.add(3);
        to.add(3);
        to.add(4);
//        to.add(5);
//        to.add(5);

        List<Integer> weights = new ArrayList<>();

        weights.add(1);
        weights.add(2);
        weights.add(1);
        weights.add(3);
        weights.add(3);
//        weights.add(1);
//        weights.add(2);

        int result = sharedInterets(4, to, from, weights);

        System.out.println(result);
    }

    public void describe()
    {
        // Here we should show some descriptions for this problem
    }

    public void explain()
    {
        // Here we should explain the solution
    }

    public int sharedInterets(int numOfNodes, List<Integer> from, List<Integer> to, List<Integer> weights)
    {

        if (numOfNodes <= 1)
            return 0;

        int len = from.size();

        if (len == 0)
            return 0;

        int[][] memo = new int[numOfNodes + 1][numOfNodes + 1];

        for (int i = 0; i < len; i++)
        {
            int fromNode = from.get(i);
            int toNode = to.get(i);

            memo[fromNode][toNode]++;

            int curPairNum = memo[fromNode][toNode];

            if (curPairNum >= maxNumOfPairs) {

                maxNumOfPairs = curPairNum;

                maxProduct = Math.max(maxProduct, fromNode * toNode);
            }
        }

        return maxProduct;
    }

}
