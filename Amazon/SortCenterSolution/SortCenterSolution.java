package Algorithm.Amazon.SortCenterSolution;

import Algorithm.Public.Solution.Solution;
import Algorithm.Public.Utills.PrintUtills;

import java.util.HashMap;

public class SortCenterSolution extends Solution {

    @Override
    public void test() {
        int[] test = new int[]{1, 10, 25, 35, 60};
        int testTruck = 90;

        System.out.println("Begin Test : ");
        PrintUtills.printIntArray(test);
        System.out.println("Truck Space : " + testTruck);
        System.out.println("Res : ");
        PrintUtills.printIntArray(sortCenter(testTruck, test));
    }

    public int[] sortCenter(int truckSpace, int[] packages) {

        HashMap<Integer, Integer> map = new HashMap<>();

        truckSpace -= 30;

        if (truckSpace <= 0)
            return new int[]{-1, -1};

        for (int i = 0; i < packages.length; i++) {
            int remain = truckSpace - packages[i];

            if (map.containsKey(remain))
                return new int[]{i, map.get(remain)};


            map.put(packages[i], i);
        }

        return new int[]{-1, -1};
    }
}
