package Algorithm.Amazon.LongestStringMadeUpOfOnlyVowelsSolution;

import Algorithm.Public.Solution.Solution;
import org.junit.Assert;

import java.util.Map;

public class LongestStringMadeUpOfOnlyVowelsSolution extends Solution {

    @Override
    public void test() {
        Assert.assertTrue(longestStringMadeUpOfOnlyVowelsSolution("earthproblem") == 3);
        Assert.assertTrue(longestStringMadeUpOfOnlyVowelsSolution("letsgosomewhere") == 2);
    }

    private int longestStringMadeUpOfOnlyVowelsSolution(String str) {
        int len = str.length();

        int left = 0;

        int right = len - 1;


        while (left < len && isVowel(str.charAt(left))) {
            left++;
        }

        while (right >= 0 && isVowel(str.charAt(right))) {
            right--;
        }

        if (left == len)
            return len;

        int count = 0;
        int middleLength = 0;

        for (int i = left; i <= right; i++) {
            if (isVowel(str.charAt(i))) {
                count++;
            } else {
                middleLength = Math.max(count, middleLength);
                count = 0;
            }
        }



        return left + (len - right - 1) + middleLength;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
