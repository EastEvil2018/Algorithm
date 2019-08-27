package Algorithm.LintCode.Search.BreadthFirstSeach.WallsAndGatesSolution;

import Algorithm.Public.Solution.Solution;
import Algorithm.Public.Utills.PrintUtills;

import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGatesSolution extends Solution {

    public void test()
    {
        int INF = 2147483647;

        int[][] grid = new int[][]
                {
                        {INF,  -1,  0,  INF},
                        {INF, INF, INF,  -1},
                        {INF,  -1, INF,  -1},
                        {0,  -1, INF, INF}
                };

        System.out.println("The tested grid is printed below : ");

        PrintUtills.printInt2DArray(grid);

        wallsAndGates(grid);

        System.out.println("The result is printed below : ");

        PrintUtills.printInt2DArray(grid);
    }

    public class Node
    {
        public int x;

        public int y;

        public Node(int x, int y)
        {
            this.x = x;

            this.y = y;
        }
    }

    public int[] rowStep = new int[]{0, 1, 0, -1};

    public int[] colStep = new int[]{1, 0, -1, 0};

    public void wallsAndGates(int[][] rooms) {
        // write your code here

        int row = rooms.length;

        if (row == 0)
            return;

        int col = rooms[0].length;

        if (col == 0)
            return;



        Queue<Node> queue = new LinkedList<>();

        boolean[][] visited = new boolean[row][col];

        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < col; j++)
            {
                if (rooms[i][j] == 0)
                {
                    queue.add(new Node(i, j));
                    visited[i][j] = true;
                }
            }
        }

        int distance = 0;

        while(!queue.isEmpty())
        {
            int size = queue.size();

            distance++;

            for (int i = 0; i < size; i++)
            {
                Node cur = queue.poll();

                int curRow = cur.x;

                int curCol = cur.y;

                for (int j = 0; j < 4; j++)
                {
                    int nextRow = curRow + rowStep[j];

                    int nextCol = curCol + colStep[j];


                    if (nextRow >= 0 && nextRow < row
                            && nextCol >= 0 && nextCol < col)
                    {
                        if (visited[nextRow][nextCol] == true)
                            continue;

                        if (rooms[nextRow][nextCol] == -1)
                            continue;

                        if (rooms[nextRow][nextCol] == 2147483647)
                        {
                            rooms[nextRow][nextCol] = distance;

                            queue.add(new Node(nextRow, nextCol));

                            visited[nextRow][nextCol] = true;
                        }


                    }
                }
            }
        }


    }
}
