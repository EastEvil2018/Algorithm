package Algorithm.LintCode.Search.BreadthFirstSeach.KnightShortestPath2Solution;

import Algorithm.Public.Solution.Solution;
import Algorithm.Public.Utills.PrintUtills;

import java.util.LinkedList;
import java.util.Queue;

public class KnightShortestPath2Solution extends Solution {

    public void test()
    {
        boolean[][] grid = new boolean[][]
                {
                        {false,false,false,false},
                        {false,false,false,false},
                        {false,false,false,false}
                };

        System.out.println("The tested grid is printed below : ");

        PrintUtills.printBoolean2DArray(grid);

        int step = shortestPath2(grid);

        System.out.println("The result steps is : " + step);

    }

    public class Node
    {
        public int x;

        public int y;

        public int step;

        public Node(int x, int y, int step)
        {
            this.x = x;
            this.y = y;
            this.step = step;
        }
    }

    public int[] rowStep = new int[]{1, -1, 2, -2};

    public int[] colStep = new int[]{2, 2, 1, 1};


    public int minStep = Integer.MAX_VALUE;

    public int shortestPath2(boolean[][] grid) {
        // write your code here
        int row = grid.length;

        if (row == 0)
            return -1;

        int col = grid[0].length;

        if (col == 0)
            return -1;

        Node root = new Node(0, 0, 0);

        Queue<Node> queue = new LinkedList<>();

        boolean[][] visited = new boolean[row][col];

        queue.add(root);

        visited[0][0] = true;

        while(!queue.isEmpty())
        {
            int size = queue.size();

            for (int i = 0; i < size; i++)
            {
                Node curNode = queue.poll();

                int curRow = curNode.x;

                int curCol = curNode.y;

                int curStep = curNode.step;

                if (curRow == row - 1 && curCol == col - 1)
                {
                    System.out.println("Find");
                    minStep = Math.min(minStep, curStep);
                }

                for (int j = 0; j < 4; j++)
                {
                    int nextRow = curRow + rowStep[j];

                    int nextCol = curCol + colStep[j];

                    if (nextRow >= 0 && nextRow < grid.length
                        && nextCol >= 0 && nextCol < grid[0].length
                        && grid[nextRow][nextCol] != true
                        && visited[nextRow][nextCol] == false)
                    {
                        queue.add(new Node(nextRow, nextCol, curStep + 1));

                        visited[nextRow][nextCol] = true;
                    }
                }
            }
        }


        return minStep == Integer.MAX_VALUE ? -1 : minStep;
    }
}
