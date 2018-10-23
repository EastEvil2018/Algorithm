package Algorithm.LintCode.Search.BreadthFirstSeach.Maze2Solution;

import Algorithm.Public.Solution.Solution;
import Algorithm.Public.Utills.PrintUtills;

import java.util.LinkedList;
import java.util.Queue;

public class Maze2Solution extends Solution {

    public void test()
    {
        int[][] maze = new int[][]
                {
                        {0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0},
                        {0, 0, 0, 1, 0},
                        {1, 1, 0, 1, 1},
                        {0, 0, 0, 0, 0}
                };

        int[] start = new int[]{0, 4};

        int[] destination = new int[]{4, 4};

        System.out.println("The tested maze is printed below : ");

        PrintUtills.printInt2DArray(maze);

        System.out.println("The start point is printed below : ");

        PrintUtills.printIntArray(start);

        System.out.println("The destination point is printed below : ");

        PrintUtills.printIntArray(destination);

        int result = shortestDistance(maze, start, destination);

        System.out.println("The shortest distance is printed below : " + result);
    }

    public class Ball{

        public int x;

        public int y;

        public int steps;

        public Ball(int x, int y, int steps)
        {
            this.x = x;

            this.y = y;

            this.steps = steps;
        }
    }

    public int[] rowStep = new int[]{0, -1, 0, 1};

    public int[] colStep = new int[]{1, 0, -1, 0};

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        // write your code here

        int row = maze.length;

        if (row == 0)
            return -1;

        int col = maze[0].length;

        if (col == 0)
            return -1;

        Ball root = new Ball(start[0], start[1], 0);

        Queue<Ball> queue = new LinkedList<>();


        boolean[][] visited = new boolean[row][col];

        queue.add(root);

        visited[start[0]][start[1]] = true;

        while(!queue.isEmpty())
        {
            int size = queue.size();

            for (int i = 0; i < size; i++)
            {
                Ball cur = queue.poll();

                int curRow = cur.x;

                int curCol = cur.y;

                int curStep = cur.steps;

                if (curRow == destination[0] && curCol == destination[1])
                    return curStep;

                for (int j = 0; j < 4; j++)
                {
                    int nextRow = curRow;

                    int nextCol = curCol;

                    int nextStep = curStep;

                    while (isValid(nextRow + rowStep[j], nextCol + colStep[j], maze))
                    {
                        nextRow += rowStep[j];

                        nextCol += colStep[j];

                        nextStep++;
                    }

                    if (visited[nextRow][nextCol] == false)
                    {
                        Ball next = new Ball(nextRow, nextCol, nextStep);

                        queue.add(next);

                        visited[nextRow][nextCol] = true;
                    }
                }
            }
        }

        return -1;
    }

    private boolean isValid(int row, int col, int[][] maze)
    {
        return (row >= 0 && row < maze.length && col >= 0 && col < maze[0].length && maze[row][col] == 0);
    }
}
