package Algorithm.LintCode.Search.BackTracking.PalindromePermutation2Solution;

import Algorithm.Public.Solution.Solution;
import Algorithm.Public.Utills.PrintUtills;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class PalindromePermutation2Solution extends Solution {
    public void test()
    {
        String s = "aabb";

        System.out.println("The String is " + s);


        List<String> result = generatePalindromes(s);

        System.out.println("The test result is :");

        PrintUtills.printStringList(result);
    }

    public List<String> generatePalindromes(String s) {
        // write your code here
        List<String> result = new ArrayList<>();

        char[] strArr = s.toCharArray();

        Arrays.sort(strArr);

        HashMap<Character, Integer> map = getCharMap(strArr);

        int oddCount = 0;

        for (Character key : map.keySet())
        {
            if (map.get(key) % 2 == 1)
                oddCount++;
        }

        if (oddCount > 1)
            return result;

        StringBuilder sb = new StringBuilder();

        char pivot = ' ';

        for (Character key : map.keySet())
        {
            int count = map.get(key);

            if (count % 2 == 0)
            {
                for (int i = 0; i < count / 2; i++)
                {
                    sb.append(key);
                }
            }

            if (count % 2 == 1)
            {
                pivot = key;
                for (int i = 0; i < (count - 1) / 2; i++)
                {
                    sb.append(key);
                }
            }
        }


        strArr = sb.toString().toCharArray();

        int len = strArr.length;

        boolean[] visited = new boolean[len];

        sb = new StringBuilder();

        dfs(result, len, visited, sb, strArr);

        List<String> newResult = new ArrayList<>();

        for (int i = 0; i < result.size(); i++)
        {
            String cur = result.get(i);

            char[] reverse = new char[cur.length()];

            for (int j = 0; j < cur.length(); j++)
                reverse[j] = cur.charAt(cur.length() - j - 1);

            String rev = String.valueOf(reverse);


            StringBuilder output = new StringBuilder();

            if (pivot != ' ')
            {
                output.append(cur);
                output.append(pivot);
                output.append(rev);
                newResult.add(output.toString());
            } else
            {
                output.append(cur);
                output.append(rev);
                newResult.add(output.toString());
            }
        }

        return newResult;
    }

    private HashMap<Character, Integer> getCharMap(char[] strArr)
    {
        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : strArr)
        {
            if (!map.containsKey(c))
                map.put(c, 1);
            else
                map.put(c, map.get(c) + 1);

        }
        return map;
    }

    private void dfs(List<String> result, int len, boolean[] visited, StringBuilder sb, char[] strArr)
    {
        if (sb.length() == len)
        {
            result.add(new String(sb.toString()));
            return;
        }

        for (int i = 0; i < len; i++)
        {
            if (i != 0 && strArr[i] == strArr[i - 1] && visited[i - 1] == false)
            {
                continue;
            }

            if (visited[i] == true)
                continue;

            sb.append(strArr[i]);

            visited[i] = true;

            dfs(result, len, visited, sb, strArr);

            visited[i] = false;

            sb.deleteCharAt(sb.length() - 1);
        }
    }

}
