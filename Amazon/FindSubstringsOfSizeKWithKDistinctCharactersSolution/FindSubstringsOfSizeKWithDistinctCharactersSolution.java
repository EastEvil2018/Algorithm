package Algorithm.Amazon.FindSubstringsOfSizeKWithKDistinctCharactersSolution;

import Algorithm.Public.Solution.Solution;
import Algorithm.Public.Utills.PrintUtills;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FindSubstringsOfSizeKWithDistinctCharactersSolution extends Solution {

    @Override
    public void test() {

        String inputStr = "awaglknagawunagwkwagl";
        int num = 4;

        System.out.println("test for " + inputStr + " " + num + " : ");

        PrintUtills.printStringList(findSubstringOfSizeKWithDistinctCharacters("awaglknagawunagwkwagl", 4));
    }

    public List<String> findSubstringOfSizeKWithDistinctCharacters(String str, int num) {
        List<String> result = new ArrayList<>();

        int len = str.length();

        if (num > len)
            return result;

        int[] map = new int[26];

        for (int i = 0; i < num; i++) {
            map[str.charAt(i) - 'a']++;
        }

        int count = 0;

        for (int freq : map) {
            if (freq <= 1)
                count++;
        }


        int index = 0;

        HashSet<String> set = new HashSet<>();

        while (index <= len - num) {
            if (count == 26) {
                String sub = str.substring(index, index + num);
                set.add(sub);
            }

            if (index == len - num)
                break;

            int left = str.charAt(index) - 'a';

            map[left]--;

            if (map[left] == 1)
                count++;

            int right = str.charAt(index + num) - 'a';

            map[right]++;

            if (map[right] >= 2)
                count--;

            index++;
        }

        for (String cand : set)
            result.add(cand);

        return result;
    }
}
