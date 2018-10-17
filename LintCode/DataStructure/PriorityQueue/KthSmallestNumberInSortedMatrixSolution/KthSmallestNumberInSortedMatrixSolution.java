package Algorithm.LintCode.DataStructure.PriorityQueue.KthSmallestNumberInSortedMatrixSolution;

import Algorithm.Public.Solution.Solution;
import Algorithm.Public.Utills.PrintUtills;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestNumberInSortedMatrixSolution extends Solution {

    public void test()
    {

        int k = 4;

        int[][] matrix = new int[][]
                {

                        {1 ,5 ,7},
                        {3 ,7 ,8},
                        {4 ,8 ,9}

                };

        System.out.println("The tested K is " + k);

        System.out.println("The tested matrix is printed below : ");

        PrintUtills.printInt2DArray(matrix);

        int result = kthSmallest(matrix, k);

        System.out.println("The result is : " + result);
    }

    public class Pack
    {
        int val, col, row;

        public Pack(int val, int row, int col)
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
    public int kthSmallest(int[][] matrix, int k) {
        // write your code here
        int result = 0;

        int rowSize = matrix.length;

        if (rowSize == 0)
            return result;

        int colSize = matrix[0].length;

        if (colSize == 0)
            return result;

        boolean isColSmall = colSize < rowSize;

        int N = 0;

        if (isColSmall)
            N = colSize;
        else
            N = rowSize;

        PriorityQueue<Pack> pq = new PriorityQueue<Pack>(N, new PackComparator());

        for (int i = 0; i < N; i++)
        {
            if (isColSmall)
            {
                int cur = matrix[0][i];

                Pack curPack = new Pack(cur, 0, i);

                pq.add(curPack);

            } else
            {
                int cur = matrix[i][0];

                Pack curPack = new Pack(cur, i, 0);

                pq.add(curPack);
            }
        }

        for (int i = 0; i < k; i++)
        {
            Pack curPack = pq.poll();

            int curRow = curPack.row;

            int curCol = curPack.col;

            result = curPack.val;

            if (isColSmall)
            {
                if (curRow < rowSize - 1)
                {
                    int next = matrix[curRow + 1][curCol];

                    Pack nextPack = new Pack(next, curRow + 1, curCol);

                    pq.add(nextPack);
                }
            } else
            {
                if (curCol < colSize - 1)
                {
                    int next = matrix[curRow][curCol + 1];

                    Pack nextPack = new Pack(next, curRow, curCol + 1);

                    pq.add(nextPack);
                }
            }

        }

        return result;

    }
}
