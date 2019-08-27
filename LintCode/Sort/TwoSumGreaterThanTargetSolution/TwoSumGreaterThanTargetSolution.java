package Algorithm.LintCode.Sort.TwoSumGreaterThanTargetSolution;

import Algorithm.Public.Solution.Solution;
import Algorithm.Public.Utills.PrintUtills;

import java.util.Arrays;

public class TwoSumGreaterThanTargetSolution extends Solution {

    public void test()
    {
        int[] nums = new int[]{2, 7, 11, 15};

        int target = 24;

        System.out.println("The tested nums array is printed below : ");

        PrintUtills.printIntArray(nums);

        System.out.println("The target is printed as  : " + target);

        int result = twoSum2(nums, target);

        System.out.println("The result is printed as  : " + result);
    }

    public int twoSum2(int[] nums, int target) {
        // write your code here

        int len = nums.length;

        Arrays.sort(nums);

        int count = 0;

        int left = 0;

        int right = len - 1;

        while (left < right)
        {
            if (nums[left] + nums[right] <= target)
            {
                left++;
            } else
            {
                count += right - left;

                right--;
            }
        }

        return count;
    }
}
