package Algorithm.LintCode.Sort.SortLettersByCaseSolution;

import Algorithm.Public.Solution.Solution;
import Algorithm.Public.Utills.PrintUtills;

public class SortLettersByCaseSolution extends Solution {

    public void test()
    {
        char[] chars = new char[]{'a', 'b', 'A', 's', 'D', 'S'};

        System.out.println("The tested chars is printed below : ");

        PrintUtills.printCharArray(chars);

        sortLetters(chars);

        System.out.println("The tested result is printed below : ");

        PrintUtills.printCharArray(chars);

    }

    public void sortLetters(char[] chars) {
        // write your code here

        int len = chars.length;

        if (len < 2)
            return;

        int start = 0;

        int end = len - 1;

        while (start < end)
        {
            char left = chars[start];

            char right = chars[end];

            if (isCharLowerCase(left) && isCharLowerCase(right))
            {
                start++;
            } else if (isCharLowerCase(left) && !isCharLowerCase(right))
            {
                start++;
                end--;
            } else if (!isCharLowerCase(left) && isCharLowerCase(right))
            {
                char temp = chars[start];

                chars[start] = chars[end];

                chars[end] = temp;

                start++;
                end--;

            } else
            {
                end--;
            }
        }
    }

    private boolean isCharLowerCase(char c)
    {
        return (c >= 97 && c <= 122);
    }
}
