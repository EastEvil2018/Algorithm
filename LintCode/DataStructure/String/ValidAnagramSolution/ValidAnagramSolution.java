package Algorithm.LintCode.DataStructure.String.ValidAnagramSolution;

import Algorithm.Public.Solution.Solution;

public class ValidAnagramSolution extends Solution{

    public void test()
    {
        String a = "abcd";

        String b = "bacd";

        System.out.println(a);

        System.out.println(b);

        System.out.println(anagram(a, b));
    }

    public boolean anagram(String s, String t) {
        // write your code here
        int[] memo = new int[256];

        for (char c : s.toCharArray())
        {
            memo[c]++;
        }

        for (char c : t.toCharArray())
        {
            memo[c]--;
        }

        for (char c : s.toCharArray())
        {
            if (memo[c] != 0)
                return false;
        }

        return true;
    }
}
