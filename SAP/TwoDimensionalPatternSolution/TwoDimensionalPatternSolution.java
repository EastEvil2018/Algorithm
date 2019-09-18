package Algorithm.SAP.TwoDimensionalPatternSolution;

import Algorithm.Public.Solution.Solution;
import Algorithm.Public.Utills.PrintUtills;

import java.util.Arrays;

public class TwoDimensionalPatternSolution extends Solution {
    @Override
    public void test() {

        PrintUtills.printInt2DArray(getPattern(3));
        PrintUtills.printInt2DArray(getPattern(4));
    }

    private int[][] getPattern(int N) {
        int[][] pattern = new int[N + 1][N];

        for (int[] row : pattern)
            Arrays.fill(row, N);

        for (int i = 1; i < pattern.length; i++) {
            pattern[i][N - 2] = i;
        }

        return pattern;
    }
}
