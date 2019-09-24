package Algorithm.Google.PizzaShopSolution;

import Algorithm.Public.Solution.Solution;
import org.junit.Assert;

import java.util.Arrays;

public class PizzaShopSolution extends Solution {

    @Override
    public void test() {
        int[] p1 = new int[]{800, 850, 900};
        int[] t1 = new int[]{100, 150};

        Assert.assertTrue(pizzaShop(p1, t1, 1000) == 1000);

        int[] p2 = new int[]{850, 900};
        int[] t2 = new int[]{200, 250};

        Assert.assertTrue(pizzaShop(p2, t2, 1000) == 1050);

        int[] p3 = new int[]{1100, 900};
        int[] t3 = new int[]{200};

        Assert.assertTrue(pizzaShop(p3, t3, 1000) == 900);

        int[] p4 = new int[]{800, 800, 800, 800};
        int[] t4 = new int[]{100};

        Assert.assertTrue(pizzaShop(p4, t4, 1000) == 900);
    }

    private int pizzaShop(int[] pizzas, int[] toppings, int price) {
        int pLen = pizzas.length;
        int tLen = toppings.length;

        Arrays.sort(pizzas);
        Arrays.sort(toppings);

        int res = pizzas[0];
        int dif = price - pizzas[0];
        for (int i = 0; i < pLen; i++) {
            int rest = price - pizzas[i];

            if (rest == 0)
                return price;
            else if (rest < 0 && Math.abs(rest) < dif) {
                res = pizzas[i];
            } else if (rest > 0) {
                int left = -1;
                int right = tLen - 1;

                while (left < right) {
                    int leftT = left == -1 ? 0 : toppings[left];
                    int rightT = toppings[right];
                    if (leftT + rightT == rest) {
                        return price;
                    } else if (leftT + rightT < rest) {
                        left++;
                    } else {
                        right--;
                    }

                    if (Math.abs(leftT + rightT - rest) < dif) {
                        dif = Math.abs(leftT + rightT - rest);
                        res = pizzas[i] + leftT + rightT;
                    }
                }
            }
        }

        return res;
    }
}
