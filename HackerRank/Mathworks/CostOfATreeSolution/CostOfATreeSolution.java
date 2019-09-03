package Algorithm.HackerRank.Mathworks.CostOfATreeSolution;

import Algorithm.Public.Solution.Solution;
import Algorithm.Public.Utills.PrintUtills;
import org.junit.Assert;

import java.util.Arrays;

/*
The Cost of a Tree
Given an array of integers, construct a tree.
Each node of the tree has either two children or none, in which case it is a leaf node.
A leaf node costs 0 to construct.
The cost to build a parent node is the product of the maximum leaf values in its left and right sub-trees.
Partition the array to minimize the cost of building the entire tree.
For example, there are n = 3 elements in the array: arr = [4, 6, 2].
There are two possible choices to split the array: [4], [6,2) and [4, 6], [2).
The array elements can not be reordered.
Leaves are shown in green, and parent nodes are in blue.

First choice :
 24
|   \
0   12
|   |  \
4   6   2

cost = 12 + 24 = 36;

Second choice :

     12
   /    |
  24    0
/   |   |
4   6   2

cost = 24 + 12 = 36.


Working through the first choice, the left sub-tree is 4 and the right sub-tree is [6,2).
The maxima are 4 and 6, so the root node costs 4 * 6 = 24 to create.
The left node is a leaf so it has a cost of 0.
Now create leaves for [6, 2], with their parent costing 6 * 2 = 12 to construct.
The entire tree costs 24 + 12 = 36.

If the same analysis is performed on the second choice, the root node costs max({4, 6]) * 2 = 12,
and the node below that on the left costs 4 * 6 = 24.
Again, the total cost is 36.
If these were different, the minimum would be chosen. The answer is 36.
Function Description Complete the function calculateCost in the editor below.
The function must return an integer that represents the minimum cost to construct the tree.
*/

/*
Intuition :
让我们就从第一个例子出发，[4, 6, 2]
第一种情况, 选[4] [6, 2]
这个时候我们需要知道
(a) [6, 2]所构造的子树所需要的代价
(b) [6, 2]数组里的最大值
我们用一个二维数组来代表(a), cost[1][2] = 12, 1和2分别代表6和2在数组中的下标
我们用另一个二维数组来代表(b), max[1][2] = 6, 1和2分别代表6和2在数组中的下标
那么最终cost = inputs[0] * max[1][2] + cost[1][2]

那么第二种情况怎么表示？[4, 6] [2]
cost = inputs[2] * max[0, 1] + cost[0, 1]

显然，这有点像一个动态规划
如果我们选中一个叶子节点，将它左边所有节点构造成一棵最小代价树，右边所有节点构造成一颗最小代价树
那么有两种情况：
(a) 叶子节点先和左树合并，再和右树合并
(b) 叶子节点先和右树合并，再和左树合并
如果我们假定构造左子树和右子树的最小代价已知，那么可以将上述问题转为动态规划问题

我们如果规定一个范围，dp[i][j]，
我们选 k from i to j :
dp[i][j] = Math.min(dp[i][j],
                    Math.min(dp[i][k - 1] + max[i][k - 1] * inputs[k] + dp[k + 1][j] + max[i][k] * max[k + 1][j],
                             dp[i][k - 1] + inputs[k] * max[k + 1][j] + dp[k + 1][j] + max[i][k - 1] * max[k][j]));
这时候需要考虑特殊情况：
也就是当 k == i or k == j 的情况，也就是不需要三个孩子来构造树，而是只有两个孩子
(a) 当 k == i 的时候, 这个时候 k - 1 < i, 如果我们将dp[i][k - 1] = 0 and max[i][k - 1] = 0
动态方程为：
dp[i][j] = Math.min(dp[i][j],
                    Math.min(0 + 0 * inputs[k] + dp[k + 1][j] + max[i][k] * max[k + 1][j],
                             0 + inputs[k] * max[k + 1][j] + dp[k + 1][j] + 0 * max[k][j]));

dp[i][j] = Math.min(dp[i][j],
                    Math.min(dp[k + 1][j] + max[i][k] * max[k + 1][j],
                             inputs[k] * max[k + 1][j] + dp[k + 1][j] ));

由于 k == i, max[i][k] = inputs[k]
dp[i][j] = Math.min(dp[i][j],
                    Math.min(dp[k + 1][j] + inputs[k] * max[k + 1][j],
                             inputs[k] * max[k + 1][j] + dp[k + 1][j] ));
这里仔细看，你会发现 dp[k + 1][j] + inputs[k] * max[k + 1][j] == inputs[k] * max[k + 1][j] + dp[k + 1][j]
那么 动态方程就变为
dp[i][j] = Math.min(dp[i][j], dp[k + 1][j] + inputs[k] * max[k + 1][j]);
这是只用两个孩子来构造树的情况，其中 k 作为叶子节点, 用 k + 1 到 j 来预构造树

(b) 当 k == j 的时候， 这个时候 k + 1 > j， 如果我们将dp[k + 1][j] = 0 and max[k + 1][j] = 0

*/
public class CostOfATreeSolution extends Solution {
    @Override
    public void test() {
        int[] testcase1 = new int[]{6, 2, 4};
        Assert.assertTrue(costOfATree(testcase1) == 36);
    }

    public int costOfATree(int[] nums) {
        int len = nums.length;

        int[][] cost = new int[len + 2][len + 2];
        int[][] max = new int[len + 2][len + 2];
        int[] leaves = new int[len + 2];

        for (int i = 1; i < len + 1; i++) {
            leaves[i] = nums[i - 1];
        }

        for (int i = 0; i < len + 2; i++) {
            Arrays.fill(cost[i], 1000000);
            Arrays.fill(max[i], 0);
        }

        for (int i = 1; i < len + 1; i++){
            cost[i][i] = nums[i - 1];
            if (i != len)
                cost[i][i + 1] = leaves[i] * leaves[i + 1];
            max[i][i] = nums[i - 1];
        }

        for (int i = 1; i < len + 1; i++) {
            for (int j = i + 1; j < len + 1; j++) {
                max[i][j] = Math.max(max[i][j - 1], nums[j - 1]);
            }
        }

        for (int i = len - 2; i >= 1; i--) {
            for (int j = i + 1; j < len + 1; j++) {
                for (int k = i; k <= j; k++) {
                    if (k == i)
                        cost[i][k - 1] = 0;
                    if (k == j)
                        cost[k + 1][j] = 0;
                    cost[i][j] = Math.min(cost[i][j],
                                         Math.min(cost[i][k - 1] + max[i][k - 1] * leaves[k] + cost[k + 1][j] + max[i][k] * max[k + 1][j],
                                                 cost[i][k - 1] + leaves[k] * max[k + 1][j] + cost[k + 1][j] + max[i][k - 1] * max[k][j]));
                }
            }
        }

        PrintUtills.printInt2DArray(max);
        PrintUtills.printInt2DArray(cost);

        System.out.println(cost[1][len]);

        return cost[1][len];
    }
}
