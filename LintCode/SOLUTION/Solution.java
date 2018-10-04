package Algorithm.LintCode.Solution;

import java.io.File;
import java.net.URL;
import java.util.Scanner;

public class Solution implements AbstractSolution{

    public void run()
    {
        this.describe();

        this.test();

        this.explain();
    }

    private void describe()
    {
        // Here we should show some descriptions for this problem

        try
        {
            URL url = getClass().getResource("Description.txt");

            File file = new File(url.getPath());

            Scanner sc = new Scanner(file);

            while (sc.hasNextLine())
                System.out.println(sc.nextLine());

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }

    public void test()
    {
        // TODO : implement test in subcalss
    };

    private void explain()
    {
        // Here we should explain the solution

        try
        {
            URL url = getClass().getResource("Explanation.txt");

            File file = new File(url.getPath());

            Scanner sc = new Scanner(file);

            while (sc.hasNextLine())
                System.out.println(sc.nextLine());

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
