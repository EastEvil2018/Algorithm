package Algorithm.LintCode.Sort.WiggleSort;

import Algorithm.Public.Solution.Solution;
import Algorithm.Public.Utills.PrintUtills;

public class WiggleSortSolution extends Solution {

    public void test()
    {
        int[] nums = new int[]{3, 5, 2, 1, 6, 4};

        System.out.println("The tested array is printed below : ");

        PrintUtills.printIntArray(nums);

        wiggleSort(nums);

        System.out.println("The result is printed below : ");

        PrintUtills.printIntArray(nums);
    }

    public void wiggleSort(int[] nums) {
        // write your code here

        int len = nums.length;

        if (len <= 1)
            return;

        for (int i = 0; i < len; i+=2)
        {
            if (i > 0 && nums[i] > nums[i - 1])
                swap(nums, i, i - 1);

            if (i < len - 1 && nums[i] > nums[i + 1])
                swap(nums, i, i + 1);
        }

    }

    public void swap(int[] nums, int first, int second)
    {
        int temp = nums[first];

        nums[first] = nums[second];

        nums[second] = temp;
    }
}
