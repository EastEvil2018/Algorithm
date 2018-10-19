package Algorithm.LintCode.Search.BreadthFirstSeach.BinaryTreeLevelOrderTraversal2Solution;

import Algorithm.Public.DataStructure.TreeNode;
import Algorithm.Public.Solution.Solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal2Solution extends Solution{

    public void test()
    {

    }
//    Second Solution : DFS
    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        if (root == null)
            return result;

        int depth = depth(root);

        while(true)
        {
            if (depth < 1)
                break;

            List<Integer> curLevel = new ArrayList<>();

            dfs(curLevel, root, depth, 1);

            result.add(curLevel);

            depth--;
        }

        return result;
    }

    private void dfs(List<Integer> result, TreeNode root, int depth, int curDepth)
    {
        if (root == null || curDepth > depth)
            return;

        if (curDepth == depth)
            result.add(root.val);

        dfs(result, root.left, depth, curDepth + 1);

        dfs(result, root.right, depth, curDepth + 1);
    }

    private int depth(TreeNode root)
    {
        if (root == null)
            return 0;

        int leftDepth = depth(root.left);

        int rightDepth = depth(root.right);

        return 1 + Math.max(leftDepth, rightDepth);

    }
}

//    First Solution : BFS
//    public List<List<Integer>> levelOrderBottom(TreeNode root) {
//        // write your code here
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
//
//
//
//            }
//
//            result.add(0, curLevel);
//        }
//
//        return result;
//    }

