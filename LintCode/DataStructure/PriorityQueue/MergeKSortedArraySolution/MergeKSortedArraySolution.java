package Algorithm.LintCode.DataStructure.PriorityQueue.MergeKSortedArraySolution;

import Algorithm.Public.Solution.Solution;
import Algorithm.Public.Utills.PrintUtills;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedArraySolution extends Solution {

    public void test()
    {

        int[][] nums = new int[][]
                {
                        {1, 3, 5, 7},
                        {2, 4, 6},
                        {0, 8, 9, 10, 11}
                };

        System.out.println("The test array is printed below : ");

        PrintUtills.printInt2DArray(nums);

        int[] result = mergekSortedArrays(nums);

        System.out.println("The result is printed below : ");

        PrintUtills.printIntArray(result);


    }

    public class Pack
    {
        public int val, row, col;
        public Pack(int val, int row, int col)
        {
            this.val = val;
            this.row = row;
            this.col = col;
        }
    }

    public class PackComparator implements Comparator<Pack>
    {
        public int compare(Pack p1, Pack p2)
        {
            return (p1.val - p2.val);
        }
    }

    public int[] mergekSortedArrays(int[][] arrays) {
        // write your code here


        int K = arrays.length;

        if(K == 0)
            return new int[0];

        PriorityQueue<Pack> pq = new PriorityQueue<Pack>(K, new PackComparator());

        int count = 0;

        for (int i = 0; i < K; i++)
        {
            int len = arrays[i].length;

            if (len == 0)
                continue;

            count += len;

            Pack cur = new Pack(arrays[i][0], i, 0);

            pq.add(cur);
        }
        int[] result = new int[count];

        int index = 0;

        while(!pq.isEmpty())
        {
            Pack cur = pq.poll();

            int curRow = cur.row;

            int curCol = cur.col;

            result[index++] = cur.val;

            if (curCol < arrays[curRow].length - 1)
            {
                cur.val = arrays[curRow][curCol + 1];
                cur.col = cur.col + 1;
                pq.add(cur);
            }
        }

        return result;

    }
}
