package Algorithm.Amazon.ContructStringWithKDistinctApartSolution;

import Algorithm.Public.Solution.Solution;
import Algorithm.Public.Utills.PrintUtills;

public class ConstructStringWithKDistinctApartSolution extends Solution {

    @Override
    public void test() {
        int[] nums1 = new int[]{1, 1, 6};
        int[] nums2 = new int[]{1, 2, 3};

        System.out.println("First test case : ");
        PrintUtills.printIntArray(nums1);
        System.out.println("Result : " + construccStringWithKDistinctApart(nums1, 3));

        System.out.println("Second test case : ");
        PrintUtills.printIntArray(nums2);
        System.out.println("Result : " + construccStringWithKDistinctApart(nums2, 3));

    }

    private String construccStringWithKDistinctApart(int[] nums, int k) {
        // In this problem, k = 3
        // nums only have 3 integer, which means at most nums[0] a, nums[1] b, nums[2] c

        StringBuilder sb = new StringBuilder();

        int[] valid = new int[3];

        int maxLength = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < maxLength; i++) {
            int corresIndex = this.findIndex(nums, valid, i);
            if (corresIndex == -1)
                return sb.toString();

            sb.append((char)('a' + corresIndex));
            nums[corresIndex]--;
            valid[corresIndex] = i + k;
        }

        return sb.toString();
    }

    private int findIndex(int[] nums, int[] valid, int index) {

        int max = Integer.MIN_VALUE;
        int res = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0 && valid[i] <= index) {
                if (nums[i] > max) {
                    max = nums[i];
                    res = i;
                }

            }
        }
        return res;
    }
}
