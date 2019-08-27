package Algorithm.LintCode.Sort.SmallestDifferenceSolution;

import Algorithm.Public.Solution.Solution;
import Algorithm.Public.Utills.PrintUtills;

import java.util.Arrays;

public class SmallestDifferenceSolution extends Solution {

    public void test()
    {
        int[] A = new int[]{3, 6, 7, 4};

        int[] B = new int[]{2, 8, 9, 4};

        System.out.println("The tested A array is printed below : ");

        PrintUtills.printIntArray(A);

        System.out.println("The tested B array is printed below : ");

        PrintUtills.printIntArray(B);

        int result = smallestDifference(A, B);

        System.out.println("The result is printed as  :  " + result);
    }

    public int smallestDifference(int[] A, int[] B) {
        // write your code here

        int aLen = A.length;

        int bLen = B.length;

        Arrays.sort(A);

        Arrays.sort(B);

        int aPointer = 0;

        int bPointer = 0;

        int min = Integer.MAX_VALUE;

        while (aPointer < aLen && bPointer < bLen)
        {
            min = Math.min(min, Math.abs(A[aPointer] - B[bPointer]));

            if (A[aPointer] < B[bPointer])
            {
                aPointer++;
            } else
            {
                bPointer++;
            }
        }

        return min;

    }
}
