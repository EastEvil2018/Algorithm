package Algorithm.Clutter.BeforeAndAfterPuzzleSolution;

import Algorithm.Public.Solution.Solution;
import Algorithm.Public.Utills.PrintUtills;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class BeforeAndAfterPuzzleSolution extends Solution {

    @Override
    public void test() {
        List<String> testcase1 = new ArrayList<>();
        testcase1.add("write code");
        testcase1.add("code rocks");

        PrintUtills.printStringList(beforeAndAfterPuzzle(testcase1));

        List<String> testcase2 = new ArrayList<>();
        testcase2.add("mission statement");
        testcase2.add("a quick bite to eat");
        testcase2.add("a chip off the old block");
        testcase2.add("chocolate bar");
        testcase2.add("mission impossible");
        testcase2.add("a man on a mission");
        testcase2.add("block party");
        testcase2.add("eat my words");
        testcase2.add("bar of soap");

        PrintUtills.printStringList(beforeAndAfterPuzzle(testcase2));
    }

    private List<String> beforeAndAfterPuzzle(List<String> phases) {
        HashMap<String, List<String>> wordToPhases = new HashMap<>();

        for (String phase : phases) {
            String[] arr = phase.split(" ");

            String first = arr[0];

            wordToPhases.computeIfAbsent(first, (key) -> (new ArrayList<>()));

            wordToPhases.get(first).add(phase);
        }


        List<String> res = new ArrayList<>();

        for (String phase : phases) {
            String[] arr = phase.split(" ");

            String last = arr[arr.length - 1];

            if (wordToPhases.containsKey(last) == false)
                continue;

            String newHeader = "";

            for (int i = 0; i < arr.length - 1; i++)
                newHeader += arr[i] + " ";

            //System.out.println("Header : " + newHeader);
            for (String tail : wordToPhases.get(last)) {
                //System.out.println("Tail : " + tail);
                res.add(newHeader + tail);
            }
        }


        return res;
    }
}
