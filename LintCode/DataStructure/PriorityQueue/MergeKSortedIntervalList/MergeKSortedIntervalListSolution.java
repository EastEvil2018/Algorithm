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

//    First : O(NlogK), keep an K-size PriorityQueue
    public class IntervalPack
    {
        public Interval interval;
        public int col, row;

        public IntervalPack(Interval interval, int col, int row)
        {
            this.interval = interval;

            this.col = col;

            this.row = row;
        }
    }

    public class IntervalPackComparator implements Comparator<IntervalPack>
    {
        public int compare(IntervalPack ip1, IntervalPack ip2)
        {
            Interval i1 = ip1.interval;
            Interval i2 = ip2.interval;

            if (i1.start < i2.start)
                return -1;
            if (i1.start > i2.start)
                return 1;

            if (i1.end < i2.end)
                return -1;
            if (i1.end > i2.end)
                return 1;

            return 0;
        }
    }

    public List<Interval> mergeKSortedIntervalLists(List<List<Interval>> intervals) {
        // write your code here

        List<Interval> result = new ArrayList<>();

        int K = intervals.size();

        if (K == 0)
            return result;

        PriorityQueue<IntervalPack> pq = new PriorityQueue<IntervalPack>(K, new IntervalPackComparator());

        for (int i = 0; i < K; i++)
        {
            List<Interval> cur = intervals.get(i);

            if (cur.size() == 0)
                continue;

            IntervalPack curIP = new IntervalPack(cur.get(0), i, 0);

            pq.add(curIP);
        }

        if (pq.isEmpty())
            return result;

        IntervalPack cur = pq.poll();

        Interval curElem = new Interval(cur.interval.start, cur.interval.end);

        result.add(curElem);

        Interval prevElem = new Interval(cur.interval.start, cur.interval.end);

        IntervalPack prev = new IntervalPack(prevElem, cur.col, cur.row);

        if (cur.row < intervals.get(cur.col).size() - 1)
        {
            cur.interval = intervals.get(cur.col).get(cur.row + 1);

            cur.row++;

            pq.add(cur);

        }


        while(!pq.isEmpty())
        {
            cur = pq.poll();

            Interval curInt = new Interval(cur.interval.start, cur.interval.end);

            Interval preInt = prev.interval;

            if (curInt.start > preInt.end)
            {


                result.add(curInt);

                prev.interval.start = cur.interval.start;

                prev.interval.end = cur.interval.end;

                System.out.println("Start : " + curInt.start + "End : " + curInt.end);

                int curCol = cur.col;

                int curRow = cur.row;

                if (curRow < intervals.get(curCol).size() - 1)
                {
                    cur.interval = intervals.get(curCol).get(curRow + 1);

                    cur.row++;

                    pq.add(cur);

                }


            } else if (curInt.start <= preInt.end)
            {
                if (curInt.end > preInt.end)
                {
                    result.get(result.size() - 1).end = curInt.end;

                    prev.interval.end = result.get(result.size() - 1).end;

                    int curCol = cur.col;

                    int curRow = cur.row;

                    if (curRow < intervals.get(curCol).size() - 1)
                    {
                        cur.interval = intervals.get(curCol).get(curRow + 1);

                        cur.row++;

                        pq.add(cur);

                    }


                } else if (curInt.end <= preInt.end)
                {
                    int curCol = cur.col;

                    int curRow = cur.row;

                    if (curRow < intervals.get(curCol).size() - 1)
                    {
                        cur.interval = intervals.get(curCol).get(curRow + 1);

                        cur.row++;

                        pq.add(cur);

                    }
                }
            }


        }

        return result;
    }
//    Second : Brute Force, O(NlogN)
//    public class IntervalComparator implements Comparator<Interval>
//    {
//        public int compare(Interval a, Interval b)
//        {
//            if (a.start < b.start)
//            {
//                return -1;
//            }
//
//            if (a.start > b.start)
//            {
//                return 1;
//            }
//
//
//            if (a.end < b.end)
//                return -1;
//
//            if (a.end > b.end)
//                return 1;
//
//            return 0;
//
//        }
//    }
//
//    public List<Interval> mergeKSortedIntervalLists(List<List<Interval>> intervals) {
//        // write your code here
//
//        PriorityQueue<Interval> pq = new PriorityQueue<Interval>(intervals.size(), new IntervalComparator());
//
//        int len = intervals.size();
//
//        for (int i = 0; i < len; i++)
//        {
//            List<Interval> cur = intervals.get(i);
//
//            int curSize = cur.size();
//
//            for (int j = 0; j < curSize; j++)
//            {
//                pq.add(cur.get(j));
//            }
//        }
//
//        List<Interval> result = new ArrayList<>();
//
//        Interval curInterval = pq.poll();
//
//        result.add(curInterval);
//
//        Interval prevInterval = curInterval;
//
//
//        while(!pq.isEmpty())
//        {
//            curInterval = pq.poll();
//
//            if (curInterval.start > prevInterval.start)
//            {
//                if (curInterval.start > prevInterval.end)
//                {
//                    result.add(curInterval);
//
//                    prevInterval = curInterval;
//
//                    continue;
//                } else
//                {
//                    if (curInterval.end <= prevInterval.end)
//                    {
//                        continue;
//                    } else
//                    {
//                        result.get(result.size() - 1).end = curInterval.end;
//
//                        prevInterval = result.get(result.size() - 1);
//                    }
//                }
//
//            } else if (curInterval.start == prevInterval.start)
//            {
//                if (curInterval.end <= prevInterval.end)
//                {
//                    continue;
//                } else if (curInterval.end > prevInterval.end)
//                {
//                    result.get(result.size() - 1).end = curInterval.end;
//
//                    prevInterval = result.get(result.size() - 1);
//
//                    continue;
//                }
//            }
//        }
//
//        return result;
//    }
}
