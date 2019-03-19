package Algorithm.HackerRank.Mathworks.BuildOfficeSolution;

import Algorithm.Public.Solution.Solution;
import Algorithm.Public.Utills.PrintUtills;
import org.junit.Assert;

import java.util.Arrays;

public class BuildOfficeSolution extends Solution {
    @Override
    public void test() {
        Assert.assertTrue(buildOffice(4, 4, 3) == 18);
    }

    public int minDistance = Integer.MAX_VALUE;
    public int buildOffice(int width,
                           int height,
                           int num) {

        int[][] grid = new int[width][height];

        for (int i = 0; i < width; i++) {
            Arrays.fill(grid[i], Integer.MAX_VALUE - 1);
        }

        grid[0][0] = 0;

        dfs(grid, 0, 0, num - 1);

        grid[0][0] = Integer.MAX_VALUE - 1;

        dfs(grid, 0, 0, num);

        return minDistance;
    }

    private int[][] copyGrid(int[][] grid) {
        int rowSize = grid.length;
        int colSize = grid[0].length;
        int[][] copy = new int[rowSize][colSize];
        for (int row = 0; row < rowSize; row++) {
            for (int col = 0; col < colSize; col++) {
                copy[row][col] = grid[row][col];
            }
        }

        return copy;
    }

    private void dfs(int[][] grid,
                     int curRow,
                     int curCol,
                     int restNum) {
        if (restNum == 0) {
            int distance = calDistance(copyGrid(grid));
            if (distance < minDistance) {
                PrintUtills.printInt2DArray(grid);
                System.out.println(distance);
                minDistance = distance;
            }
            return;
        }
        int rowSize = grid.length;
        int colSize = grid[0].length;

        for (int row = curRow; row < rowSize; row++) {
            for (int col = curCol + 1; col < colSize; col++) {
                grid[row][col] = 0;

                dfs(grid, row, col, restNum - 1);

                grid[row][col] = Integer.MAX_VALUE - 1;
            }
        }
    }

    private int calDistance(int[][] grid) {
        int dist = 0;
        //PrintUtills.printInt2DArray(grid);
        int rowSize = grid.length;
        int colSize = grid[0].length;

        for (int row = 0; row < rowSize; row++) {
            for (int col = 0; col < colSize; col++) {
                if (row > 0)
                    grid[row][col] = Math.min(grid[row][col], grid[row - 1][col] + 1);
                if (col > 0)
                    grid[row][col] = Math.min(grid[row][col], grid[row][col - 1] + 1);
            }
        }

        for (int row = rowSize - 1; row >= 0; row--) {
            for (int col = colSize - 1; col >= 0; col--) {
                if (row < rowSize - 1)
                    grid[row][col] = Math.min(grid[row][col], grid[row + 1][col] + 1);
                if (col < colSize - 1)
                    grid[row][col] = Math.min(grid[row][col], grid[row][col + 1] + 1);

                dist += grid[row][col];
            }
        }

        return dist;
    }
}
