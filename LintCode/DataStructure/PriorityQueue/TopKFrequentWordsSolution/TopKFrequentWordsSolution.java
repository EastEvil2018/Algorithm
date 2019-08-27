package Algorithm.LintCode.DataStructure.PriorityQueue.TopKFrequentWordsSolution;

import Algorithm.Public.Solution.Solution;
import Algorithm.Public.Utills.PrintUtills;

import java.util.*;

public class TopKFrequentWordsSolution extends Solution {
    public void test()
    {
        String[] words = new String[]{ "yes", "lint", "code",
                                       "yes", "code", "baby",
                                       "you", "baby", "chrome",
                                       "safari", "lint", "code",
                                       "body", "lint", "code"};

        System.out.println("The given String array is printed below : ");

        PrintUtills.printStringArray(words);

        int k = 3;

        System.out.println("The k is given as " + k);

        System.out.println("The test result is printed below : ");

        String[] result = topKFrequentWords(words, k);

        PrintUtills.printStringArray(result);

    }

//    First, construct a K-size PriorityQueue, take O(NlognK)
    class frequencyWord
    {
        public String word;
        public int frequecy;

        public frequencyWord(String word, int frequecy)
        {
            this.word = word;
            this.frequecy = frequecy;
        }
    }

    class frequecyComparator implements Comparator<frequencyWord>
    {
        public int compare(frequencyWord w1, frequencyWord w2)
        {
            if (w1.frequecy > w2.frequecy)
                return 1;
            if (w1.frequecy < w2.frequecy)
                return -1;

            return (w2.word.compareTo(w1.word));


        }
    }

    public String[] topKFrequentWords(String[] words, int k) {
        // write your code here
        String[] result = new String[k];

        if (k == 0)
            return result;

        HashMap<String, Integer> map = new HashMap<>();

        for (String word : words)
        {
            if (!map.containsKey(word))
            {
                map.put(word, 1);
            } else
            {
                map.put(word, map.get(word) + 1);
            }
        }

        List<frequencyWord> freWordList = new ArrayList<>();

        for (String key : map.keySet()) {

            frequencyWord newWord = new frequencyWord(key, map.get(key));

            freWordList.add(newWord);
        }

        PriorityQueue<frequencyWord> pq =
                new PriorityQueue<frequencyWord>(k, new frequecyComparator());

        for (int i = 0; i < freWordList.size(); i++)
        {
            frequencyWord curWord = freWordList.get(i);

            frequencyWord peekWord = pq.peek();

            if (pq.size() < k)
            {
                pq.add(curWord);
            } else if (new frequecyComparator().compare(curWord, peekWord) > 0)
            {
                pq.poll();

                pq.add(curWord);
            }
        }


        for (int i = 0; i < k; i++)
        {
            String cur = pq.poll().word;
            result[i] = cur;
        }

        for (int i = 0; i < k / 2; i++)
        {
            String temp = result[i];

            result[i] = result[k - i - 1];

            result[k - i - 1] = temp;
        }

        return result;
    }

//    Second, brute-force, construct a N-size PriorityQueue, take O(NlogN)
//    class frequencyWord
//    {
//        public String word;
//        public int frequecy;
//
//        public frequencyWord(String word, int frequecy)
//        {
//            this.word = word;
//            this.frequecy = frequecy;
//        }
//    }
//
//    class frequecyComparator implements Comparator<frequencyWord>
//    {
//        public int compare(frequencyWord w1, frequencyWord w2)
//        {
//            if (w1.frequecy > w2.frequecy)
//                return -1;
//            if (w1.frequecy < w2.frequecy)
//                return 1;
//
//            return (w1.word.compareTo(w2.word));
//
//
//        }
//    }
//
//    public String[] topKFrequentWords(String[] words, int k) {
//        // write your code here
//
//        HashMap<String, Integer> map = new HashMap<>();
//
//        for (String word : words)
//        {
//            if (!map.containsKey(word))
//            {
//                map.put(word, 1);
//            } else
//            {
//                map.put(word, map.get(word) + 1);
//            }
//        }
//
//        List<frequencyWord> freWordList = new ArrayList<>();
//
//        for (String key : map.keySet()) {
//
//            frequencyWord newWord = new frequencyWord(key, map.get(key));
//
//            freWordList.add(newWord);
//        }
//
//        PriorityQueue<frequencyWord> pq =
//                new PriorityQueue<frequencyWord>(freWordList.size(), new frequecyComparator());
//
//        for (int i = 0; i < freWordList.size(); i++)
//        {
//            pq.add(freWordList.get(i));
//        }
//
//        String[] result = new String[k];
//
//        for (int i = 0; i < k; i++)
//        {
//            String cur = pq.poll().word;
//            result[i] = cur;
//        }
//
//        return result;
//    }
}
