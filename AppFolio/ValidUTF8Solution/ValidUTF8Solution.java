package Algorithm.AppFolio.ValidUTF8Solution;

import Algorithm.Public.Solution.Solution;

public class ValidUTF8Solution extends Solution {

    @Override
    public void test() {
        super.test();
    }

    public boolean validUTF8(int[] array) {
//        A character in UTF8 can be from 1 to 4 bytes long, subjected to the following rules:
//
//        For 1-byte character, the first bit is a 0, followed by its unicode code.
//        For n-bytes character, the first n-bits are all one’s, the n+1 bit is 0, followed by n-1 bytes with most significant 2 bits being 10.


//        int len = array.length;
//
//        if (len == 0 || len > 4)
//            return false;
//
//        int start = array[0];
//
//        int numOfBytes = 0;
//
//        int mask = 1 << 7;
//
//        while ((mask & start) > 0) {
//            numOfBytes++;
//            mask = mask >> 1;
//        }
//
//        if (numOfBytes == 1 || (numOfBytes != len - 1))
//            return false;
//
//        for (int i = 1; i < len; i++) {
//            if ((((array[i] >> 6) & 1) != 0)  || (((array[i] >> 7) & 1) == 0))
//                return false;
//        }
//
//        return true;
        return true;
    }
}
