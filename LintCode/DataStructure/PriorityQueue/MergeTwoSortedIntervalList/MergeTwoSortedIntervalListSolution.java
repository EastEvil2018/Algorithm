package Algorithm.LintCode.DataStructure.PriorityQueue.MergeTwoSortedIntervalList;

import Algorithm.Public.DataStructure.Interval;
import Algorithm.Public.Solution.Solution;
import Algorithm.Public.Utills.PrintUtills;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeTwoSortedIntervalListSolution extends Solution {
    public void test()
    {
        List<Interval> list1 = new ArrayList<>();

        Interval A = new Interval(1, 2);

        Interval B = new Interval(3, 4);

        list1.add(A);

        list1.add(B);

        List<Interval> list2 = new ArrayList<>();

        Interval C = new Interval(2, 3);

        Interval D = new Interval(5, 6);

        list2.add(C);

        list2.add(D);

        System.out.println("The given list1 is printed below : ");

        PrintUtills.printIntervalList(list1);

        System.out.println("\nThe given list2 is printed below : ");

        PrintUtills.printIntervalList(list2);

        List<Interval> result = mergeTwoInterval(list1, list2);

        System.out.println("\nThe result is printed below : ");

        PrintUtills.printIntervalList(result);
    }

    public class IntervalComparator implements Comparator<Interval>
    {
        public int compare(Interval a, Interval b)
        {
            if (a.start < b.start)
                return -1;

            if (a.start > b.start)
                return 1;

            if (a.end < b.end)
                return -1;

            if (a.end > b.end)
                return 1;

            return 0;
        }
    }

    public List<Interval> mergeTwoInterval(List<Interval> list1, List<Interval> list2) {
        // write your code here

        int len1 = list1.size();

        int len2 = list2.size();

        List<Interval> result = new ArrayList<>();


        if (len1 + len2 == 0)
            return result;

        PriorityQueue<Interval> pq = new PriorityQueue<Interval>(len1 + len2, new IntervalComparator());

        for (int i = 0; i < len1; i++)
        {
            pq.add(list1.get(i));
        }

        for (int i = 0; i < len2; i++)
        {
            pq.add(list2.get(i));
        }


        Interval cur = pq.poll();

        result.add(cur);

        Interval prev = cur;

        while(!pq.isEmpty())
        {
            cur = pq.poll();

            if (cur.start > prev.start)
            {
                if (cur.start > prev.end)
                {
                    result.add(cur);

                    prev = cur;

                    continue;

                } else if (cur.start <= prev.end)
                {
                    if (cur.end > prev.end)
                    {
                        result.get(result.size() - 1).end = cur.end;

                        prev = result.get(result.size() - 1);

                        continue;
                    } else if (cur.end <= prev.end)
                    {
                        continue;
                    }
                }
            } else if (cur.start == prev.start)
            {
                if (cur.end > prev.end)
                {
                    result.get(result.size() - 1).end = cur.end;

                    prev = result.get(result.size() - 1);

                    continue;
                } else if (cur.end <= prev.end)
                {
                    continue;
                }
            }
        }

        return result;
    }
}
