package Algorithm.LintCode.Search.GraphSearch.RouteBetweenTwoNodesInGraphSolution;

import Algorithm.Public.DataStructure.DirectedGraphNode;
import Algorithm.Public.Solution.Solution;

import java.util.*;

public class RouteBetweenTwoNodesInGraphSolution extends Solution {

    public void test()
    {
        DirectedGraphNode A = new DirectedGraphNode(1);

        DirectedGraphNode B = new DirectedGraphNode(2);

        DirectedGraphNode C = new DirectedGraphNode(3);

        DirectedGraphNode D = new DirectedGraphNode(4);

        DirectedGraphNode E = new DirectedGraphNode(5);

        A.neighbors.add(B);

        A.neighbors.add(D);

        B.neighbors.add(C);

        B.neighbors.add(D);

        D.neighbors.add(E);

        List<DirectedGraphNode> graph = new ArrayList<>();

        graph.add(A);

        graph.add(B);

        graph.add(C);

        graph.add(D);

        graph.add(E);

        boolean result = hasRoute(graph, B, E);

        if (result)
            System.out.println("Test Pass");
    }

    public boolean hasRoute(List<DirectedGraphNode> graph, DirectedGraphNode s, DirectedGraphNode t) {
        // write your code here

        Queue<DirectedGraphNode> queue = new LinkedList<>();

        Set<DirectedGraphNode> set = new HashSet<>();

        queue.add(s);


        while(!queue.isEmpty())
        {
            DirectedGraphNode cur = queue.poll();

            if (cur == t)
                return true;

            set.add(cur);

            for (DirectedGraphNode neighbor : cur.neighbors)
            {
                if (!set.contains(neighbor))
                {
                    queue.add(neighbor);
                    set.add(neighbor);
                }
            }
        }

        return false;
    }
}
