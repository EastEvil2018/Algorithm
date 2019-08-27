package Algorithm.LintCode.DataStructure.PriorityQueue.TopKLargestNumberSolution;

import Algorithm.Public.Solution.Solution;
import Algorithm.Public.Utills.PrintUtills;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class TopKLargestNumberSolution extends Solution {

    public void test()
    {
        int k = 3;

        System.out.println("The K is " + k);

        TopKLargestNumberSolution testObj = new TopKLargestNumberSolution(k);

        int[] stream = new int[]{3, 5, 9, 11};

        System.out.println("The tested number stream is printed below : ");

        PrintUtills.printIntArray(stream);

        for (int i = 0; i < stream.length; i++)
        {
            testObj.add(stream[i]);
        }

        List<Integer> result = testObj.topk();

        System.out.println("The topk() result is printed below : ");

        PrintUtills.printIntegerList(result);
    }

    private int k;

    private PriorityQueue<Integer> pq = new PriorityQueue<Integer>(10, Collections.reverseOrder());

    private int pqSize = 0;
    /*
    * @param k: An integer
    */public TopKLargestNumberSolution(int k) {
        // do intialization if necessary
        this.k = k;
    }

    public TopKLargestNumberSolution()
    {

    }

    /*
     * @param num: Number to be added
     * @return: nothing
     */
    public void add(int num) {
        // write your code here
        pq.add(num);
        pqSize++;
    }

    /*
     * @return: Top k element
     */
    public List<Integer> topk() {
        // write your code here
        List<Integer> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        int num = 0;

        if (pqSize < k)
        {
            num = pqSize;
        } else
        {
            num = k;
        }

        for (int i = 0; i < num; i++)
        {
            int cur = pq.poll();
            result.add(cur);
            temp.add(cur);
        }

        for (int i = 0; i < num; i++)
        {
            pq.add(temp.get(i));
        }

        return result;
    }
}
