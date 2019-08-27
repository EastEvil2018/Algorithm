package Algorithm.LintCode.Sort.FourSumSolution;

import Algorithm.Public.Solution.Solution;
import Algorithm.Public.Utills.PrintUtills;

import java.util.*;

public class FourSumSolution extends Solution {

    public void test()
    {
        int[] numbers = new int[]{1, 0, -1, 0, -2, 2};

        int target = 0;

        System.out.println("The numbers array is printed below : ");

        PrintUtills.printIntArray(numbers);

        System.out.println("The target is printed as : " + target);

        List<List<Integer>> result = fourSum(numbers, target);

        System.out.println("The result is printed as below : ");

        PrintUtills.printListOfIntegerList(result);

    }

    public class Pair
    {
        public int firstIndex;

        public int secondIndex;

        public Pair(int firstIndex, int secondIndex)
        {
            this.firstIndex = firstIndex;

            this.secondIndex = secondIndex;
        }
    }
    public List<List<Integer>> fourSum(int[] numbers, int target) {
        // write your code here

        List<List<Integer>> result = new ArrayList<>();

        int len = numbers.length;

        if (len < 4)
            return result;

        Arrays.sort(numbers);

        HashMap<Integer, List<Pair>> map = getMap(numbers);

        for (int i = 0; i < len - 1; i++)
        {
            if (i != 0 && numbers[i] == numbers[i - 1])
                continue;
            for (int j = i + 1; j < len; j++)
            {
                if (j != i + 1 && numbers[j] == numbers[j - 1])
                    continue;

                int sum = numbers[i] + numbers[j];

                System.out.println(target - sum);

                if (map.containsKey(target - sum))
                {
                    System.out.println("Find");

                    List<Pair> pairs = map.get(target - sum);

                    for (Pair pair : pairs)
                    {
                        int firstIndex = pair.firstIndex;

                        int secondIndex = pair.secondIndex;

                        if (firstIndex != i && firstIndex != j && secondIndex != i && secondIndex != j)
                        {
                            List<Integer> candidate = new ArrayList<>();

                            candidate.add(numbers[firstIndex]);

                            candidate.add(numbers[secondIndex]);

                            candidate.add(numbers[i]);

                            candidate.add(numbers[j]);

                            Collections.sort(candidate);

                            if (!result.contains(candidate))
                                result.add(candidate);
                        }
                    }
                } else {
                    continue;
                }
            }
        }

        return result;

    }

    private HashMap<Integer, List<Pair>> getMap(int[] numbers)
    {
        HashMap<Integer, List<Pair>> map = new HashMap<>();

        int len = numbers.length;

        for (int i = 0; i < len - 1; i++)
        {
            for (int j = i + 1; j < len; j++)
            {
                int sum = numbers[i] + numbers[j];

                if (map.containsKey(sum))
                {
                    map.get(sum).add(new Pair(i, j));
                } else
                {
                    List<Pair> pairs = new ArrayList<>();

                    pairs.add(new Pair(i, j));

                    map.put(sum, pairs);
                }
            }
        }

        return map;
    }
}
