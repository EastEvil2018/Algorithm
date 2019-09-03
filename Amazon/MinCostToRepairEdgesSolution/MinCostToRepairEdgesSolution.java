package Algorithm.Amazon.MinCostToRepairEdgesSolution;

import Algorithm.Public.Solution.Solution;
import Algorithm.Public.Utills.PrintUtills;
import org.junit.Assert;

import java.util.*;

public class MinCostToRepairEdgesSolution extends Solution {

    @Override
    public void test() {

//        n = 5, edges = [[1, 2], [2, 3], [3, 4], [4, 5], [1, 5]], edgesToRepair = [[1, 2, 12], [3, 4, 30], [1, 5, 8]]
        int n = 5;
        int[][] edges = new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {1, 5}};
        int[][] edgesToRepair = new int[][]{{1, 2, 12}, {3, 4, 30}, {1, 5, 8}};

        Assert.assertTrue(minCostToRepairEdgesSolution(n, edges, edgesToRepair) == 20);
    }

    int[] parent;

    private int root(int node) {
        if (parent[node] != -1) {
            parent[node] = root(parent[node]);
            return parent[node];
        }

        return node;
    }

    private  void union(int a, int b) {
        int ra = root(a);
        int rb = root(b);

        parent[ra] = rb;
    }


    private int minCostToRepairEdgesSolution(int N, int[][] edges, int[][] edgesToRepair) {
        int cost = 0;


        this.parent = new int[N + 1];
        Arrays.fill(parent, -1);
        HashSet<List<Integer>> set = new HashSet<>();

        int[][] fixedEgdes = new int[edges.length][3];
        int it = 0;

        for (int[] edge : edgesToRepair) {
            set.add(new ArrayList<>(Arrays.asList(edge[0], edge[1])));
            fixedEgdes[it++] = edge;
        }


        for (int[] edge : edges){
            if (!set.contains(new ArrayList<>(Arrays.asList(edge[0], edge[1])))) {
                PrintUtills.printIntArray(edge);
                fixedEgdes[it++] = new int[]{edge[0], edge[1], 0};
            }
        }

        Arrays.sort(fixedEgdes, (int[] a, int[] b) -> (a[2] - b[2]));

        it = 0;

        for (int i = 0; i < N - 1; i++) {
            int[] edge = fixedEgdes[it++];

            while (it < fixedEgdes.length && root(edge[0]) == root(edge[1])) {
                edge = fixedEgdes[it++];
            }

            if (root(edge[0]) == root(edge[1])) {
                System.out.println("Fail");

                return -1;
            } else {
                System.out.println("Connect " + edge[0] + " With " + edge[1] + " By " + edge[2] + " Cost ");
                cost += edge[2];
                union(edge[0], edge[1]);
            }
        }

        return cost;

    }
}
