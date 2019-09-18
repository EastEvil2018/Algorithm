package Algorithm.SAP.GardonCutSolution;

import Algorithm.Public.Solution.Solution;
import Algorithm.Public.Utills.PrintUtills;

import java.util.ArrayList;
import java.util.List;

public class GardonCutSolution extends Solution {

    @Override
    public void test() {
        char[][] testcase1 = new char[][]{
                {'*', '.', '*', '*'},
                {'*', '*', '.', '*'},
                {'*', '.', '*', '*'}
        };

        cutGardon(2, 2, testcase1);

        char[][] testcase2 = new char[][]{
                {'*', '*', '*'},
                {'.', '.', '*'},
                {'*', '.', '.'},
                {'*', '*', '*'}
        };

        cutGardon(1, 1, testcase2);

        char[][] testcase3 = new char[][]{
                {'*', '.', '.', '*', '*', '*'},
                {'*', '*', '*', '*', '.', '.'}
        };

        cutGardon(1, 1, testcase3);
    }

    private boolean cutGardon(int H, int V, char[][] gardon) {

        int M = gardon.length;
        int N = gardon[0].length;

        int[][] sum = new int[M][N];

        sum[0][0] = gardon[0][0] == '*' ? 1 : 0;

        for (int i = 1; i < M; i++) {
            sum[i][0] = sum[i - 1][0] + (gardon[i][0] == '*' ? 1 : 0);
        }

        for (int i = 1; i < N; i++) {
            sum[0][i] = sum[0][i - 1] + (gardon[0][i] == '*' ? 1 : 0);
        }

        for (int i = 1; i < M; i++) {
            for (int j = 1; j < N; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + (gardon[i][j] == '*' ? 1 : 0);
            }
        }

        System.out.println("The gardon is represented below : ");
        PrintUtills.printChar2DArray(gardon);
        System.out.println("Sum of flowers are printed below : ");
        PrintUtills.printInt2DArray(sum);

        if (sum[M - 1][N - 1] % ((H + 1) * (V + 1)) != 0)
            return false;

        int[] colSum = new int[N];

        colSum[0] = sum[M - 1][0];

        for (int i = 1; i < N; i++) {
            colSum[i] = sum[M - 1][i] - sum[M - 1][i - 1];
        }

        int vLinesLeft = V;

        int sumLeft = sum[M - 1][N - 1];

        int itIndex = 0;

        List<Integer> verticalLinePostions = new ArrayList<>();

        while (vLinesLeft != 0 && itIndex < N) {
            if(colSum[itIndex] > sumLeft / (vLinesLeft + 1)) {
                return false;
            } else if (colSum[itIndex] == sumLeft / (vLinesLeft + 1)) {
                verticalLinePostions.add(itIndex);
                sumLeft = sum[M - 1][N - 1] - sum[M - 1][itIndex];
                vLinesLeft--;
                itIndex++;
            } else {
                int temp = colSum[itIndex];

                while (itIndex < N && temp < sumLeft / (vLinesLeft + 1)) {
                    itIndex++;
                    temp += colSum[itIndex];
                    if (temp > sumLeft / (vLinesLeft + 1))
                        return false;
                }

                if (itIndex == N)
                    return false;

                if (temp == sumLeft / (vLinesLeft + 1)) {
                    verticalLinePostions.add(itIndex);
                    sumLeft = sum[M - 1][N - 1] - sum[M - 1][itIndex];
                    vLinesLeft--;
                    itIndex++;
                }
            }
        }


        int[] rowSum = new int[M];

        rowSum[0] = sum[0][N - 1];

        for (int i = 1; i < M; i++) {
            rowSum[i] = sum[i][N - 1] - sum[i - 1][N - 1];
        }

        int hLinesLeft = H;

        sumLeft = sum[M - 1][N - 1];

        itIndex = 0;

        List<Integer> horizontalLinesPosition = new ArrayList<>();

        while (hLinesLeft != 0 && itIndex < M) {
            if(rowSum[itIndex] > sumLeft / (hLinesLeft + 1)) {
                return false;
            } else if (rowSum[itIndex] == sumLeft / (hLinesLeft + 1)) {
                horizontalLinesPosition.add(itIndex);
                sumLeft = sum[M - 1][N - 1] - sum[itIndex][N - 1];
                hLinesLeft--;
                itIndex++;
            } else {
                int temp = rowSum[itIndex];

                while (itIndex < M && temp < sumLeft / (hLinesLeft + 1)) {
                    itIndex++;
                    temp += rowSum[itIndex];
                    if (temp > sumLeft / (hLinesLeft + 1))
                        return false;
                }

                if (itIndex == M)
                    return false;

                if (temp == sumLeft / (hLinesLeft + 1)) {
                    horizontalLinesPosition.add(itIndex);
                    sumLeft = sum[M - 1][N - 1] - sum[itIndex][N - 1];
                    hLinesLeft--;
                    itIndex++;
                }
            }
        }

        System.out.println("The position which we put vertical lines are shown below : ");
        PrintUtills.printIntegerList(verticalLinePostions);
        System.out.println("The position which we put horizontal lines are shown below : ");
        PrintUtills.printIntegerList(horizontalLinesPosition);

        verticalLinePostions.add(N - 1);
        horizontalLinesPosition.add(M - 1);

        int unitSum = sum[horizontalLinesPosition.get(0)][verticalLinePostions.get(0)];

        for (int i = 0; i < horizontalLinesPosition.size(); i++) {
            for (int j = 0; j < verticalLinePostions.size(); j++ ) {
                int curUnitSum = sum[horizontalLinesPosition.get(i)][verticalLinePostions.get(j)];

                if (i == 0 && j == 0) {
                    continue;
                } else if (i == 0) {
                    curUnitSum -= sum[horizontalLinesPosition.get(i)][verticalLinePostions.get(j - 1)];
                } else if (j == 0) {
                    curUnitSum -= sum[horizontalLinesPosition.get(i - 1)][verticalLinePostions.get(j)];
                } else {
                    curUnitSum = curUnitSum
                            - sum[horizontalLinesPosition.get(i - 1)][verticalLinePostions.get(j)]
                            - sum[horizontalLinesPosition.get(i)][verticalLinePostions.get(j - 1)]
                            + sum[horizontalLinesPosition.get(i - 1)][verticalLinePostions.get(j - 1)];
                }

                if (curUnitSum != unitSum)
                    return false;
            }
        }


        System.out.println("Valid");

        return true;
    }
}
