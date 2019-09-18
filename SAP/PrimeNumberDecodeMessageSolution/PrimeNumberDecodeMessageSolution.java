package Algorithm.SAP.PrimeNumberDecodeMessageSolution;

import Algorithm.Public.Solution.Solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class PrimeNumberDecodeMessageSolution extends Solution {
    @Override
    public void test() {
        int N = 200;

        int[] message
                = new int[]{26123, 11929, 12877, 17767, 14279, 20567, 8321, 9593, 11041, 5429, 7387, 5561, 4757, 9017, 12827, 15049, 15943, 19153, 24523, 22879, 17201, 19673, 26549, 13483, 10961};
        System.out.println(decodeMessage(N, message));
    }

    private String decodeMessage(int N, int[] message) {
        List<Integer> primes = findPrimeNumber(N);

        List<Integer> codes = new ArrayList<>();

        int firstCode = findFirstCode(message[0], message[1], primes);

        codes.add(firstCode);

        int code = firstCode;

        int index = 0;

        HashMap<Integer, int[]> map = new HashMap<>();
        while (index < message.length) {

            int cur = message[index] / code;

            codes.add(cur);

            map.put(index, new int[]{code, cur});

            code = cur;

            index++;
        }

        Collections.sort(codes);

        HashMap<Integer, Character> dict = new HashMap<>();

        for (int i = 0; i < codes.size(); i++) {
            dict.put(codes.get(i), (char)('A' + i));
        }

        String res = "";

        for (int i = 0; i < message.length; i++) {
           char cur = dict.get(map.get(i)[0]);
           res += cur;
        }

        res += dict.get(code);


        return res;
    }

    private int findFirstCode(int first, int second, List<Integer> primes) {

        for (int prime : primes) {
            if (first % prime == 0 && second % prime != 0)
                return prime;
        }

        return -1;
    }

    private List<Integer> findPrimeNumber(int N) {

        List<Integer> primes = new ArrayList<>();

        if (N < 1)
            return primes;

        for (int i = 1; i < N; i++) {
            if (isPrime(i))
                primes.add(i);
        }

        return primes;
    }

    private boolean isPrime(int number) {

        if (number <= 1)
            return false;

        for (int i = 2; i < number; i++)
            if (number % i == 0)
                return false;

        return true;

    }
}
