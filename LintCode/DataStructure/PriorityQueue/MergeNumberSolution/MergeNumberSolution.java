package Algorithm.LintCode.DataStructure.PriorityQueue.MergeNumberSolution;

import Algorithm.Public.Solution.Solution;
import Algorithm.Public.Utills.PrintUtills;

import java.util.PriorityQueue;

public class MergeNumberSolution extends Solution {

    public void test()
    {
        int[] numbers = new int[]{1, 2, 3, 4};

        System.out.println("The test numbers array is printed below : ");

        PrintUtills.printIntArray(numbers);

        int result = mergeNumber(numbers);

        System.out.println("The result is printed below : " + result);

    }

    public int mergeNumber(int[] numbers) {
        // Write your code here

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int len = numbers.length;

        for (int i = 0; i < len; i++)
        {
            pq.add(numbers[i]);
        }

        int count = 0;

        while(pq.size() >= 2)
        {
            int a = pq.poll();

            int b = pq.poll();

            count = count + a + b;

            int c = a + b;

            pq.add(c);
        }

        return count;
    }
}
