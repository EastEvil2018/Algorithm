package Algorithm.CodeSignal.ArrayQuerySolution;

import Algorithm.Public.Solution.Solution;
import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;
import org.junit.Assert;

public class ArrayQuerySolution extends Solution {
    @Override
    public void test() {
        int[] testcase = new int[]{1, 1, 2, 3, 2};
        MatrixQueryer q = new MatrixQueryer(testcase);

        Assert.assertTrue(q.query(1, 2, 1) == 1);
        Assert.assertTrue(q.query(2, 4, 2) == 2);
        Assert.assertTrue(q.query(0, 3, 1) == 2);
    }

    public class MatrixQueryer {
        int[][] matrix;

        public MatrixQueryer(int[] arr) {
            this.matrix = new int[arr.length + 1][10000];

            matrix[1][arr[0]] = 1;

            for (int i = 2; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (j == arr[i - 1]) {
                        matrix[i][j] = matrix[i - 1][j] + 1;
                    } else {
                        matrix[i][j] = matrix[i - 1][j];
                    }
                }
            }
        }

        public int query(int left, int right, int target) {

            System.out.println(matrix[right + 1][target] + " : " + matrix[left][target]);
            return matrix[right + 1][target] - matrix[left][target];
        }
    }

}
