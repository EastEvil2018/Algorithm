package Algorithm.AppFolio.PasswordGeneratorSolution;

import Algorithm.Public.Solution.Solution;

import java.util.Random;

public class PasswordGeneratorSolution extends Solution {
    // Requirements :
    // Given an PasswordLength and Password Strength, generate a random password.
    // for strength 1, 8-length password, only letters (lower and upper)
    // for strength 2, n-length password, only letters (lower and upper)
    // for strength 3, m-length letters + n-length numbers
    // for strength 4, m-length letters + n-length numbers + l-length special characters
    // for strength 5, given a word list, generate password from it.


    // Hints:
    // use overload to generate different passwords according to different inputs

    // member variables
    private int letterRange = 27;
    private int numberRange = 11;
    private int lowerLetterStartAscii = 97;
    private int upperLetterStartAscii = 65;
    private int numberStartAscii = 48;
    private Random random;

    public  PasswordGeneratorSolution() {
        this.random = new Random();
    }

    public String randomPassword() {
        // strength 1, 8-length, only letters.
        StringBuilder sb = new StringBuilder();

        while (sb.length() != 8) {
            boolean isUpper
                    = random.nextInt(2) == 0 ? true : false;
            char c = 'a';
            if (isUpper) {
                c = (char)(upperLetterStartAscii + random.nextInt(letterRange));
            } else {
                c = (char)(lowerLetterStartAscii + random.nextInt(letterRange));
            }
            sb.append(c);
        }

        return sb.toString();
    }

    public String randomPassword(int n) {
        // strength 2, n-length, only letters.
        if (n < 0)
            return null;

        StringBuilder sb = new StringBuilder();

        while (sb.length() != n) {
            boolean isUpper
                    = random.nextInt(2) == 0 ? true : false;
            char c = 'a';
            if (isUpper) {
                c = (char)(upperLetterStartAscii + random.nextInt(letterRange));
            } else {
                c = (char)(lowerLetterStartAscii + random.nextInt(letterRange));
            }
            sb.append(c);
        }

        return sb.toString();
    }

    public String randomPassword(int m, int n) {
        // strength 3, m-length letters, n-length numbers
        if (m < 0 || n < 0 || m + n < 0)
            return null;

        StringBuilder sb = new StringBuilder();



        return sb.toString();
    }
}
