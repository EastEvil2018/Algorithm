package Algorithm.LintCode.Search.PermutationSearch.UniquePermutationSolution;

import Algorithm.Public.Solution.Solution;
import Algorithm.Public.Utills.PrintUtills;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class UniquePermuationSolution extends Solution {
    public void test()
    {
        int[] nums = new int[]{1, 2, 2};

        System.out.println("The tested nums is printed below : ");

        PrintUtills.printIntArray(nums);

        List<List<Integer>> result = permuteUnique(nums);

        System.out.println("The test result is printed below : ");

        PrintUtills.printListOfIntegerList(result);
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        // write your code here

        // This solution is to calculate all the permutations

        // But it wll have duplicate number.

        // In the traditional dfs solution.

        // For example, [1, 2, 2]

        // Let me draw the dfs tree.

        /*
                0
        1       2       2

    12 12     22 21   21 22

    122 122   221 212  212 221

        Actually we only need 122, 221, 212

        how to avoid duplicates?

        Well, if we can sort the arrays, and add some checks for dfs.

        That is , for the cur recursion, we don't need to recurse on the number which the previous one is the same and the previous one has been recursed.

        that is a[i] == a[i - 1] and a[i - 1] is not visited(which means already dfs back)
        */

        List<List<Integer>> result = new ArrayList<>();

        int len = nums.length;

        List<Integer> candidate = new ArrayList<>();

        Arrays.sort(nums);

        boolean[] visited = new boolean[len];

        dfs(result, candidate, visited, len, nums);

        return result;

    }

    private void dfs(
            List<List<Integer>> result,
            List<Integer> candidate,
            boolean[] visited,
            int len,
            int[] nums)
    {
        if (candidate.size() == len)
        {
            result.add(new ArrayList<Integer>(candidate));
            return;
        }

        for (int i = 0; i < len; i++)
        {
            if (visited[i])
                continue;

            if (i != 0 && nums[i] == nums[i - 1] && visited[i - 1] == false)
                continue;

            candidate.add(nums[i]);

            visited[i] = true;

            dfs(result, candidate, visited, len, nums);

            visited[i] = false;

            candidate.remove(candidate.size() - 1);
        }
    }
}
