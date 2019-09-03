package Algorithm.Amazon.MinCostToConnectAllNodesSolution;

import Algorithm.Public.Solution.Solution;
import org.junit.Assert;

import java.util.Arrays;

public class MinCostToConnectAllNodesSolution extends Solution {

    @Override
    public void test() {
        int n = 6;
        int[][] edges = new int[][]{{1, 4}, {4, 5}, {2, 3}};
        int[][] newEdges = new int[][]{{1, 2, 5}, {1, 3, 10}, {1, 6, 2}, {5, 6, 5}};
        Assert.assertTrue(minCostToConnectAllNodes(n, edges, newEdges) == 7);
    }

    private int[] parent;

    private int root(int node) {
        if (parent[node] != -1) {
            parent[node] = root(parent[node]);
            return parent[node];
        }

        return node;
    }

    private void union(int a, int b) {
        int ra = root(a);
        int rb = root(b);

        parent[ra] = rb;
    }

    private int minCostToConnectAllNodes(int N, int[][] edges, int[][] newEdges) {

        this.parent = new int[N + 1];
        Arrays.fill(parent, -1);

        if (edges.length + newEdges.length < N - 1)
            return -1;

        for (int[] edge : edges) {
            union(edge[0], edge[1]);
        }

        int unConnectNodeNum = -1;
        for (int node : parent) {
            if (node == -1)
                unConnectNodeNum++;
        }

        Arrays.sort(newEdges, (int[] a, int[] b) -> (a[2] - b[2]));

        int index = 0;
        int cost = 0;
        for (int i = 0; i < unConnectNodeNum - 1; i++) {

            int [] edge = newEdges[index++];
            while (index < newEdges.length && root(edge[0]) == root(edge[1])) {
                edge = newEdges[index++];
            }

            if (root(edge[0]) == root(edge[1])) {
                System.out.println("Can not connect : " + " UnConnectNodeNum : " + unConnectNodeNum);
                return -1;
            } else {
                System.out.println("Connect " + edge[0] + " With " + edge[1] + " By " + edge[2] + " Cost ");
                cost += edge[2];
                union(edge[0], edge[1]);
            }

        }

        System.out.println(cost);

        return cost;
    }
}
