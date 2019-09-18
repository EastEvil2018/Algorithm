package Algorithm.SAP.BrilliantBingoSolution;

import Algorithm.Public.Solution.Solution;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.HashSet;

public class BrilliantBingoSolution extends Solution {
    @Override
    public void test() {
        System.out.print(brilliantBingo(7892));
    }

    private int brilliantBingo(int N) {
        HashSet<Integer> set = new HashSet<>();

        int round = 1;

        while (set.size() != 10) {

            int carry = 0;

            int temp = N * round;

            while (temp != 0) {
                int digit = temp % 10;

                digit += carry;

                carry = digit / 10;

                digit = digit % 10;

                set.add(digit);

                temp = temp / 10;
            }

            while (carry != 0) {
                int digit = carry % 10;
                set.add(carry);
                carry /= 10;
            }

            if (set.size() == 10)
                return round;

            round++;
        }

        return -1;
    }
}
