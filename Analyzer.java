package Algorithm;

import Algorithm.LintCode.DataStructure.LinkedList.DeleteGreaterNodesSolution.DeleteGreaterNodesSolution;
import Algorithm.LintCode.Search.BackTracking.WordSearchSolution.WordSearchSolution;
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

        Solution wss = new WordSearchSolution();

        wss.run();

    }
}
