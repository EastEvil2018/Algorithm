package Algorithm.LintCode.DataStructure.Interval.MergeIntervalsSolution;

import Algorithm.Public.DataStructure.Interval;
import Algorithm.Public.Solution.Solution;
import Algorithm.Public.Utills.PrintUtills;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeIntervalsSolution extends Solution {

    public void test()
    {
        List<Interval> intervals = new ArrayList<>();

        intervals.add(new Interval(1, 3));

        intervals.add(new Interval(2, 6));

        intervals.add(new Interval(8, 10));

        intervals.add(new Interval(15, 18));

        System.out.println("\nBefore Testing:\n");

        PrintUtills.printIntervalList(intervals);

        intervals = mergeIntervals(intervals);

        System.out.println("\nAfter Testing:\n");

        PrintUtills.printIntervalList(intervals);

    }

    public List<Interval> mergeIntervals(List<Interval> intervals) {
        // write your code here


        // First we need to sort this Interval List
        Collections.sort(intervals, new IntervalComparator());

        int len = intervals.size();

        if (len == 0)
            return new ArrayList<Interval>();

        Interval last = intervals.get(0);

        List<Interval> result = new ArrayList<>();


        for (int i = 1; i < len; i++)
        {
            Interval cur = intervals.get(i);

            if (cur.start <= last.end)
            {
                last.end = Math.max(last.end, cur.end);
            } else
            {
                result.add(last);
                last = cur;
            }
        }

        result.add(last);

        return result;

    }

    public class IntervalComparator implements Comparator<Interval>
    {
        public int compare(Interval i1, Interval i2)
        {
            return i1.start - i2.start;
        }
    }

}
