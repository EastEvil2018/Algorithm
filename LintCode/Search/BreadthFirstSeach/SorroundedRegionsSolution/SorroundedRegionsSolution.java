package Algorithm.LintCode.Search.BreadthFirstSeach.SorroundedRegionsSolution;

import Algorithm.Public.Solution.Solution;
import Algorithm.Public.Utills.PrintUtills;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SorroundedRegionsSolution extends Solution {

    public void test()
    {
        char[][] board = new char[][]
                {
                        {'X', 'X', 'X', 'X'},
                        {'X', 'O', 'O', 'X'},
                        {'X', 'X', 'O', 'X'},
                        {'X', 'O', 'X', 'X'},
                };

        System.out.println("The input board is printed below : ");

        PrintUtills.printCharArray(board);

        surroundedRegions(board);

        System.out.println("The tested result is printed below : ");

        PrintUtills.printCharArray(board);


    }

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

    public int[] rowStep = new int[]{1, 0, -1, 0};

    public int[] colStep = new int[]{0, 1, 0, -1};


    public void surroundedRegions(char[][] board) {
        // write your code here

        int row = board.length;

        if (row == 0)
            return;

        int col = board[0].length;

        if (col == 0)
            return;

        // Traverse the edge

        for (int i = 0; i < row; i++)
        {
            bfs(board, i, 0);

            bfs(board, i, col - 1);
        }

        for (int i = 1; i < col - 1; i++)
        {
            bfs(board, 0, i);

            bfs(board, row - 1, i);
        }

        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < col; j++)
            {

                if (board[i][j] == 'O')
                {
                    board[i][j] = 'X';
                }

                if (board[i][j] == 'F')
                {
                    board[i][j] = 'O';
                }

            }
        }

    }

    private void bfs(char[][] board, int row, int col)
    {
        if (board[row][col] != 'O')
            return;

        Queue<Node> queue = new LinkedList<>();

        Node root = new Node(row, col);

        queue.add(root);

        while (!queue.isEmpty())
        {
            Node cur = queue.poll();

            board[cur.x][cur.y] = 'F';

            for (Node node : expand(board, cur))
            {
                queue.add(node);
            }
        }
    }

    private List<Node> expand(char[][] board, Node root)
    {
        List<Node> result = new ArrayList<>();

        int curRow = root.x;

        int curCol = root.y;

        for (int i = 0; i < 4; i++)
        {
            int nextRow = curRow + rowStep[i];

            int nextCol = curCol + colStep[i];

            if (nextRow >= 0 && nextRow < board.length
                && nextCol >= 0 && nextCol < board[0].length
                && board[nextRow][nextCol] == 'O')
            {
                board[nextRow][nextCol] = 'T';

                Node newNode = new Node(nextRow, nextCol);

                result.add(newNode);
            }
        }

        return result;
    }
}
