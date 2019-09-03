package Algorithm.Amazon.ShippingRoutesSolution;

import Algorithm.Public.Solution.Solution;
import Algorithm.Public.Utills.PrintUtills;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShippingRoutesSolution extends Solution {

    @Override
    public void test() {
        int[][] forwardRoutes = new int[][]{{1,2000},{2,4000},{3,6000}};
        int[][] returnRoutes = new int[][]{{1,2000}};
        System.out.println("Test Begin : ");
        PrintUtills.printListOfIntegerList(shippingRoutes(7000, forwardRoutes, returnRoutes));

        forwardRoutes = new int[][]{{1,3000},{2,5000},{3,7000},{4,10000}};
        returnRoutes = new int[][]{{1,2000},{2,3000},{3,4000},{4,5000}};
        PrintUtills.printListOfIntegerList(shippingRoutes(10000, forwardRoutes, returnRoutes));

    }

    private List<List<Integer>> shippingRoutes(int maxTravelDist, int[][] forwardRoutes, int[][] returnRoutes) {

        Arrays.sort(forwardRoutes, (int[] a, int[] b) -> (a[1] - b[1]));
        Arrays.sort(returnRoutes, (int[] a, int[] b) -> (a[1] - b[1]));

        int max = Integer.MIN_VALUE;

        int fL = forwardRoutes.length;
        int rL = returnRoutes.length;

        int fP = 0;
        int rP = rL - 1;
        List<List<Integer>> res = new ArrayList<>();

        while (fP < fL && rP >= 0) {
            int curTravel = forwardRoutes[fP][1] + returnRoutes[rP][1];

            if (curTravel > maxTravelDist) {
                rP--;
            } else {
                if (curTravel > max) {
                    res.clear();
                    List<Integer> cand = new ArrayList<>();
                    cand.add(forwardRoutes[fP][0]);
                    cand.add(returnRoutes[rP][0]);
                    res.add(cand);
                    max = curTravel;
                } else if (curTravel == max) {
                    List<Integer> cand = new ArrayList<>();
                    cand.add(forwardRoutes[fP][0]);
                    cand.add(returnRoutes[rP][0]);
                    res.add(cand);
                }
                fP++;
            }

        }

        return res;
    }
}
