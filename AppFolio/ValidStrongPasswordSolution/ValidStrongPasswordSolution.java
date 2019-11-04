package Algorithm.AppFolio.ValidStrongPasswordSolution;

import Algorithm.Public.Solution.Solution;
import org.junit.Assert;

import java.util.HashSet;

public class ValidStrongPasswordSolution extends Solution {

    @Override
    public void test() {
        Assert.assertTrue(validStrongPassword("Daitx@19950602") == true);
        Assert.assertTrue(validStrongPassword("daitx@19950602") == false);
        Assert.assertTrue(validStrongPassword("Dtx19950602") == false);
        Assert.assertTrue(validStrongPassword("aaacc@33dF") == false);
    }

    public boolean validStrongPassword(String password) {
        // rules :
        // must include Upper and Lower Characters
        // must have special characters, ~@#$%^&*()
        // must have len >= 8
        // can not have 3 consecutive characters

        int len = password.length();
        if (len < 8)
            return false;

        HashSet<Character> set = new HashSet<Character>();
        set.add('~');
        set.add('@');
        set.add('#');
        set.add('$');
        set.add('%');
        set.add('^');
        set.add('&');
        set.add('*');
        set.add('(');
        set.add(')');

        boolean containsLower = false;
        boolean containsUpper = false;
        boolean containsSpecial = false;
        for (int i = 0; i < len; i++) {
            char c = password.charAt(i);

            if (i >= 2 && c == password.charAt(i - 1) && c == password.charAt(i - 2))
                return false;

            if (Character.isLetter(c)) {
                if (Character.isUpperCase(c))
                    containsUpper = true;
                else
                    containsLower = true;
            }

            if (set.contains(c))
                containsSpecial = true;

        }

        return containsUpper && containsLower && containsSpecial;
    }
}
