package Algorithm.Amazon.ShopkeeperSaleSolution;

import Algorithm.Public.Solution.Solution;
import Algorithm.Public.Utills.PrintUtills;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ShopkeeperSaleSolution extends Solution {

    @Override
    public void test() {
        int[] prices = new int[]{5,1,3,4,6,2};
        Assert.assertTrue(shopkeeper(prices) == 14);

        prices = new int[]{1,3,3,2,5};

        Assert.assertTrue(shopkeeper(prices) == 9);

        prices = new int[]{5, 4, 5, 1, 3, 3, 8, 2};

        Assert.assertTrue(shopkeeper(prices) == 18);
    }

    private int shopkeeper(int[] prices) {
        int len = prices.length;
        int[] discounted = new int[len];

        Stack<int[]> stack = new Stack<>();

        int sum = 0;


        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && stack.peek()[0] >= prices[i]) {
                int[] ori = stack.pop();
                discounted[ori[1]] = ori[0] - prices[i];
                sum += discounted[ori[1]];
            }

            stack.push(new int[]{prices[i], i});
        }

        List<Integer> noDiscount = new ArrayList<>();

        while (!stack.isEmpty()) {
            int[] ori = stack.pop();
            noDiscount.add(0, ori[1]);
            discounted[ori[1]] = ori[0];
            sum += discounted[ori[1]];
        }

        PrintUtills.printIntArray(discounted);
        PrintUtills.printIntegerList(noDiscount);

        return sum;
    }
}
