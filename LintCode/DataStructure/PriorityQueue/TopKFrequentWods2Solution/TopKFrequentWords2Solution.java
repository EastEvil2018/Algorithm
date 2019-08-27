package Algorithm.LintCode.DataStructure.PriorityQueue.TopKFrequentWods2Solution;

import Algorithm.Public.Solution.Solution;
import Algorithm.Public.Utills.PrintUtills;

import java.util.*;

public class TopKFrequentWords2Solution extends Solution {

    public void test()
    {
        int k = 2;

        System.out.println("The K is " + k);

        TopK(k);

        String[] streams = new String[]{"lint", "code", "code"};

        for(int i = 0; i < streams.length; i++)
        {
            add(streams[i]);
        }

        System.out.println("The tested streams is printed below : ");

        PrintUtills.printStringArray(streams);

        List<String> result = topk();

        System.out.println("The result is printed below : ");

        PrintUtills.printStringList(result);
    }

    private HashMap<String, Integer> map;

    private TreeSet<String> kSet;

    private int k;

    public class WordComparator implements Comparator<String>
    {
        public int compare(String s1, String s2)
        {
            if (s1.equals(s2))
                return 0;

            int s1Freq = map.get(s1);

            int s2Freq = map.get(s2);

            if (s1Freq != s2Freq)
                return s2Freq - s1Freq;

            return s1.compareTo(s2);
        }
    }
    /*
    * @param k: An integer
    */public void TopK(int k) {
        // do intialization if necessary
        map = new HashMap<String, Integer>();

        kSet = new TreeSet<String>(new WordComparator());

        this.k = k;
    }

    /*
     * @param word: A string
     * @return: nothing
     */
    public void add(String word) {
        // write your code here

        if (!map.containsKey(word))
        {
            map.put(word, 1);
        } else
        {
            kSet.remove(word);
            map.put(word, map.get(word) + 1);
        }

        kSet.add(word);

        if (kSet.size() > k)
            kSet.remove(kSet.last());

    }

    /*
     * @return: the current top k frequent words.
     */
    public List<String> topk() {
        // write your code here

        List<String> result = new ArrayList<>();

        Iterator<String> it = kSet.iterator();

        while(it.hasNext())
        {
            String cur = it.next();
            result.add(cur);
        }

        return result;
    }
}
