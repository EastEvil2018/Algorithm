package Algorithm;

import Algorithm.Amazon.ContructStringWithKDistinctApartSolution.ConstructStringWithKDistinctApartSolution;
import Algorithm.Amazon.CriticalConnectionSolution.CriticalConnectionSolution;
import Algorithm.Amazon.FindSubstringsOfSizeKWithKDistinctCharactersSolution.FindSubstringsOfSizeKWithDistinctCharactersSolution;
import Algorithm.Amazon.LongestStringMadeUpOfOnlyVowelsSolution.LongestStringMadeUpOfOnlyVowelsSolution;
import Algorithm.Amazon.MinCostToConnectAllNodesSolution.MinCostToConnectAllNodesSolution;
import Algorithm.Amazon.MinCostToRepairEdgesSolution.MinCostToRepairEdgesSolution;
import Algorithm.Amazon.MostCommonWordsSolution.MostCommonWordsSolution;
import Algorithm.Amazon.RollDiceSolution.RollDiceSolution;
import Algorithm.Amazon.ShippingRoutesSolution.ShippingRoutesSolution;
import Algorithm.Amazon.ShopkeeperSaleSolution.ShopkeeperSaleSolution;
import Algorithm.Amazon.SortCenterSolution.SortCenterSolution;
import Algorithm.Amazon.UserFavoriteGenresSolution.UserFavoriteGenresSolution;
import Algorithm.HackerRank.Mathworks.BuildOfficeSolution.BuildOfficeSolution;
import Algorithm.HackerRank.Mathworks.CostOfATreeSolution.CostOfATreeSolution;
import Algorithm.HackerRank.Mathworks.MergeStringSolution.MergeStringSolution;
import Algorithm.HackerRank.Mathworks.SubStringsSolution.SubStringsSolution;
import Algorithm.HackerRank.RStar.DistancesFromCapitalSolution.DistancesFromCapitalSolution;
import Algorithm.HackerRank.WePay.AlerterSolution.AlerterSolution;
import Algorithm.HackerRank.WePay.NurikabeSolution.NurikabeSolution;
import Algorithm.HackerRank.WePay.PowerNumberSolution.PowerNumberSolution;
import Algorithm.HackerRank.WePay.SlidingWindowAverageSolution.SlidingWindowAverageSolution;
import Algorithm.HackerRank.WePay.ZombieClusterSolution.ZombieCluserSolution;
import Algorithm.LeetCode.SegmentTree.LargestRectangleInHistogramSolution.LargestRectangleInHistogramSolution;
import Algorithm.LintCode.DataStructure.LinkedList.DeleteGreaterNodesSolution.DeleteGreaterNodesSolution;
import Algorithm.LintCode.DataStructure.PriorityQueue.KthSmallestNumberInSortedMatrixSolution.KthSmallestNumberInSortedMatrixSolution;
import Algorithm.LintCode.DataStructure.PriorityQueue.MedianOfKSortedArraysSolution.MedianOfKSortedArraysSolution;
import Algorithm.LintCode.DataStructure.PriorityQueue.MergeKSortedArraySolution.MergeKSortedArraySolution;
import Algorithm.LintCode.DataStructure.PriorityQueue.MergeKSortedIntervalList.MergeKSortedIntervalListSolution;
import Algorithm.LintCode.DataStructure.PriorityQueue.MergeNumberSolution.MergeNumberSolution;
import Algorithm.LintCode.DataStructure.PriorityQueue.MergeTwoSortedIntervalList.MergeTwoSortedIntervalListSolution;
import Algorithm.LintCode.DataStructure.PriorityQueue.TopKFrequentWods2Solution.TopKFrequentWords2Solution;
import Algorithm.LintCode.DataStructure.PriorityQueue.TopKFrequentWordsSolution.TopKFrequentWordsSolution;
import Algorithm.LintCode.DataStructure.PriorityQueue.TopKLargestNumberSolution.TopKLargestNumberSolution;
import Algorithm.LintCode.DataStructure.String.AddParenthesesSolution.AddParenthesesSolution;
import Algorithm.LintCode.DataStructure.Trie.WordSquaresSolution.WordSquaresSolution;
import Algorithm.LintCode.DynamicProgramming.RangeSumQuery2DSolution.RangeSumQuery2DSolution;
import Algorithm.LintCode.DynamicProgramming.RangeSumQueryImmutableSolution.RangeSumQueryImmutableSolution;
import Algorithm.LintCode.Search.BackTracking.FactorizationSolution.FactorizationSolution;
import Algorithm.LintCode.Search.BackTracking.FindMissingNumber2Solution.FindMissingNumber2Solution;
import Algorithm.LintCode.Search.BackTracking.PalindromePermutation2Solution.PalindromePermutation2Solution;
import Algorithm.LintCode.Search.BackTracking.TowerOfHanoiSolution.TowerOfHanoiSolution;
import Algorithm.LintCode.Search.BackTracking.WordSearchSolution.WordSearchSolution;
import Algorithm.LintCode.Search.BreadthFirstSeach.CheapestFlightsWithinKStopsSolution.CheapestFlightsWithinKStopsSolution;
import Algorithm.LintCode.Search.BreadthFirstSeach.KnightShortestPath2Solution.KnightShortestPath2Solution;
import Algorithm.LintCode.Search.BreadthFirstSeach.Maze2Solution.Maze2Solution;
import Algorithm.LintCode.Search.BreadthFirstSeach.MazeSolution.MazeSolution;
import Algorithm.LintCode.Search.BreadthFirstSeach.PortalSolution.PortalSolution;
import Algorithm.LintCode.Search.BreadthFirstSeach.SorroundedRegionsSolution.SorroundedRegionsSolution;
import Algorithm.LintCode.Search.BreadthFirstSeach.WallsAndGatesSolution.WallsAndGatesSolution;
import Algorithm.LintCode.Search.BreadthFirstSeach.ZombieInMatrixSolution.ZombieInMatrixSolution;
import Algorithm.LintCode.Search.CombinationSearch.KSum2Solution.KSum2Solution;
import Algorithm.LintCode.Search.GraphSearch.RouteBetweenTwoNodesInGraphSolution.RouteBetweenTwoNodesInGraphSolution;
import Algorithm.LintCode.Search.PermutationSearch.UniquePermutationSolution.UniquePermuationSolution;
import Algorithm.LintCode.Sort.HouseRankingSolution.HouseRankingSolution;
import Algorithm.LintCode.Sort.SortLettersByCaseSolution.SortLettersByCaseSolution;
import Algorithm.LintCode.Sort.WiggleSort.WiggleSortSolution;
import Algorithm.Public.Solution.Solution;
import sun.java2d.pipe.SolidTextRenderer;

import javax.jws.soap.SOAPBinding;
import javax.sound.midi.Soundbank;

public class Analyzer {

    public static void main(String [] args){

        /*
        Example to run any one of the problem solution
         */

//        Solution sol = new DeleteGreaterNodesSolution();
//
//        sol.run();

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

//        Solution pp2s = new PalindromePermutation2Solution();
//
//        pp2s.run();

//          Solution tkfws = new TopKFrequentWordsSolution();
//
//          tkfws.run();

//        Solution ups = new UniquePermuationSolution();
//        ups.run();

//        Solution ks2s = new KSum2Solution();
//        ks2s.run();

//        Solution mns = new MergeNumberSolution();
//
//        mns.run();

//          Solution mksils = new MergeKSortedIntervalListSolution();
//
//          mksils.run();

//        Solution m2sils = new MergeTwoSortedIntervalListSolution();
//
//        m2sils.run();
//
//        Solution mkas = new MergeKSortedArraySolution();
//
//        mkas.run();

//        Solution tklns = new TopKLargestNumberSolution();
//
//        tklns.run();

//        Solution moksS = new MedianOfKSortedArraysSolution();
//
//        moksS.run();

//        Solution mys = new KthSmallestNumberInSortedMatrixSolution();
//
//        mys.run();
//
//        Solution mys = new TopKFrequentWords2Solution();
//
//        mys.run();

//        Solution mys = new RouteBetweenTwoNodesInGraphSolution();
//
//        mys.run();

//        Solution mys = new SorroundedRegionsSolution();
//
//        mys.run();
//
//        Solution mys = new ZombieInMatrixSolution();
//
//        mys.run();

//        Solution mys = new KnightShortestPath2Solution();
//
//        mys.run();

//        Solution mys = new WallsAndGatesSolution();
//
//        mys.run();

//        Solution mys = new PortalSolution();
//
//        mys.run();

//        Solution mys = new MazeSolution();
//
//        mys.run();

//        Solution mys = new Maze2Solution();
//
//        mys.run();

//        Solution mys = new CheapestFlightsWithinKStopsSolution();
//
//        mys.run();

//        Solution mys = new SortLettersByCaseSolution();
//
//        mys.run();

//        Solution mys = new WiggleSortSolution();
//
//        mys.run();

//        Solution mys = new AddParenthesesSolution();
//
//        mys.run();

//        Solution mys = new ZombieCluserSolution();
//
//        mys.run();

//        Solution mys = new SlidingWindowAverageSolution();
//
//        mys.run();

//        Solution mys = new AlerterSolution();
//
//        mys.run();

//        Solution mys = new PowerNumberSolution();
//
//        mys.run();

//        Solution mys = new NurikabeSolution();
//
//        mys.run();

//        Solution mys = new MergeStringSolution();
//        mys.run();

//        Solution mys = new SubStringsSolution();
//        mys.run();

//        Solution mys = new BuildOfficeSolution();
//        mys.run();

//        Solution mys = new LargestRectangleInHistogramSolution();
//        mys.run();

//        Solution mys = new CostOfATreeSolution();
//        mys.run();
//        Solution mys = new DistancesFromCapitalSolution();
//        mys.run();

//        Solution mys = new FindSubstringsOfSizeKWithDistinctCharactersSolution();
//        mys.run();
//        Solution mys = new MostCommonWordsSolution();
//        mys.run();
//        Solution mys = new ConstructStringWithKDistinctApartSolution();
//        mys.run();
//        Solution mys = new SortCenterSolution();
//        mys.run();
//        Solution mys = new RollDiceSolution();
//        mys.run();
//        Solution mys = new ShippingRoutesSolution();
//        mys.run();
//        Solution mys = new MinCostToConnectAllNodesSolution();
//        mys.run();
//
//        Solution mys = new MinCostToRepairEdgesSolution();
//        mys.run();
//        Solution mys = new ShopkeeperSaleSolution();
//        mys.run();
//        Solution mys = new LongestStringMadeUpOfOnlyVowelsSolution();
//        mys.run();
//
//        Solution mys = new CriticalConnectionSolution();
//        mys.run();

        Solution mys = new UserFavoriteGenresSolution();
        mys.run();

    }
}
