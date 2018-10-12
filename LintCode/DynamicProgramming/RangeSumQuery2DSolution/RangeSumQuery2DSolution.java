package Algorithm.LintCode.DynamicProgramming.RangeSumQuery2DSolution;

import Algorithm.Public.Solution.Solution;
import Algorithm.Public.Utills.PrintUtills;

public class RangeSumQuery2DSolution extends Solution {
    public void test() {
        int[][] matrix = new int[][]
                {
                        {3, 0, 1, 4, 2},
                        {5, 6, 3, 2, 1},
                        {1, 2, 0, 1, 5},
                        {4, 1, 0, 1, 7},
                        {1, 0, 3, 0, 5}
                };

        NumMatrix testObj = new NumMatrix(matrix);

        System.out.println("The matrix is printed below : ");

        PrintUtills.printInt2DArray(matrix);

        System.out.println("The sum from [2][1] to [4][3] is :");

        System.out.println(testObj.sumRegion(2, 1, 4, 3));

        System.out.println("The sum from [1][1] to [2][2] is :");

        System.out.println(testObj.sumRegion(1, 1, 2, 2));

        System.out.println("The sum from [1][2] to [2][4] is :");

        System.out.println(testObj.sumRegion(1, 2, 2, 4));
    }


    class NumMatrix {

        int[][] matrix;

        int[][] aux;

        public NumMatrix(int[][] matrix) {

            this.matrix = matrix;

            constructAuxilary(matrix);

        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            // Take special cases

            if (row1 == 0 && col1 == 0)
                return aux[row2][col2];

            if (col1 == 0)
                return aux[row2][col2] - aux[row1 - 1][col2];

            if (row1 == 0)
                return aux[row2][col2] - aux[row2][col1 - 1];

            return aux[row2][col2] - aux[row2][col1 - 1] - aux[row1 - 1][col2] + aux[row1 - 1][col1 - 1];
        }

        private void constructAuxilary(int[][] matrix)
        {
            int rowSize = matrix.length;

            if (rowSize == 0)
                return;

            int colSize = matrix[0].length;

            if (colSize == 0)
                return;

            aux = new int[rowSize][colSize];

            for (int i = 0; i < colSize; i++)
            {
                aux[0][i] = matrix[0][i];
            }

            // Firts, column sum
            for (int i = 1; i < rowSize; i++)
            {
                for (int j = 0; j < colSize; j++)
                {
                    aux[i][j] = aux[i - 1][j] + matrix[i][j];
                }
            }

            // second, col sum

            for (int i = 0; i < rowSize; i++)
            {
                for (int j = 1; j < colSize; j++)
                {
                    aux[i][j] = aux[i][j] + aux[i][j - 1];
                }
            }

            // Then, done.
        }


    }

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
}
