package Algorithm.HackerRank.WePay.ZombieClusterSolution;

import Algorithm.Public.Solution.Solution;
import Algorithm.Public.Utills.PrintUtills;
import com.sun.org.apache.bcel.internal.generic.RETURN;

import java.util.HashSet;

public class ZombieCluserSolution extends Solution {
    // Input : a 2D-matrix N * N

    // We have N zombies, and matrix gives the connections between all zombies

    // So matrix[i][i] = 1, matrix[i][j] == 1 if zombie i knows zombie j

    // Count how many unique zombie clusters in the matrix

    // Output : The count for unique zombie clusters


    @Override
    public void test() {

        int[][] matrix
                = new int[][]{
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 1, 1},
                {0, 0, 0, 1, 1}
        };

        int result = zombieCluster(matrix);

        System.out.println("The zombie matrix is shown below : ");

        PrintUtills.printInt2DArray(matrix);

        System.out.println("The unique cluster count is :");

        System.out.println(result);
    }

    public int zombieCluster(int[][] _matrix) {

        int size = _matrix.length;

        if (size < 2)
            return 0;

        int[] cluster = new int[size];

        for (int i = 0; i < size; i++)
            cluster[i] = i;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (_matrix[i][j] == 1)
                    cluster[j] = cluster[i];
            }
        }

        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < size; i++) {
            set.add(cluster[i]);
        }

        return set.size();

    }


}
