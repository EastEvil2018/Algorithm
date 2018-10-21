package Algorithm.LintCode.Search.BreadthFirstSeach.ZombieInMatrixSolution;

import Algorithm.Public.Solution.Solution;
import Algorithm.Public.Utills.PrintUtills;

public class ZombieInMatrixSolution extends Solution{

    public void test()
    {

        int[][] grid = new int[][]
                {
                        {0, 1, 2, 0, 0},
                        {1, 0, 0, 2, 1},
                        {0, 1, 0, 0, 0}
                };

        System.out.println("The tested grid is printed below : ");

        PrintUtills.printInt2DArray(grid);

        int days = zombie(grid);

        System.out.println("The result is printed below : " + days);
    }

    public int[] rowStep = new int[]{0, 1, 0, -1};

    public int[] colStep = new int[]{1, 0, -1, 0};

    public int zombie(int[][] grid) {
        // write your code here

        int row = grid.length;

        if (row == 0)
            return -1;

        int col = grid[0].length;

        if (col == 0)
            return -1;

        int days = 0;

        boolean valid = false;

        while(true)
        {
            boolean[][] visited = new boolean[row][col];

            for (int i = 0; i < row; i++)
            {
                for (int j = 0; j < col; j++)
                {
                    if (grid[i][j] == 1 && visited[i][j] == false)
                    {
                        visited[i][j] = true;
                        if(bfs(grid, i, j, visited) == true)
                            valid = true;
                    }
                }
            }

            days++;

            if (allZombies(grid))
                break;

            if (valid == false)
                return -1;

            valid = false;
        }

        return days;
    }

    private boolean bfs(int[][] grid, int row, int col, boolean[][] visited)
    {
        boolean valid = false;

        for (int i = 0; i < 4; i++)
        {
            int nextRow = row + rowStep[i];

            int nextCol = col + colStep[i];

            if (nextRow >= 0 && nextRow < grid.length &&
                nextCol >= 0 && nextCol < grid[0].length &&
                grid[nextRow][nextCol] == 0 && visited[nextRow][nextCol] == false)
            {
                grid[nextRow][nextCol] = 1;

                visited[nextRow][nextCol] = true;

                valid = true;
            }
        }

        return valid;
    }

    private boolean allZombies(int[][] grid)
    {
        for (int i = 0; i < grid.length; i++)
        {
            for (int j = 0; j < grid[0].length; j++)
            {
                if (grid[i][j] == 0)
                    return false;
            }
        }

        return true;
    }

}
