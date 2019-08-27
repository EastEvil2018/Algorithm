package Algorithm.LeetCode.SegmentTree.LargestRectangleInHistogramSolution;

import Algorithm.Public.Solution.Solution;
import org.junit.Assert;

public class LargestRectangleInHistogramSolution extends Solution{
    @Override
    public void test() {
        int[] testcase1 = new int[]{2, 1, 5, 6, 2, 3};
        Assert.assertTrue("Result : " + largestRectangle(testcase1),largestRectangle(testcase1) == 10);
    }

    public class SegmentNode {
        int rangeFrom;
        int rangeTo;
        int minIndex;
        SegmentNode left;
        SegmentNode right;
        public SegmentNode(int rangeFrom, int rangeTo) {
            this.rangeFrom = rangeFrom;
            this.rangeTo = rangeTo;
            this.minIndex = -1;
            this.left = null;
            this.right = null;
        }
    }

    public int largestRectangle(int[] heights) {
        SegmentNode root = buildSegementTree(heights, 0, heights.length - 1);
        int result = calculateLargestRectangle(heights, root, 0, heights.length - 1);
        System.out.println(result);
        return result;
    }

    public int calculateLargestRectangle(int[] heights, SegmentNode root, int rangeFrom, int rangeTo) {
        if (rangeFrom > rangeTo)
            return 0;
        if (rangeFrom == rangeTo)
            return heights[rangeFrom] * 1;
        int minIndex = query(heights, root, rangeFrom, rangeTo);

        int leftLargestRect = calculateLargestRectangle(heights, root, rangeFrom, minIndex - 1);
        int rightLargestRect = calculateLargestRectangle(heights, root, minIndex + 1, rangeTo);
        int curLargestRect = heights[minIndex] * (rangeTo - rangeFrom + 1);
        return Math.max(curLargestRect, Math.max(leftLargestRect, rightLargestRect));
    }

    private SegmentNode buildSegementTree(int[] heights, int rangeFrom, int rangeTo) {
        if (rangeFrom > rangeTo)
            return null;
        SegmentNode root = new SegmentNode(rangeFrom, rangeTo);
        if (rangeFrom == rangeTo) {
            root.minIndex = rangeFrom;
            return root;
        }
        int mid = rangeFrom + (rangeTo - rangeFrom) / 2;

        SegmentNode leftChild = buildSegementTree(heights, rangeFrom, mid);
        SegmentNode rightChild = buildSegementTree(heights, mid + 1, rangeTo);
        root.left = leftChild;
        root.right = rightChild;
        root.minIndex
                = heights[leftChild.minIndex] > heights[rightChild.minIndex] ?
                rightChild.minIndex :
                leftChild.minIndex;
        return root;
    }

    private int query(int[] heights, SegmentNode root, int rangeFrom, int rangeTo) {
        if (root == null)
            return -1;
        if (root.rangeFrom >= rangeFrom && root.rangeTo <= rangeTo) {
            // if the root range is fully inside the query range
            return root.minIndex;
        } else if (root.rangeFrom > rangeTo || root.rangeTo < rangeFrom) {
            // if the root range is fully outside the query range
            return -1;
        }
        // else, query range is included in the root range, we need to recurse further
        int leftMinIndex = query(heights, root.left, rangeFrom, rangeTo);
        int rightMinIndex = query(heights, root.right, rangeFrom, rangeTo);
        if (leftMinIndex == -1)
            return rightMinIndex;
        if (rightMinIndex == -1)
            return leftMinIndex;
        return heights[leftMinIndex] > heights[rightMinIndex] ? rightMinIndex : leftMinIndex;
    }
}
