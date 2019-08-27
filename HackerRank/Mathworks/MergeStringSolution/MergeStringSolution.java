package Algorithm.HackerRank.Mathworks.MergeStringSolution;

import Algorithm.Public.Solution.Solution;
import org.junit.Assert;

public class MergeStringSolution extends Solution {

    @Override
    public void test() {

        Assert.assertTrue(mergeString("abc", "def").equals("adbecf") == true);
        Assert.assertTrue(mergeString("abc", "").equals("abc") == true);
        Assert.assertTrue(mergeString("", "").equals("") == true);
        Assert.assertTrue(mergeString("a", "def").equals("adef") == true);
        Assert.assertTrue(mergeString("", "def").equals("def") == true);

    }

    public String mergeString(String a, String b) {
        // append alternative character from a and b, respectively, to a new string
        // if all the characters of a or b have been appended,
        // then append the remaining characters of the other string to the end.
        String result = "";

        int aIndex = 0;
        int bIndex = 0;
        int aLen = a.length();
        int bLen = b.length();

        while (aIndex < aLen && bIndex < bLen) {
            if (aIndex == bIndex)
                result += a.charAt(aIndex++);
            else
                result += b.charAt(bIndex++);
        }

        while (aIndex < aLen)
            result += a.charAt(aIndex++);

        while (bIndex < bLen)
            result += b.charAt(bIndex++);

        return result;
    }
}
