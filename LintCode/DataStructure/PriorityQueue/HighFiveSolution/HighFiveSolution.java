package Algorithm.LintCode.DataStructure.PriorityQueue.HighFiveSolution;

import Algorithm.Public.Solution.Solution;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HighFiveSolution extends Solution {
    
    public void test()
    {
        Record[] records = new Record[]
                {
                        new Record(1,91),
                        new Record(1,92),
                        new Record(2,93),
                        new Record(2,99),
                        new Record(2,98),
                        new Record(2,97),
                        new Record(1,60),
                        new Record(1,58),
                        new Record(2,100),
                        new Record(1,61)
                };

        Map<Integer, Double> result = highFive(records);

        for (int id : result.keySet())
        {
            System.out.println("ID : " + id + " Score : " + result.get(id));
        }
    }

    public class Record {

        public int id, score;

        public Record(int id, int score){
            this.id = id;
            this.score = score;
        }

    }

    public Map<Integer, Double> highFive(Record[] results) {
        // Write your code here

        HashMap<Integer, Double> result = new HashMap<Integer, Double>();

        int len = results.length;

        if (len == 0)
            return result;

        HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<Integer, PriorityQueue<Integer>>();

        for (int i = 0; i < len; i++)
        {
            if (!map.containsKey(results[i].id))
            {
                PriorityQueue<Integer> pq = new PriorityQueue<>();

                pq.add(results[i].score);

                map.put(results[i].id, pq);
            } else
            {
                PriorityQueue<Integer> pq = map.get(results[i].id);

                pq.add(results[i].score);

                if (pq.size() > 5)
                    pq.poll();

                map.put(results[i].id, pq);
            }
        }

        for (int id : map.keySet())
        {
            PriorityQueue<Integer> pq = map.get(id);

            double ave = 0.0;

            while(!pq.isEmpty())
            {
                int cur = pq.poll();

                ave = ave + cur / 5.0;
            }

            result.put(id, ave);
        }

        return result;
    }
}
