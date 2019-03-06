package Algorithm.LintCode.DataStructure.String.AddParenthesesSolution;

import Algorithm.Public.Solution.Solution;

public class AddParenthesesSolution extends Solution {

    public void test()
    {
        String test = ")(()(";

        test = "(()))))((())";

        String result = AddParentheses(test);

        System.out.println("The test str is printed as  : " + test);

        System.out.println("The result is printed as : " + result);
    }

    public String AddParentheses(String str)
    {
        int leftLackCount = 0;

        int rightLackCount = 0;

        for (char c : str.toCharArray())
        {
            if (c == '(')
            {
                rightLackCount++;
            }
            else if (c == ')')
            {
                if (rightLackCount == 0)
                    leftLackCount++;
                else
                    rightLackCount--;
            }

        }

        for (int i = 0; i < leftLackCount; i++)
        {
            str = '(' + str;
        }

        for (int i = 0; i < rightLackCount; i++)
        {
            str = str + ')';
        }

        return str;
    }
}
