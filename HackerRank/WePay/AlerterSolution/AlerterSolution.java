package Algorithm.HackerRank.WePay.AlerterSolution;

import Algorithm.Public.Solution.Solution;

import java.text.DecimalFormat;
import java.util.*;
import org.junit.Assert;
import org.junit.Test;


/*

The Alerter is a simple monitoring tool, intended to help detect increases in response time for some process.

It does that by computing a few statistics about the process across a 'window' of a certain number of runs,

and alerting (returning true) if certain thresholds are met.

It takes the following parameters:

- inputs : A list of integer times for the process. This list may be very long.

- window size : how many runs long a window is, as an integer

- allowedIncrease : how far over 'average' a window or value is allowed to be, as a percent.

This is represented as a decimal value based on one, so a 50% allowable increase would be represented as 1.5.

Your Alerter should return true if either of the following conditions are met :

* Any value is more than the allowed increase above the window average in ALL windows in which it appears.

For example :

alert({1, 2, 100, 2, 2}, 3, 1.5) should return alert:

The value 100 appears in three windows, and in all cases is more than 50% over the average window.

alert({1, 2, 4, 2, 2}, 3, 2) should not alert:

The largest outlier is 4, and that value appears in a window with average 2.6, less than 100% of

that average.

* Any window's average is more than the acceptable increase over any previous window's average value.

For example :

alert({1, 2, 100, 2, 2}, 2, 2.5) should alert:

Even though individual value causes an alert, there is a window with average 1.5 and a later window

with an average more than 2.5 times larger.

* OtherWise, should return false.

*/
public class AlerterSolution extends Solution {

    @Override
    public void test() {

        List<Integer> testcase1 = new ArrayList<>();
        testcase1.add(1);
        testcase1.add(2);
        testcase1.add(100);
        testcase1.add(2);
        testcase1.add(2);

        Assert.assertTrue(alerter(testcase1, 3, (float) 1.5) == true);

        //1, 2, 4, 2, 2//
        List<Integer> testcase2 = new ArrayList<>();
        testcase2.add(1);
        testcase2.add(2);
        testcase2.add(4);
        testcase2.add(2);
        testcase2.add(2);

        Assert.assertTrue(alerter(testcase2, 3, (float) 2) == false);

        //{1, 2, 100, 2, 2}, 2, 2.5
        List<Integer> testcase3 = new ArrayList<>();
        testcase3.add(1);
        testcase3.add(2);
        testcase3.add(100);
        testcase3.add(2);
        testcase3.add(2);

        Assert.assertTrue(alerter(testcase3, 2, (float) 2.5) == true);


    }

    public Boolean alerter(List<Integer> inputs,
                           int windowSize,
                           float allowedIncrease){

        /*
        {1, 2, 100, 2, 2}, 3, 1.5

        create a queue

        queue.add(1)

        queue.add(2)

        queue.add(100)

        curAve = 1 + 2 + 100 / 3 = 34.3

        curMAxVal = 100

        prevMinAve = curAve = 34.3

        limit = curAve * 1.5 = 51.45

        curMaxVal > 51.45, alert


        */


        // we first scan the nums, and get the maximum sliding window, but which stores index

        int len = inputs.size();

        if (len == 0)
            return false;

        int[] maxSlidingWindow = new int[len - windowSize + 1];

        int index = 0;

        int i = 0;

        Deque<Integer> dq = new LinkedList<>();

        while (index < len) {
            while (!dq.isEmpty() && dq.peek() < index - windowSize + 1) {
                dq.poll();
            }

            while (!dq.isEmpty() && inputs.get(dq.peekLast()) < inputs.get(index)) {
                dq.pollLast();
            }

            dq.addLast(index);

            if (index >= windowSize - 1)
                maxSlidingWindow[i++] = dq.peek();

            index++;
        }


        // Then we scan the inputs twice, to get the average sliding window

        float[] aveSlidingWindow = new float[len - windowSize + 1];

        index = 0;

        i = 0;

        dq.clear();

        int sum = 0;

        while (index < len) {
            while (!dq.isEmpty() && dq.peek() < index - windowSize + 1) {
                sum -= inputs.get(dq.poll());
            }

            dq.addLast(index);

            sum += inputs.get(index);

            if (index >= windowSize - 1) {
                float ave = (float) sum / (float) windowSize;
                DecimalFormat newFormat = new DecimalFormat("#.##");
                ave =  Float.valueOf(newFormat.format(ave));
                aveSlidingWindow[i++] = ave;
            }

            index++;
        }

        // Now we get the maximum sliding window which stores the index of the maximum number in each window
        // And the average sliding window

        /*
        alert({1, 2, 100, 2, 2}, 3, 1.5)

        maximum sliding window = [2, 2, 2] // stores index, which inputs[2] = 100

        average sliding window = [34.33, 34.67, 34.67]
        */
        // We check if the first condition meets

        // Create a hashmap, for each individual maximum index, map it to the average in all windows it appears

        HashMap<Integer, List<Float>> map = new HashMap<>();

        index = 0;

        for (;index < len - windowSize + 1; index++) {
            int maxIndex = maxSlidingWindow[index];
            float ave = aveSlidingWindow[index];

            if (!map.containsKey(maxIndex)) {
                map.put(maxIndex, new ArrayList<Float>());
                map.get(maxIndex).add(ave);
            } else {
                map.get(maxIndex).add(ave);
            }
        }

        for (Integer maxIndex : map.keySet()) {
            List<Float> aves = map.get(maxIndex);
            int max = inputs.get(maxIndex);
            boolean shouldAlert = true;
            for (i = 0; i < aves.size(); i++) {
                float limit = aves.get(i) * allowedIncrease;

                if (max <= limit) {
                    shouldAlert = false;
                    break;
                }
            }

            if (shouldAlert)
                return true;
        }

        float prevMinAve = aveSlidingWindow[0];

        for (i = 1; i < aveSlidingWindow.length; i++) {

            float limit = prevMinAve * allowedIncrease;

            if (aveSlidingWindow[i] > limit)
                return true;

            if (aveSlidingWindow[i] < prevMinAve)
                prevMinAve = aveSlidingWindow[i];
        }
        return false;
    }


}
