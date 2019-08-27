package Algorithm.Amazon.MostCommonWordsSolution;

import Algorithm.Public.Solution.Solution;
import Algorithm.Public.Utills.PrintUtills;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class MostCommonWordsSolution extends Solution {

    @Override
    public void test() {
        String literatureText = "Jack and Jill went to the market to buy bread and cheese. Cheese is Jack’s and Jill’s favorite food.";
        List<String> wordsToExclude = new ArrayList<>();
        wordsToExclude.add("and");
        wordsToExclude.add("he");
        wordsToExclude.add("the");
        wordsToExclude.add("to");
        wordsToExclude.add("is");
        wordsToExclude.add("Jack");
        wordsToExclude.add("Jill");

        System.out.println("Test begin : " + "\n" + " paragraph : " + literatureText);
        System.out.println("banned words : ");
        PrintUtills.printStringList(wordsToExclude);
        System.out.println("Output : ");
        PrintUtills.printStringList(mostCommonWords(literatureText, wordsToExclude));

    }

    public List<String> mostCommonWords(String paragraph, List<String> banned) {
        paragraph += ".";
        List<String> res = new ArrayList<>();

        HashMap<String, Integer> map = new HashMap<>();

        HashSet<String> banSet = new HashSet<>();

        for (String ban : banned)
            banSet.add(ban.toLowerCase());

        StringBuilder sb = new StringBuilder();

        int freq = 0;

        for (char c : paragraph.toCharArray()) {
            if (Character.isLetter(c)) {
                sb.append(Character.toLowerCase(c));
            } else if (sb.length() > 0) {
                String word = sb.toString();

                if (!banSet.contains(word)) {
                    map.put(word, map.getOrDefault(word, 0) + 1);
                    if (map.get(word) >= freq)
                        freq = map.get(word);
                }

                sb = new StringBuilder();
            }
        }

        for (String key : map.keySet()) {
            if (map.get(key) == freq)
                res.add(key);
        }

        return res;
    }
}
