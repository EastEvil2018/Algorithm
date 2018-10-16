package Algorithm.LintCode.DataStructure.PriorityQueue.MergeKSortedIntervalList;

import Algorithm.Public.DataStructure.Interval;
import Algorithm.Public.Solution.Solution;
import Algorithm.Public.Utills.PrintUtills;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedIntervalListSolution extends Solution {

    public void test()
    {
        List<List<Interval>> intervals = new ArrayList<>();

        List<Interval> intervalListA = new ArrayList<>();

        Interval A = new Interval(1, 3);

        Interval B = new Interval(4, 7);

        Interval C = new Interval(6, 8);

        intervalListA.add(A);

        intervalListA.add(B);

        intervalListA.add(C);

        intervals.add(intervalListA);

        List<Interval> intervalListB = new ArrayList<>();

        Interval D = new Interval(1, 2);

        Interval E = new Interval(9, 10);

        intervalListB.add(D);

        intervalListB.add(E);

        intervals.add(intervalListB);

        System.out.println("The test list of interval list is printed below : ");

        PrintUtills.printeListOfIntervalList(intervals);

        System.out.println("The result is printed below : ");

        List<Interval> intervalList = mergeKSortedIntervalLists(intervals);

        PrintUtills.printIntervalList(intervalList);


    }

    public class IntervalComparator implements Comparator<Interval>
    {
        public int compare(Interval a, Interval b)
        {
            if (a.start < b.start)
            {
                return -1;
            }

            if (a.start > b.start)
            {
                return 1;
            }


            if (a.end < b.end)
                return -1;

            if (a.end > b.end)
                return 1;

            return 0;

        }
    }

    public List<Interval> mergeKSortedIntervalLists(List<List<Interval>> intervals) {
        // write your code here

        PriorityQueue<Interval> pq = new PriorityQueue<Interval>(intervals.size(), new IntervalComparator());

        int len = intervals.size();

        for (int i = 0; i < len; i++)
        {
            List<Interval> cur = intervals.get(i);

            int curSize = cur.size();

            for (int j = 0; j < curSize; j++)
            {
                pq.add(cur.get(j));
            }
        }

        List<Interval> result = new ArrayList<>();

        Interval curInterval = pq.poll();

        result.add(curInterval);

        Interval prevInterval = curInterval;


        while(!pq.isEmpty())
        {
            curInterval = pq.poll();

            if (curInterval.start > prevInterval.start)
            {
                if (curInterval.start > prevInterval.end)
                {
                    result.add(curInterval);

                    prevInterval = curInterval;

                    continue;
                } else
                {
                    if (curInterval.end <= prevInterval.end)
                    {
                        continue;
                    } else
                    {
                        result.get(result.size() - 1).end = curInterval.end;

                        prevInterval = result.get(result.size() - 1);
                    }
                }

            } else if (curInterval.start == prevInterval.start)
            {
                if (curInterval.end <= prevInterval.end)
                {
                    continue;
                } else if (curInterval.end > prevInterval.end)
                {
                    result.get(result.size() - 1).end = curInterval.end;

                    prevInterval = result.get(result.size() - 1);

                    continue;
                }
            }
        }

        return result;
    }
}
