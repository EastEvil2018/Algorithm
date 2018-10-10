package Algorithm.LintCode.Search.BackTracking.FindMissingNumber2Solution;

import Algorithm.Public.Solution.Solution;
import Algorithm.Public.Utills.PrintUtills;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindMissingNumber2Solution extends Solution{

    public void test()
    {


        int n = 28;

        String str = "111097654281222131272625242321320191817161514";

        findMissing2(n, str);
    }

    public int findMissing2(int n, String str) {
        // write your code here

        // Since th n <= 30, for recursion, we just need to check if we cut the string in 1 or 2 digit.

        // And if we finally get the only answer, return the missing number

        // If not, return -1;

        if (n == 1)
            return 1;

        List<Integer> result = new ArrayList<>();

        return dfs(n, str, result);

    }


    private int dfs(int n, String str, List<Integer> result)
    {
        if (result.size() == n - 1 && str.length() == 0)
        {
            return findMissing(n, result);
        }

        int length = str.length();

        int loopTime = (length < 2) ? length : 2;

        for (int i = 1; i <= loopTime; i++)
        {
            String substring = str.substring(0, i);

            String nextStr = str.substring(i);

            int cur = Integer.parseInt(substring);

            if (result.contains(cur))
                continue;

            if (cur == 0)
                continue;

            if (cur > n)
                continue;

            if (substring.charAt(0) == '0')
                continue;

            result.add(cur);

            int miss = dfs(n, nextStr, result);

            if (miss != -1)
                return miss;

            result.remove(result.size() - 1);
        }

        return -1;
    }

    private int findMissing(int n, List<Integer> result)
    {

        Collections.sort(result);

        PrintUtills.printIntegerList(result);

        for (int i = 1; i < n; i++)
        {
            if(result.get(i - 1) != i)
                return i;
        }

        return n;
    }
}
