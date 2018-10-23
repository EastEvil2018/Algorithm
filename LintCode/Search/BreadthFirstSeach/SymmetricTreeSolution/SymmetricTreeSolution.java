package Algorithm.LintCode.Search.BreadthFirstSeach.SymmetricTreeSolution;

import Algorithm.Public.DataStructure.TreeNode;
import Algorithm.Public.Solution.Solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SymmetricTreeSolution extends Solution {

    public void test()
    {

    }
//    DFS :
    public boolean isSymmetric(TreeNode root) {
    // Write your code here

        if (root == null)
            return true;

        List<List<String>> result = new ArrayList<>();

        result.add(new ArrayList<String>());


        dfs(result, root, 1);

        for (int i = 0; i < result.size(); i++)
        {
            if (!isValid(result.get(i)))
                return false;
        }

        return true;
    }

    private void dfs(List<List<String>> result, TreeNode root, int curLevel)
    {
        if (result.size() < curLevel)
            result.add(new ArrayList<String>());

        if (root == null)
        {
            result.get(curLevel - 1).add("#");
            return;
        } else
        {
            result.get(curLevel - 1).add(String.valueOf(root.val));
        }

        dfs(result, root.left, curLevel + 1);

        dfs(result, root.right, curLevel + 1);

        return;
    }

    private boolean isValid(List<String> result)
    {
        if (result.size() == 1)
            return true;

        int left = 0;
        int right = result.size() - 1;

        while (left < right)
        {
            if (!result.get(left).equals(result.get(right)))
                return false;

            left++;
            right--;
        }

        return true;
    }


//    BFS :
//    public boolean isSymmetric(TreeNode root) {
//        // Write your code here
//
//        if (root == null)
//            return true;
//
//        Queue<TreeNode> queue = new LinkedList<>();
//
//        queue.add(root);
//
//        while(!queue.isEmpty())
//        {
//            int size = queue.size();
//
//            List<String> level = new ArrayList<>();
//
//            for (int i = 0; i < size; i++)
//            {
//                TreeNode cur = queue.poll();
//
//                if (cur.left != null)
//                {
//                    queue.add(cur.left);
//                    level.add(String.valueOf(cur.left.val));
//                } else
//                {
//                    level.add("#");
//                }
//
//                if (cur.right != null)
//                {
//                    queue.add(cur.right);
//                    level.add(String.valueOf(cur.right.val));
//                } else
//                {
//                    level.add("#");
//                }
//            }
//
//            if (!isValid(level))
//            {
//                for (int i = 0; i < level.size(); i++)
//                {
//                    System.out.println(level.get(i) + " ");
//                }
//                return false;
//            }
//        }
//
//        return true;
//    }
//
//    private boolean isValid(List<String> level)
//    {
//        int left = 0;
//
//        int right = level.size() - 1;
//
//        while(left < right)
//        {
//            if (!level.get(left).equals(level.get(right)))
//                return false;
//
//            left++;
//            right--;
//        }
//
//        return true;
//    }
}
