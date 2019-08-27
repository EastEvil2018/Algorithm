package Algorithm.LintCode.Sort.SearchInsertPositionSolution;

import Algorithm.Public.Solution.Solution;
import Algorithm.Public.Utills.PrintUtills;

public class SearchInsertPositionSolution extends Solution {

    public void test()
    {
        int[] A = new int[]{1, 3, 5, 6};

        int target = 5;

        System.out.println("The tested array is printed below : ");

        PrintUtills.printIntArray(A);

        System.out.println("The target is printed below : " + target);

        int result = searchInsert(A, target);

        System.out.println("The result is printed below : " + result);


    }

    public int searchInsert(int[] A, int target) {
        // write your code here

        int len = A.length;

        if (len == 0)
            return 0;

        int left = 0;

        int right = A.length - 1;

        while(left + 1 < right)
        {
            int mid = left + (right - left) / 2;

            if (A[mid] < target)
            {
                left = mid;
            } else if (A[mid] == target)
            {
                return mid;
            } else if (A[mid] > target)
            {
                right = mid;
            }
        }

        if (A[left] == target)
            return left;

        if (A[right] == target)
            return right;

        if (target < A[left])
            return left;

        if (target > A[right])
            return right + 1;

        return right;
    }
}
