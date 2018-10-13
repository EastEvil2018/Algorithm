package Algorithm;

import Algorithm.LintCode.DataStructure.LinkedList.DeleteGreaterNodesSolution.DeleteGreaterNodesSolution;
import Algorithm.LintCode.DataStructure.Trie.WordSquaresSolution.WordSquaresSolution;
import Algorithm.LintCode.DynamicProgramming.RangeSumQuery2DSolution.RangeSumQuery2DSolution;
import Algorithm.LintCode.DynamicProgramming.RangeSumQueryImmutableSolution.RangeSumQueryImmutableSolution;
import Algorithm.LintCode.Search.BackTracking.FactorizationSolution.FactorizationSolution;
import Algorithm.LintCode.Search.BackTracking.FindMissingNumber2Solution.FindMissingNumber2Solution;
import Algorithm.LintCode.Search.BackTracking.PalindromePermutation2Solution.PalindromePermutation2Solution;
import Algorithm.LintCode.Search.BackTracking.TowerOfHanoiSolution.TowerOfHanoiSolution;
import Algorithm.LintCode.Search.BackTracking.WordSearchSolution.WordSearchSolution;
import Algorithm.LintCode.Sort.HouseRankingSolution.HouseRankingSolution;
import Algorithm.Public.Solution.Solution;

public class Analyzer {

    public static void main(String [] args){

        /*
        Example to run any one of the problem solution
         */

        Solution sol = new DeleteGreaterNodesSolution();

        sol.run();

        /*
        Expected OutPut :

        Description.txt:

        @Implementation
        public Node deleteGreaterNodes(Node head, int val)

        @Param
        head : The head of a Linked List
        val : An Integer

        @Requirement
        Delete all the nodes which value is greater than val, return the head of the modified linked list.

        Test:

        Before Testing:

        The Linked List is printed below :
        0->8->19->9->19->5->19->12->14->null

        The value : 6

        After Testing:

        The Linked List is printed below :
        0->5->null

        Explanation:

        Iterating over the whole linked list, keep track on the curNode and previous Node.

        If curNode.val > val, connect previousNode to curNode.next, continue, until curNode == null.

        Time Complexity : O(n)

        Space Complexity : O(1)
        */


//        Solution mis = new MergeIntervalsSolution();
//
//        mis.run();
//
//        Solution vas = new ValidAnagramSolution();
//
//        vas.run();

//        Solution wss = new WordSearchSolution();
//
//        wss.run();

//          Solution tohs = new TowerOfHanoiSolution();
//
//          tohs.run();

//        Solution fs = new FactorizationSolution();
//        fs.run();

//          Solution fmn2s = new FindMissingNumber2Solution();
//
//          fmn2s.run();

//        Solution hrs = new HouseRankingSolution();
//
//        hrs.run();

//          Solution wss = new WordSquaresSolution();
//
//          wss.run();

//          Solution rsq2s = new RangeSumQuery2DSolution();
//
//          rsq2s.run();

//        Solution rsqs = new RangeSumQueryImmutableSolution();
//        rsqs.run();

        Solution pp2s = new PalindromePermutation2Solution();

        pp2s.run();

    }
}
