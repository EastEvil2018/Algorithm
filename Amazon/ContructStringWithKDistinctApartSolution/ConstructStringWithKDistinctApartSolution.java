package Algorithm.Amazon.ContructStringWithKDistinctApartSolution;

import Algorithm.Public.Solution.Solution;
import Algorithm.Public.Utills.PrintUtills;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ConstructStringWithKDistinctApartSolution extends Solution {

    @Override
    public void test() {
        int[] nums1 = new int[]{1, 1, 6};
        int[] nums2 = new int[]{1, 2, 3};

        System.out.println("First test case : ");
        PrintUtills.printIntArray(nums1);
        System.out.println("Result : " + construccStringWithKDistinctApart(nums1, 3));

        System.out.println("Second test case : ");
        PrintUtills.printIntArray(nums2);
        System.out.println("Result : " + construccStringWithKDistinctApart(nums2, 3));

    }

    private String construccStringWithKDistinctApart(int[] nums, int k) {
        // In this problem, k = 3
        // nums only have 3 integer, which means at most nums[0] a, nums[1] b, nums[2] c

        StringBuilder sb = new StringBuilder();

        HashMap<Character, Integer> map = new HashMap<>();

        map.put('a', nums[0]);
        map.put('b', nums[1]);
        map.put('c', nums[2]);

        PriorityQueue<Map.Entry<Character, Integer>> pq
                = new PriorityQueue<>(11, (a, b) -> (b.getValue() - a.getValue()));

        pq.addAll(map.entrySet());

        int len = nums[0] + nums[1] + nums[2];

        Map.Entry<Character, Integer> onHold = null;

        while (!pq.isEmpty()) {
            Map.Entry<Character, Integer> cur = pq.poll();

            sb.append(cur.getKey());


            if (onHold != null) {
                pq.add(onHold);
                onHold = null;
            }

            if (cur.getValue() > 1) {
                cur.setValue(cur.getValue() - 1);

                if (sb.length() >= (k - 1) && sb.charAt(sb.length() - (k - 1)) == cur.getKey()) {
                    onHold = cur;
                } else {
                    pq.add(cur);
                }
            }
        }

        return sb.toString();
    }

}
