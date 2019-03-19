package Algorithm.HackerRank.Mathworks.SubStringsSolution;

import Algorithm.Public.Solution.Solution;
import Algorithm.Public.Utills.PrintUtills;
import org.junit.Assert;

import java.util.*;

public class SubStringsSolution extends Solution {


    /*
    Consider a string, s = "bac".
    An alphabetically-ordered sequence of substrings of s would be ("a", "ab", "abc", "b", "bc", "c").
    If we reduce this sequence to only those substrings that start with a vowel and end with a consonant,
    we are left with ("ab", "abc").
    The alphabetically first element in this reduced list is "ab", and the alphabetically last element is "abc".
    As a reminder:
    • Vowels: a, e, i, o, and u.
    • Consonants: b, c, d, f, g, h,j, k, I, m, n, p, q, r, s, t, v, w, x, y, and z.
    Complete the findSubstrings function in your editor.
    It has 1 parameter: a string, s,
    consisting of lowercase English letters (a — z).
    The function must find the substrings of s that start with a vowel and end with a consonant,
    then print he alphabetically first and alphabetically last of these substrings.
    */
    @Override
    public void test() {
        Assert.assertTrue(findSubstrings("abc").equals("ab abc") == true);
        Assert.assertTrue(findSubstrings("aba").equals("ab ab") == true);
        Assert.assertTrue(findSubstrings("aab").equals("aab ab") == true);
    }

    HashSet<Character> vowels;

    public SubStringsSolution() {
        Character[] vowelsArr = new Character[]{'a', 'e', 'i', 'o', 'u'};

        vowels = new HashSet<>(Arrays.asList(vowelsArr));
    }

    public String findSubstrings(String s) {
        String result = "";
        int len = s.length();
        List<Integer> vowelsWindow= new ArrayList<>();
        List<Integer> cononantsWindow = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (isCononants(c)) {
                cononantsWindow.add(i);
            } else {
                vowelsWindow.add(i);
            }
        }

        int start = 0;

        HashSet<String> set = new HashSet<>();
        List<String> order = new ArrayList<>();
        while (start < vowelsWindow.size()) {
            int vowelIndex = vowelsWindow.get(start);

            int end = cononantsWindow.size() - 1;

            while (end >= 0) {
                int cononantIndex = cononantsWindow.get(end);

                if (vowelIndex > cononantIndex)
                    break;

                String substring = s.substring(vowelIndex, cononantIndex + 1);

                if (!set.contains(substring)) {
                    set.add(substring);
                    order.add(substring);
                }
                end--;
            }
            start++;
        }

        Collections.sort(order);
        PrintUtills.printStringList(order);
        result = order.get(0) + " " + order.get(order.size() - 1);
        return result;
    }

    private boolean isCononants(char c) {
        return !vowels.contains(c);
    }

}
