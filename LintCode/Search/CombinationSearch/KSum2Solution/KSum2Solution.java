package Algorithm.LintCode.Search.CombinationSearch.KSum2Solution;

import Algorithm.Public.Solution.Solution;
import Algorithm.Public.Utills.PrintUtills;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KSum2Solution extends Solution {
    public void test()
    {
        int[] A = new int[]{1, 2, 3, 4};

        int k = 2;

        int target = 5;

        System.out.println("The tested nums array is printed below : ");

        PrintUtills.printIntArray(A);

        System.out.println("The k is printed below : " + k);

        System.out.println("The target is printed below : " + target);

        List<List<Integer>> result = kSumII(A, k, target);

        System.out.println("The tested result is printed below : ");

        PrintUtills.printListOfIntegerList(result);

    }

    public List<List<Integer>> kSumII(int[] A, int k, int target) {
        // write your code here

        List<List<Integer>> result = new ArrayList<>();

        if (k == 0)
            return result;

        int len = A.length;

        boolean[] visited = new boolean[len];

        Arrays.sort(A);

        dfs(result, new ArrayList<Integer>(), visited, k, target, A, 0);

        return result;
    }

    private void dfs(
            List<List<Integer>> result,
            List<Integer> candidate,
            boolean[] visited,
            int k,
            int target,
            int[] nums,
            int startIndex
    )
    {
        if (candidate.size() == k)
        {
            if (target == 0)
            {
                result.add(new ArrayList<Integer>(candidate));
            }

            return;
        }

        for (int i = startIndex; i < nums.length; i++)
        {
            if (visited[i])
                continue;
            if (i != 0 && nums[i] == nums[i - 1] && visited[i] == false)
                continue;

            if (nums[i] > target)
                break;

            candidate.add(nums[i]);

            visited[i] = true;

            dfs(result, candidate, visited, k, target - nums[i], nums, i + 1);

            visited[i] = false;

            candidate.remove(candidate.size() - 1);


        }
    }
}
