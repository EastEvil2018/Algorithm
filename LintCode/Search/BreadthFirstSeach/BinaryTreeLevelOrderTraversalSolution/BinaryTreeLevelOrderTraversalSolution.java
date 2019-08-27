package Algorithm.LintCode.Search.BreadthFirstSeach.BinaryTreeLevelOrderTraversalSolution;

import Algorithm.Public.DataStructure.TreeNode;
import Algorithm.Public.Solution.Solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversalSolution extends Solution {

    public void test()
    {

    }

//    Second Solution : DFS
    public List<List<Integer>> levelOrder(TreeNode root) {
        // write your code here

        List<List<Integer>> result = new ArrayList<>();

        if (root == null)
            return result;

        int depth = depth(root);

        for (int i = 0; i < depth; i++)
        {
            List<Integer> curLevel = new ArrayList<>();

            dfs(curLevel, i, 0, root);

            result.add(curLevel);
        }

        return result;
    }

    private void dfs(List<Integer> result, int depth, int curDepth, TreeNode root)
    {
        if (curDepth > depth || root == null)
            return;

        if (curDepth == depth)
        {
            result.add(root.val);
        }

        dfs(result, depth, curDepth + 1, root.left);

        dfs(result, depth, curDepth + 1, root.right);
    }

    private int depth(TreeNode root)
    {
        if (root == null)
            return 0;

        int leftDepth = depth(root.left);

        int rightDepth = depth(root.right);

        return Math.max(leftDepth + 1, rightDepth + 1);
    }

//    First Solution : BFS
//    public List<List<Integer>> levelOrder(TreeNode root) {
//        // write your code here
//
//        List<List<Integer>> result = new ArrayList<>();
//
//        if (root == null)
//            return result;
//
//        Queue<TreeNode> queue = new LinkedList<>();
//
//        queue.add(root);
//
//        while(!queue.isEmpty())
//        {
//
//            int size = queue.size();
//
//            List<Integer> curLevel = new ArrayList<>();
//
//            for (int i = 0; i < size; i++)
//            {
//                TreeNode cur = queue.poll();
//
//                curLevel.add(cur.val);
//
//                if (cur.left != null)
//                    queue.add(cur.left);
//
//                if (cur.right != null)
//                    queue.add(cur.right);
//            }
//
//            result.add(curLevel);
//        }
//
//        return result;
//    }
}
