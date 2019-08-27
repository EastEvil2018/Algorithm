package Algorithm.HackerRank.WePay.PowerNumberSolution;

import Algorithm.Public.DataStructure.Point;
import Algorithm.Public.Solution.Solution;
import org.junit.Assert;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

public class PowerNumberSolution extends Solution {
    @Override
    public void test() {

        Assert.assertTrue(PowerNumber(0) == 4);

        Assert.assertTrue("1th PowerNumber failed\n Return Value : " + PowerNumber(1),PowerNumber(1) == 8);

        Assert.assertTrue(PowerNumber(2) == 9);

        Assert.assertTrue(PowerNumber(3) == 16);
    }

    public class PairComparator implements Comparator<Point> {
        public int compare(Point p1, Point p2) {

            int a = (int)Math.pow(p1.x, p1.y);

            int b = (int)Math.pow(p2.x, p2.y);

            return a - b;
        }
    }

    public int PowerNumber(int index) {

        Point base = new Point(2, 2);

        PriorityQueue<Point> pq = new PriorityQueue<>(new PairComparator());

        HashSet<Integer> set = new HashSet<>();

        int result = 0;

        pq.add(base);

        set.add(result);

        for (int i = 0; i <= index; i++) {
            Point head = pq.poll();

            result = (int)Math.pow(head.x, head.y);

            if (!set.contains((int)Math.pow(head.x + 1, head.y))) {
                pq.add(new Point(head.x + 1, head.y));
                set.add((int)Math.pow(head.x + 1, head.y));
            }

            if (!set.contains((int)Math.pow(head.x, head.y + 1))) {
                pq.add(new Point(head.x, head.y + 1));
                set.add((int)Math.pow(head.x, head.y + 1));
            }
        }

        return result;
    }
}
