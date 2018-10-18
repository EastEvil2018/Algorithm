package Algorithm.LintCode.DataStructure.PriorityQueue.KthLargestElement2Solution;

import Algorithm.Public.Solution.Solution;

import java.util.PriorityQueue;

public class KthLargestElement2Solution extends Solution {
    public void test()
    {
        int[] nums = new int[]{9, 3, 2, 4, 8};

        int k = 3;

        int result = kthLargestElement2(nums, k);

        if (result == 4)
            System.out.println("Test Pass");

    }

    public int kthLargestElement2(int[] nums, int k) {
        // write your code here
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        for (int num : nums)
        {
            pq.add(num);

            if (pq.size() > k)
                pq.poll();
        }

        return pq.peek();
    }
}
