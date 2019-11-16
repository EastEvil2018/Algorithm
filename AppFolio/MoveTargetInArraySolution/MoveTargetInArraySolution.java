package Algorithm.AppFolio.MoveTargetInArraySolution;

import Algorithm.Public.Solution.Solution;
import Algorithm.Public.Utills.PrintUtills;
import org.junit.Assert;

public class MoveTargetInArraySolution extends Solution {
    @Override
    public void test() {
        //moveTargetInArraySolution(new int[]{3, 5, 1, 6, 2}, 5);
        moveDoubleTargetInArraySolution(new int[]{3, 5, 1, 2, 5, 5, 6, 2, 2}, 2, 5);
    }

    private int[] moveDoubleTargetInArraySolution(int[] nums, int a, int b) {
       // in array nums, move all 'a's to the begin, move all 'b's to the end
        // 3, 5, 6, 1, 2  a = 2, b = 5

        // brute force, two traverse
        int len = nums.length;

        int switchIndex = len;
        for (int i = len - 1; i >= 0; i--) {
            if (nums[i] != a) {
                switchIndex--;
                int tmp = nums[i];
                nums[i] = nums[switchIndex];
                nums[switchIndex] = tmp;
            }
        }

        switchIndex = -1;
        for (int i = 0; i < len; i++) {
            if (nums[i] != b) {
                switchIndex++;
                int tmp = nums[i];
                nums[i] = nums[switchIndex];
                nums[switchIndex] = tmp;
            }
        }

        PrintUtills.printIntArray(nums);
        return nums;
    }

    private int[] moveTargetInArraySolution(int[] a, int target) {
        // in array a, move target to the end, keep the order for other elements
        // 3, 5, 6, 1, 2 target = 5
        // we traver from begin to end, and when we meet a element which is not target,
        // we switch it with our next index
        // 3, 5, 6, 1, 2
        // 3, 5, 6, 1, 2
        // 3, 6, 5, 1, 2
        // 3, 6, 1, 5, 2
        // 3, 6, 1, 2, 5

        int len = a.length;
        int switchIndex = -1;
        for (int i = 0; i < len; i++) {
            if (a[i] != target) {
                switchIndex++;
                int temp = a[switchIndex];
                a[switchIndex] = a[i];
                a[i] = temp;
            }
        }

        PrintUtills.printIntArray(a);
        return a;
    }
}
