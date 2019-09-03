package Algorithm.Amazon.CriticalConnectionSolution;

import Algorithm.Public.DataStructure.UndirectedGraphNode;
import Algorithm.Public.Solution.Solution;
import Algorithm.Public.Utills.PrintUtills;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CriticalConnectionSolution extends Solution {

    @Override
    public void test() {

        criticalConnection(5, 5, new int[][]{{1, 2}, {1, 3}, {3, 4}, {1, 4}, {4, 5}});

    }

    private int time = 0;

    private int[][] criticalConnection(int numOfServers, int numOfConnections, int[][] connections) {


        HashMap<Integer, UndirectedGraphNode> map  = new HashMap<>();

        for (int i = 1; i <= numOfServers; i++)
            map.put(i, new UndirectedGraphNode(i));

        for (int i = 0; i < connections.length; i++) {
            int[] connection = connections[i];
            map.get(connection[0]).neighbors.add(map.get(connection[1]));
            map.get(connection[1]).neighbors.add(map.get(connection[0]));
        }

        List<int[]> criticalLinks = new ArrayList<>();

        dfs(criticalLinks, map.get(1),
                new int[numOfServers + 1],
                new boolean[numOfServers + 1],
                new int[numOfServers + 1],
                new int[numOfServers + 1]);

        int[][] res = new int[criticalLinks.size()][2];
        int index = 0;
        for (int[] link : criticalLinks)
            res[index++] = link;

        PrintUtills.printInt2DArray(res);

        return res;
    }

    private void dfs(List<int[]> criticalLinks,
                     UndirectedGraphNode node,
                     int[] parent,
                     boolean[] visited,
                     int[] low,
                     int[] discover) {

        int id = node.label;

        visited[id] = true;

        low[id] = discover[id] = ++time;

        int children = 0;

        for (UndirectedGraphNode neighbor : node.neighbors) {
            if (visited[neighbor.label] == false) {

                parent[neighbor.label] = id;

                children++;

                dfs(criticalLinks, neighbor, parent, visited, low, discover);

                low[id] = Math.min(low[id], low[neighbor.label]);

                if (low[neighbor.label] > discover[id]) {
                    int[] edge = new int[]{id, neighbor.label};
                    Arrays.sort(edge);
                    criticalLinks.add(edge);
                }

            } else if (neighbor.label != parent[id]) {
                low[id] = Math.min(low[id], discover[neighbor.label]);
            }
        }
    }
}
