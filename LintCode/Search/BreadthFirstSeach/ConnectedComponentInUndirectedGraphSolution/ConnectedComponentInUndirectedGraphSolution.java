package Algorithm.LintCode.Search.BreadthFirstSeach.ConnectedComponentInUndirectedGraphSolution;

import Algorithm.Public.DataStructure.UndirectedGraphNode;
import Algorithm.Public.Solution.Solution;

import java.util.*;

public class ConnectedComponentInUndirectedGraphSolution extends Solution {

    public void test()
    {

    }

    // First Solution : BFS, we will add Union-Find Later
    public List<List<Integer>> connectedSet(List<UndirectedGraphNode> nodes) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();

        int len = nodes.size();

        if (len == 0)
            return result;

        HashMap<UndirectedGraphNode, Boolean> visited = new HashMap<>();

        for (UndirectedGraphNode node : nodes)
        {
            visited.put(node, false);
        }

        for (UndirectedGraphNode node : nodes)
        {
            if (visited.get(node) == false)
            {
                bfs(result, new ArrayList<Integer>(), node, visited);
            }
        }

        return result;
    }

    private void bfs(
            List<List<Integer>> result,
            List<Integer> candidate,
            UndirectedGraphNode root,
            HashMap<UndirectedGraphNode, Boolean> visited)
    {
        if (root == null)
            return;

        Queue<UndirectedGraphNode> queue = new LinkedList<>();

        queue.add(root);

        visited.put(root, true);

        while(!queue.isEmpty())
        {
            UndirectedGraphNode cur = queue.poll();

            candidate.add(cur.label);

            for (UndirectedGraphNode node : cur.neighbors)
            {
                if (visited.get(node) == false)
                {
                    queue.add(node);

                    visited.put(node, true);
                }
            }
        }

        Collections.sort(candidate);

        result.add(candidate);
    }
}
