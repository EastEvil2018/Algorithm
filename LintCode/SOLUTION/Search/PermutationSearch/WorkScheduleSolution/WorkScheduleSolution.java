package Algorithm.LintCode.SOLUTION.Search.PermutationSearch.WorkScheduleSolution;

import Algorithm.LintCode.SOLUTION.Solution;

import java.util.ArrayList;
import java.util.List;

public class WorkScheduleSolution implements Solution {

    public void run()
    {
        // Here we should write some test cases

        List<String> result = new ArrayList<>();

        result = workSchedule("080??80",4,20);

        for (int i = 0; i < result.size(); i++)
        {
            System.out.println(result.get(i));
        }
    }

    public void describe()
    {
        // Here we should show some descriptions for this problem
    }

    public List<String> workSchedule(String candidate, int dailyMaxHours, int weeklyMaxHours)
    {
        List<String> result = new ArrayList<>();

        if (dailyMaxHours <= 0 || weeklyMaxHours <= 0)
            return result;

        StringBuilder sb = new StringBuilder();

        dfs(result, candidate, dailyMaxHours, weeklyMaxHours, sb);

        return result;

    }

    public void dfs(List<String> result, String candidate, int dailyMaxHours, int weeklyMaxHours, StringBuilder sb)
    {
        if (sb.length() == candidate.length())
        {
            if (weeklyMaxHours == 0)
                result.add(new String(sb.toString()));

            return;
        }

        if (candidate.charAt(sb.length()) != '?')
        {
            int curHour = Integer.parseInt(Character.toString(candidate.charAt(sb.length())));

            // System.out.println("Cur Hour : " + curHour);

            if (weeklyMaxHours - curHour < 0)
                return;

            sb.append(candidate.charAt(sb.length()));

            // System.out.println("Fixed : " + sb.toString());

            dfs(result, candidate, dailyMaxHours, weeklyMaxHours - curHour, sb);

            sb.deleteCharAt(sb.length() - 1);

            return;
        }


        for (int i = 0; i <= dailyMaxHours; i++)
        {
            if (weeklyMaxHours - i < 0)
            {
                System.out.println("Hours Exceed : " + i);
                break;
            }

            sb.append(Integer.toString(i).charAt(0));

            dfs(result, candidate, dailyMaxHours, weeklyMaxHours - i, sb);

            sb.deleteCharAt(sb.length() - 1);

        }

    }
}
