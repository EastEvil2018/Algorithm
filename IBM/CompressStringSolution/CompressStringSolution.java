package Algorithm.IBM.CompressStringSolution;

import Algorithm.Public.Solution.Solution;
import org.junit.Assert;

public class CompressStringSolution extends Solution {

    @Override
    public void test() {

        Assert.assertTrue(compressString("alaasass").equals("ala2sas2"));

        Assert.assertTrue(compressString("abc").equals("abc"));

        Assert.assertTrue(compressString("abaabbbc").equals("aba2b3c"));

    }

    public String compressString(String s) {
        if (s == null)
            return s;

        int len = s.length();

        if (len == 1)
            return s;

        char cur = s.charAt(0);
        int count = 1;
        String res = "";

        for (int i = 1; i < len; i++) {
            if (s.charAt(i) == cur) {
                count++;
            } else {
                res += cur;
                if (count != 1)
                    res += String.valueOf(count);
                cur = s.charAt(i);
                count = 1;
            }
        }

        res += cur;
        if (count != 1)
            res += String.valueOf(count);

        //System.out.println(res);

        return res;
    }
}
