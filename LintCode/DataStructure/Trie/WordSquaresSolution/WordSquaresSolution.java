package Algorithm.LintCode.DataStructure.Trie.WordSquaresSolution;

import Algorithm.Public.Solution.Solution;
import Algorithm.Public.Utills.PrintUtills;

import java.util.ArrayList;
import java.util.List;

public class WordSquaresSolution extends Solution{

    public void test()
    {
        String[] words = new String[]{"abat","baba","atan","atal"};

        System.out.println("The words is shown below : ");

        PrintUtills.printStringArray(words);

        System.out.println("Result : \n");

        List<List<String>> result = wordSquares(words);

        PrintUtills.printListOfStringList(result);
    }

    class TrieNode
    {
        int ALPHA_SIZE = 26;

        TrieNode[] children = new TrieNode[ALPHA_SIZE];

        List<String> startsWith;

        TrieNode()
        {
            for (int i = 0; i < children.length; i++)
            {
                children[i] = null;
            }

            startsWith = new ArrayList<>();
        }

    }

    class Trie
    {
        TrieNode root;

        Trie(String[] words)
        {
            root = new TrieNode();

            for (String word : words){

                TrieNode cur = root;

                for (char c : word.toCharArray())
                {
                    int index = c - 'a';

                    if (cur.children[index] == null)
                        cur.children[index] = new TrieNode();

                    cur.startsWith.add(word);

                    cur = cur.children[index];
                }
            }

        }

        List<String> findWordsWithPrefix(String prefix)
        {
            TrieNode cur = root;

            List<String> result = new ArrayList<>();

            for (char c : prefix.toCharArray())
            {
                int index= c - 'a';

                if (cur.children[index] == null)
                    return result;

                cur = cur.children[index];
            }

            result.addAll(cur.startsWith);

            return result;
        }
    }

    public List<List<String>> wordSquares(String[] words) {
        // write your code here

        // For this problem, we need to use prefix tree and dfs
        // Why we use prefix tree?
        // Because when we insert word into squares, for example,
        // The result is [b a l l]
        //               [a r e a]
        // What is the next word prefix? we can decide the first 2 char right?
        // Follow the rule, the first 2 char of the third word is "l e"
        // So for ith row, we just need to the append all the ith char from the previous
        // words, and use it as a prefix to search in the prefix tree, then we get all the
        // candidates, then dfs, problem sovled.

        List<List<String>> result = new ArrayList<>();

        int len = words.length;

        if (len == 0)
            return result;

        int squareSize = words[0].length();

        if (squareSize == 0)
            return result;

        List<String> candidate = new ArrayList<>();

        Trie trie = new Trie(words);

        for (String word : words)
        {
            candidate.add(word);

            dfs(result, candidate, trie, squareSize);

            candidate.remove(candidate.size() - 1);
        }

        return result;
    }

    private void dfs(
            List<List<String>> result,
            List<String> candidate,
            Trie trie,
            int size)
    {
        if (candidate.size() == size)
        {
            result.add(new ArrayList<String>(candidate));
            return;
        }

        int index = candidate.size();


        StringBuilder prefixBuilder = new StringBuilder();

        for (int i = 0; i < index; i++)
        {
            prefixBuilder.append(candidate.get(i).charAt(index));
        }

        List<String> prefixCandidate
                = trie.findWordsWithPrefix(prefixBuilder.toString());

        for (String word : prefixCandidate)
        {
            candidate.add(word);

            dfs(result, candidate, trie, size);

            candidate.remove(candidate.size() - 1);
        }
    }
}
