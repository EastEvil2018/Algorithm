package Algorithm.LintCode.Search.BreadthFirstSeach.CheckFullBinaryTreeSolution;

import Algorithm.Public.DataStructure.TreeNode;
import Algorithm.Public.Solution.Solution;

import java.util.LinkedList;
import java.util.Queue;

public class CheckFullBinaryTreeSolution extends Solution {

    public void test()
    {

    }

    public boolean isFullTree(TreeNode root) {
        // write your code here

        if (root == null)
            return true;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while(!queue.isEmpty())
        {
            int size = queue.size();

            for (int i = 0; i < size; i++)
            {
                TreeNode cur = queue.poll();

                if (cur.left == null && cur.right == null)
                    continue;

                if (cur.left != null && cur.right != null)
                {
                    queue.add(cur.left);

                    queue.add(cur.right);
                } else
                {
                    return false;
                }
            }
        }

        return true;
    }
}
