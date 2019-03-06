package Algorithm.LeetCode.Facebook.TrappingRainWaterSolution;

import Algorithm.Public.Solution.Solution;

public class TrappingRainWaterSolution extends Solution {

    public void test() {

        int[] testArr = new int[] {0,1,0,2,1,0,1,3,2,1,2,1};

        int result = trap(testArr);


    }

    public int trap(int[] height) {

        int result = 0;

        int it = 0;

        while (it < height.length - 1) {
            if (height[it] == 0) {
                it++;
                continue;
            }

            int boundHeight = height[it];

            int tempIt = it + 1;

            while (tempIt < height.length && height[tempIt] < boundHeight) {
                tempIt++;
            }

            if (tempIt == height.length) {
                result += reverseCal(height, it);
                break;
            } else {
                // we find a trap, start = it, end = tempIt

                for (int i = it + 1; i < tempIt; i++) {
                    result += (boundHeight - height[i]);
                }

                it = tempIt;
                continue;
            }
        }

        return result;
    }

    private int reverseCal(int[] height, int start) {
        // cal from start to the end of array
        // and height[start] is the highest height

        int result = 0;

        int it = height.length - 1;

        while (it > start) {
            if (height[it] == 0) {
                it--;
                continue;
            }

            int boundHeight = height[it];

            int tempIt = it - 1;

            while (tempIt > start && height[tempIt] < boundHeight) {
                tempIt--;
            }


            // we find a trap, start = it, end = tempIt

            for (int i = it - 1; i > tempIt; i--) {
                result += (boundHeight - height[i]);
            }

            it = tempIt;
        }

        return result;

    }
}
