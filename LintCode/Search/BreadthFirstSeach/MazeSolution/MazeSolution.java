package Algorithm.LintCode.Search.BreadthFirstSeach.MazeSolution;

import Algorithm.Public.Solution.Solution;
import Algorithm.Public.Utills.PrintUtills;

import java.util.LinkedList;
import java.util.Queue;

public class MazeSolution extends Solution {

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

        boolean result = hasPath(maze, start, destination);

        System.out.println("The result is printed below : " + result);

    }

//    DFS :
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

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        // write your code here

        // Let us try DFS Version
        int row = maze.length;

        if (row == 0)
            return false;

        int col = maze[0].length;

        if (col == 0)
            return false;

        return dfs(maze, new Node(start[0], start[1]), new Node(destination[0], destination[1]), new boolean[row][col]);

    }

    private boolean dfs(int[][] maze, Node start, Node destination, boolean[][] visited)
    {
        if (start.x == destination.x && start.y == destination.y)
        {
            return true;
        }

        visited[start.x][start.y] = true;

        for (int i = 0; i < 4; i++)
        {
            int nextRow = start.x;

            int nextCol = start.y;

            while(isValid(nextRow + rowStep[i], nextCol + colStep[i], maze))
            {
                nextRow += rowStep[i];

                nextCol += colStep[i];
            }

            if (visited[nextRow][nextCol] == false)
            {
                if (dfs(maze, new Node(nextRow, nextCol), destination, visited))
                    return true;
            }
        }

        return false;
    }

    private boolean isValid(int row, int col, int[][] maze)
    {
        return (row >= 0 && row < maze.length && col >= 0 && col < maze[0].length && maze[row][col] == 0);
    }


//    BFS :
//    public class Node
//    {
//        public int x;
//        public int y;
//
//        public Node(int x, int y)
//        {
//            this.x = x;
//
//            this.y = y;
//        }
//    }
//
//    public int[] rowStep = new int[]{0, 1, 0, -1};
//
//    public int[] colStep = new int[]{1, 0, -1, 0};
//
//    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
//        // write your code here
//
//        int row = maze.length;
//
//        if (row == 0)
//            return false;
//
//        int col = maze[0].length;
//
//        if (col == 0)
//            return false;
//
//        Queue<Node> queue = new LinkedList<>();
//
//        boolean[][] visited = new boolean[row][col];
//
//        Node root = new Node(start[0], start[1]);
//
//        queue.add(root);
//
//        visited[start[0]][start[1]] = true;
//
//        while(!queue.isEmpty())
//        {
//            int size = queue.size();
//
//            for (int i = 0; i < size; i++)
//            {
//                Node cur = queue.poll();
//
//                int curRow = cur.x;
//
//                int curCol = cur.y;
//
//
//                if (curRow == destination[0] && curCol == destination[1])
//                    return true;
//
//                for (int j = 0; j < 4; j++)
//                {
//                    int nextRow = curRow;
//
//                    int nextCol = curCol;
//
//                    while(isValid(nextRow + rowStep[j], nextCol + colStep[j], maze))
//                    {
//                        nextRow += rowStep[j];
//
//                        nextCol += colStep[j];
//                    }
//
//
//                    if (visited[nextRow][nextCol] == false)
//                    {
//                        queue.add(new Node(nextRow, nextCol));
//
//                        visited[nextRow][nextCol] = true;
//                    }
//                }
//            }
//        }
//
//        return false;
//    }
//
//    private boolean isValid(int row, int col, int[][] maze)
//    {
//        return (row >= 0 && row < maze.length && col >= 0 && col < maze[0].length && maze[row][col] == 0);
//    }

}
