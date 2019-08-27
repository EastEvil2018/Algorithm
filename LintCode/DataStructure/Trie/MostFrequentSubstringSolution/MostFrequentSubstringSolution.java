package Algorithm.LintCode.DataStructure.Trie.MostFrequentSubstringSolution;

import Algorithm.Public.DataStructure.Trie;

import Algorithm.Public.Solution.Solution;

import java.util.HashSet;

public class MostFrequentSubstringSolution extends Solution {

    public void test()
    {
        // Here we should write some test cases here

        int maxFrequency = mostFrequentSubstring(6,2,3, 4,"ababab");

        System.out.print(maxFrequency);


    }


    Trie root = new Trie();

    int maxFrequency = 0;

    HashSet<Character> uniqueCharSet = new HashSet<>();

    public int mostFrequentSubstring(int strLen, int minLen, int maxLen, int maxUniqueSize, String str)
    {
        if (str == null || strLen == 0)
        {
            return 0;
        }

        if (minLen <= 0 || maxLen <= 0 || maxUniqueSize <= 0)
        {
            return 0;
        }


        int rightBound = strLen - minLen;
        for (int i = 0; i <= rightBound; i++)
        {

            if (i + minLen > strLen)
                break;

            String candidate = str.substring(i, i + minLen);

            int curFrequency = insertTrie(candidate, maxUniqueSize);

            if (curFrequency == - 1)
                break;

            System.out.println(candidate);
            System.out.println(curFrequency);

            maxFrequency = Math.max(maxFrequency, curFrequency);


        }


        return maxFrequency;
    }

    public int insertTrie(String candidate, int maxUniqueCharSize)
    {
        uniqueCharSet.clear();

        Trie parent = root;

        for (char c : candidate.toCharArray())
        {
            uniqueCharSet.add(c);

            if (uniqueCharSet.size() > maxUniqueCharSize)
                return -1;

            int index = c - 'a';

            if (parent.children[index] == null)
                parent.children[index] = new Trie();

            parent = parent.children[index];
        }

        if (parent.word == null)
        {
            parent.word = candidate;

            parent.frequency = 1;
        } else {
            parent.frequency++;
        }

        return parent.frequency;
    }

}
