package Algorithm.HackerRank.RStar.DistancesFromCapitalSolution;

import Algorithm.Public.Solution.Solution;
import Algorithm.Public.Utills.PrintUtills;
import sun.jvm.hotspot.utilities.Assert;

import java.util.*;

public class DistancesFromCapitalSolution extends Solution{
    @Override
    public void test() {
        int[] testcase1 = new int[]{9, 1, 4, 9, 0, 4, 8, 9, 0, 1};

        org.junit.Assert.assertTrue("Test case 1 fails", Arrays.equals(distancesFromCapital(testcase1), new int[]{1, 3, 2, 3, 0, 0, 0, 0, 0}));
    }


    public int[] distancesFromCapital(int[] network) {
        int M = network.length;
        int capital = 0;
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();

        for (int i = 0; i < M; i++) {
            if (network[i] == i) {
                capital = i;
            } else {
                if (!map.containsKey(i)) {
                    map.put(i, new HashSet<>());
                }
                if (!map.containsKey(network[i])) {
                    map.put(network[i], new HashSet<>());
                }

                map.get(i).add(network[i]);
                map.get(network[i]).add(i);
            }

        }


        int depth = 0;

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[M];
        int[] result = new int[M - 1];
        queue.add(capital);
        visited[capital] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                for (Integer neighbor : map.get(cur)) {
                    if (visited[neighbor] == false) {
                        visited[neighbor] = true;
                        queue.add(neighbor);
                        result[depth]++;
                    }
                }
            }
            depth++;
        }

        PrintUtills.printIntArray(result);
        return result;
    }
}
