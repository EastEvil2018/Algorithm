package Algorithm.LintCode.DataStructure.PriorityQueue.MedianOfKSortedArraysSolution;

import Algorithm.Public.Solution.Solution;
import Algorithm.Public.Utills.PrintUtills;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianOfKSortedArraysSolution extends Solution {
    public void test()
    {
        int[][] nums = new int[][]
                {
                        {1},
                        {2},
                        {3}
                };

        System.out.println("The tested K arrays is printed below : ");

        PrintUtills.printInt2DArray(nums);

        System.out.println("The tested result is printed below : ");

        double result = findMedian(nums);

        System.out.println(result);
    }

    public class Pack
    {
        int val, col, row;

        public Pack(int val, int col, int row)
        {
            this.val = val;

            this.col = col;

            this.row = row;
        }
    }

    public class PackComparator implements Comparator<Pack>
    {
        public int compare(Pack p1, Pack p2)
        {
            return p1.val - p2.val;
        }
    }
    public double findMedian(int[][] nums) {
        // write your code here
        double result = 0;

        int K = nums.length;

        if (K == 0)
            return result;

        PriorityQueue<Pack> pq = new PriorityQueue<Pack>(K, new PackComparator());

        int count = 0;

        for (int i = 0; i < K; i++)
        {
            int[] curArr = nums[i];

            if (curArr.length == 0)
                continue;

            Pack curPack = new Pack(curArr[0], i, 0);

            pq.add(curPack);

            count += curArr.length;

        }

        if (count == 0)
            return result;

        int median = 0;

        if (count % 2 == 0)
        {
            median = count / 2;
        } else if (count % 2 == 1)
        {
            median = count / 2 + 1;
        }

        int prevMedian = 0;

        int afterMedian = 0;

        for (int i = 0; i < median; i++)
        {
            Pack curPack = pq.poll();

            int curCol = curPack.col;

            int curRow = curPack.row;

            if (curRow < nums[curCol].length - 1)
            {
                Pack nextPack = new Pack(nums[curCol][curRow + 1], curCol, curRow + 1);
                pq.add(nextPack);
            }

            prevMedian = curPack.val;
        }

        if (count % 2 == 0)
        {
            afterMedian = pq.poll().val;
            result = prevMedian / 2.0 + afterMedian / 2.0;
        } else {
            result = prevMedian;
        }

        return (double) result;
    }
}
