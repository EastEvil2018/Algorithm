package Algorithm.LintCode.DynamicProgramming.RangeSumQueryImmutableSolution;

import Algorithm.Public.Solution.Solution;
import Algorithm.Public.Utills.PrintUtills;

public class RangeSumQueryImmutableSolution extends Solution {
    public void test()
    {
        int[] nums = new int[] {-2, 0, 3, -5, 2, -1};

        System.out.println("The nums array is printed below : ");

        PrintUtills.printIntArray(nums);

        NumArray testObj = new NumArray(nums);

        System.out.print("The Sum Range from 0 to 2 is ");
        System.out.println(testObj.sumRange(0, 2));

        System.out.print("The Sum Range from 2 to 5 is ");
        System.out.println(testObj.sumRange(2, 5));

        System.out.print("The Sum Range from 0 to 5 is ");
        System.out.println(testObj.sumRange(0, 5));

    }

    class NumArray {

        int[] nums;
        int[] aux;

        public NumArray(int[] nums) {

            this.nums = nums;

            constructAuxilary(nums);
        }

        public int sumRange(int i, int j) {

            if (i == 0)
                return aux[j];

            return aux[j] - aux[i - 1];
        }

        private void constructAuxilary(int[] nums)
        {
            int len = nums.length;

            if (len == 0)
                return;

            aux = new int[len];

            aux[0] = nums[0];

            for (int i = 1; i < len; i++)
            {
                aux[i] = aux[i - 1] + nums[i];
            }
        }
    }
}
