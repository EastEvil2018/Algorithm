package Algorithm.LintCode.Search.BackTracking.WordSearchSolution;

import Algorithm.Public.DataStructure.Point;
import Algorithm.Public.Solution.Solution;
import Algorithm.Public.Utills.PrintUtills;

public class WordSearchSolution extends Solution
{
    public void test()
    {
        char[][] board = new char[3][4];

        board[0] = "ABCE".toCharArray();

        board[1] = "SFCS".toCharArray();

        board[2] = "ADEE".toCharArray();

        String word = "ABCCED";

        System.out.println("Begin Test : ");

        PrintUtills.printCharArray(board);

        System.out.println("The word to be searched : " + word + "\n");

        System.out.println(exist(board, word));

    }

    public Point[] steps = new Point[4];

    public boolean exist(char[][] board, String word) {
        // write your code here

        steps[0] = new Point(0, 1);
        steps[1] = new Point(0, -1);
        steps[2] = new Point(1, 0);
        steps[3] = new Point(-1, 0);

        if (word == null || word.length() == 0)
            return true;

        int height = board.length;
        if (height == 0)
            return false;

        int width = board[0].length;
        if (width == 0)
            return false;

        for (int i = 0; i < height; i++)
        {
            for (int j = 0; j < width; j++)
            {
                if (board[i][j] == word.charAt(0)){
                    boolean[][] visited = new boolean[height][width];
                    // StringBuilder sb = new StringBuilder();
                    // sb.append(board[i][j]);
                    if (dfs(board, visited, i, j, word, 0))
                        return true;
                } else
                {
                    continue;
                }
            }
        }

        return false;
    }

    private boolean dfs(
            char[][] board,
            boolean[][] visited,
            int i,
            int j,
            String word,
            int start)
    {
        if (start == word.length())
        {
            return true;
        }

        if (!isInBound(board, i, j) || visited[i][j] == true || board[i][j] != word.charAt(start))
            return false;


        visited[i][j] = true;


        for (int k = 0; k < 4; k++)
        {
            int nextI = i + steps[k].x;
            int nextJ = j + steps[k].y;


            if (dfs(board, visited, nextI, nextJ, word, start + 1))
                return true;


        }

        visited[i][j] = false;

        return false;
    }

    private boolean isInBound(char[][] board, int i, int j)
    {
        int iLimit = board.length;

        int jLimit = board[0].length;

        return (i >= 0 && i < iLimit && j >= 0 && j < jLimit);
    }
}

