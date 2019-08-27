package Algorithm.HackerRank.WePay.SlidingWindowAverageSolution;

import Algorithm.Public.Solution.Solution;
import Algorithm.Public.Utills.PrintUtills;
import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.Queue;


/*
Like leetCode 239
Given an array nums,
there is a sliding window of size k which is moving from the very left of the array to the very right.
You can only see the k numbers in the window.
Each time the sliding window moves right by one position.
Return the average sliding window.


Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
        Output: []
        Explanation:

        Window position                Max
        ---------------               -----
        [1  3  -1] -3  5  3  6  7       1.0
        1 [3  -1  -3] 5  3  6  7       -0.3
        1  3 [-1  -3  5] 3  6  7       0.3
        1  3  -1 [-3  5  3] 6  7       1.6
        1  3  -1  -3 [5  3  6] 7       4.7
        1  3  -1  -3  5 [3  6  7]      5.3
*/
public class SlidingWindowAverageSolution extends Solution {
    @Override
    public void test() {

        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};

        int k = 3;

        System.out.println("The nums is printed below : ");

        PrintUtills.printIntArray(nums);

        float[] result = slidingWindowAverage(nums, k);

        System.out.println("The average sliding window at size " + k + " is printed below : ");

        PrintUtills.printFloatArray(result);

    }

    public float[] slidingWindowAverage(int[] nums, int k){

        int len = nums.length;

        if (len == 0)
            return new float[0];

        float[] result = new float[len - k + 1];

        int sum = 0;

        int index = 0;

        int i = 0;

        Queue<Integer> q = new LinkedList<>();

        while (index < len) {
            while (!q.isEmpty() && q.peek() < index - k + 1) {
                sum -= nums[q.poll()];
            }

            sum += nums[index];

            q.add(index);

            if (index >= k - 1) {
                float ave = (float) sum / (float) k;
                DecimalFormat newFormat = new DecimalFormat("#.##");
                ave =  Float.valueOf(newFormat.format(ave));
                result[i++] = ave;
            }

            index++;
        }

        return result;

    }
}
