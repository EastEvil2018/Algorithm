package Algorithm.LintCode.Search.BreadthFirstSeach.CanReachTheEndPoint;

import Algorithm.Public.Solution.Solution;
import Algorithm.Public.Utills.PrintUtills;

import java.util.LinkedList;
import java.util.Queue;

public class CanReachTheEndPointSolution extends Solution {

    public void test()
    {
        int[][] grid = new int[][]
                {
                        {1, 1, 1},
                        {1, 1, 1},
                        {1, 1, 9}
                };

        System.out.println("The grid is printed below : ");

        PrintUtills.printInt2DArray(grid);

        boolean result = reachEndpoint(grid);

        System.out.println("The result is printed as : " + result);
    }

//  DFS :
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

    public boolean reachEndpoint(int[][] map) {
        // Write your code here

        // DFS

        int row = map.length;

        if (row == 0)
            return false;

        int col = map[0].length;

        if (col == 0)
            return false;

        boolean[][] visited = new boolean[row][col];

        return dfs(map, 0, 0, visited);
    }


    private boolean dfs(int[][] map, int row, int col, boolean[][] visited)
    {
        if (map[row][col] == 9)
            return true;

        visited[row][col] = true;

        for (int i = 0; i < 4; i++)
        {
            int nextRow = row + rowStep[i];

            int nextCol = col + colStep[i];

            if (nextRow >= 0 && nextRow < map.length
                    && nextCol >= 0 && nextCol < map[0].length
                    && map[nextRow][nextCol] != 0 && visited[nextRow][nextCol] == false)
            {
                if (dfs(map, nextRow, nextCol, visited))
                    return true;
            }
        }

        return false;
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
//            this.y = y;
//        }
//    }
//
//    public int[] rowStep = new int[]{0, 1, 0, -1};
//
//    public int[] colStep = new int[]{1, 0, -1, 0};
//
//    public boolean reachEndpoint(int[][] map) {
//        // Write your code here
//
//        int row = map.length;
//
//        if (row == 0)
//            return false;
//
//        int col = map[0].length;
//
//        if (col == 0)
//            return false;
//
//        Queue<Node> queue = new LinkedList<>();
//
//        boolean[][] visited = new boolean[row][col];
//
//        Node root = new Node(0, 0);
//
//        queue.add(root);
//
//        visited[0][0] = true;
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
//                if (map[curRow][curCol] == 9)
//                    return true;
//
//                for (int j = 0; j < 4; j++)
//                {
//                    int nextRow = curRow + rowStep[j];
//
//                    int nextCol = curCol + colStep[j];
//
//                    if (nextRow >= 0 && nextRow < row
//                        && nextCol >= 0 && nextCol < col
//                        && map[nextRow][nextCol] != 0
//                        && visited[nextRow][nextCol] == false)
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
}
