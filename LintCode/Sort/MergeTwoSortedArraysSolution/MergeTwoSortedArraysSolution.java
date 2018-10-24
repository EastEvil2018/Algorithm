package Algorithm.LintCode.Sort.MergeTwoSortedArraysSolution;

import Algorithm.Public.Solution.Solution;
import Algorithm.Public.Utills.PrintUtills;

public class MergeTwoSortedArraysSolution extends Solution {

    public void test()
    {
        int[] A = new int[]{1, 2, 4, 5};

        int[] B = new int[]{2, 3, 4, 6};

        System.out.println("The A sorted array is printed below : ");

        PrintUtills.printIntArray(A);

        System.out.println("The B sorted array is printed below : ");

        PrintUtills.printIntArray(B);

        int[] result = mergeSortedArray(A, B);

        System.out.println("The result is printed below : ");

        PrintUtills.printIntArray(result);
    }

    public int[] mergeSortedArray(int[] A, int[] B) {
        // write your code here
        int ALen = A.length;

        int BLen = B.length;

        int startA = 0;

        int startB = 0;

        int index = 0;

        int[] result = new int[ALen + BLen];

        while (startA < ALen && startB < BLen)
        {
            if (A[startA] >= B[startB])
            {
                result[index++] = B[startB++];
            } else
            {
                result[index++] = A[startA++];
            }
        }

        if (startA < ALen)
        {
            while(startA < ALen)
            {
                result[index++] = A[startA++];
            }
        }

        if (startB < BLen)
        {
            while(startB < BLen)
            {
                result[index++] = B[startB++];
            }
        }

        return result;
    }
}
