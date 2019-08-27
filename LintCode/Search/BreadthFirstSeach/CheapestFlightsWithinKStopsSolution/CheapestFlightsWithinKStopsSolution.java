package Algorithm.LintCode.Search.BreadthFirstSeach.CheapestFlightsWithinKStopsSolution;

import Algorithm.Public.Solution.Solution;
import Algorithm.Public.Utills.PrintUtills;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class CheapestFlightsWithinKStopsSolution extends Solution {

    public void test()
    {
        int[][] edges = new int[][]
                {
                        {0, 1, 100},
                        {1, 2, 100},
                        {0, 2, 500}
                };

        int n = 3;

        int src = 0;

        int dst = 2;

        int k  = 1;

        System.out.println("The flights is printed below : ");

        PrintUtills.printInt2DArray(edges);

        System.out.println("The n is printed as : " + n);

        System.out.println("The src is printed as : " + src);

        System.out.println("The dst is printed as : " + dst);

        System.out.println("The k is printed as  : " + k);

        int result = findCheapestPrice(n, edges, src, dst, k);

        System.out.println("The cheapest price is printed as : " + result);

    }

    public class Plan
    {
        public int curCity;

        public int curSpent;

        public int stops;

        public Plan(int curCity, int curSpent, int stops)
        {
            this.curCity = curCity;

            this.curSpent = curSpent;

            this.stops = stops;
        }
    }

    public class Destination
    {
        public int des;

        public int price;

        public Destination(int des, int price)
        {
            this.des = des;

            this.price = price;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        // write your code here

        if (n == 0)
            return -1;

        if (flights.length == 0 || flights[0].length == 0)
            return -1;

        HashMap<Integer, ArrayList<Destination>> graph = new HashMap<>();

        for (int i = 0; i < n; i++)
        {
            graph.put(i, new ArrayList<Destination>());
        }

        for (int i = 0; i < flights.length; i++)
        {
            int city = flights[i][0];

            int des = flights[i][1];

            int price = flights[i][2];

            graph.get(city).add(new Destination(des, price));

        }

        Plan root = new Plan(src, 0, 0);

        Queue<Plan> queue = new LinkedList<>();

        boolean[] visited = new boolean[n];

        queue.add(root);

        visited[src] = true;

        int result = Integer.MAX_VALUE;

        while(!queue.isEmpty())
        {
            int size = queue.size();

            for (int i = 0; i < size; i++)
            {
                Plan cur = queue.poll();

                int curCity = cur.curCity;

                int curSpent = cur.curSpent;

                int curStops = cur.stops;

                if (curCity == dst)
                {
                    result = Math.min(result, curSpent);
                }

                for (Destination des : graph.get(curCity))
                {
                    int nextCity = des.des;

                    int nextPrice = curSpent + des.price;

                    int nextStops = curStops + 1;

                    if (visited[nextCity] == false && nextStops <= K + 1 && nextPrice < result)
                    {
                        queue.add(new Plan(nextCity, nextPrice, nextStops));
                    }
                }
            }
        }

        if (result == Integer.MAX_VALUE)
            return -1;

        return result;
    }
}
