package Algorithm.LintCode.Search.BreadthFirstSeach.PortalSolution;

import Algorithm.Public.Solution.Solution;
import Algorithm.Public.Utills.PrintUtills;

import java.util.LinkedList;
import java.util.Queue;

public class PortalSolution extends Solution {

    public void test()
    {
        char[][] maze = new char[][]
                {
                        {'S','E','*'},
                        {'*','*','*'},
                        {'*','*','*'}

                };

        System.out.println("The tested maze is printed below : ");

        PrintUtills.printCharArray(maze);

        int result = Portal(maze);

        System.out.println("The result is printed as  : " + result);
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

    public int[] rowStep = new int[]{0, 1, 0,  -1};

    public int[] colStep = new int[]{1, 0, -1, 0};

    public int Portal(char[][] Maze) {
        //

        int row = Maze.length;

        if (row == 0)
            return -1;

        int col = Maze[0].length;

        if (col == 0)
            return -1;

        Queue<Node> queue = new LinkedList<>();

        boolean[][] visited = new boolean[row][col];

        for ( int i = 0; i < row; i++)
        {
            for (int j = 0; j < col; j++)
            {
                if (Maze[i][j] == 'S')
                {
                    queue.add(new Node(i, j));
                    visited[i][j] = true;
                    break;
                }
            }
        }

        int steps = 0;

        while(!queue.isEmpty())
        {
            int size = queue.size();

            for (int i = 0; i < size; i++)
            {
                Node cur = queue.poll();

                int curRow = cur.x;

                int curCol = cur.y;

                if (Maze[curRow][curCol] == 'E')
                    return steps;

                for (int j = 0; j < 4; j++)
                {
                    int nextRow = curRow + rowStep[j];

                    int nextCol = curCol + colStep[j];

                    if (nextRow >= 0 && nextRow < row
                        && nextCol >= 0 && nextCol < col
                        && Maze[nextRow][nextCol] != '#'
                        && visited[nextRow][nextCol] == false)
                    {
                        queue.add(new Node(nextRow, nextCol));

                        visited[nextRow][nextCol] = true;
                    }
                }
            }

            steps++;

            if (queue.isEmpty())
                return -1;
        }

        return steps == 0 ? -1 : steps;
    }
}
