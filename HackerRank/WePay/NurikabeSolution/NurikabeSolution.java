package Algorithm.HackerRank.WePay.NurikabeSolution;

import Algorithm.Public.Solution.Solution;
import Algorithm.Public.Utills.PrintUtills;
import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;
import org.junit.Assert;

public class NurikabeSolution extends Solution {
    @Override
    public void test() {
        String[][] testcase1 = new String[][]{
                {".", "#", "2", ".", "1"},
                {".", ".", ".", ".", "."},
                {"#", "2", ".", "#", "."},
                {".", ".", ".", "2", "."},
                {"#", "2", ".", ".", "1"}
        };

        Assert.assertTrue(NurikabeVerifier(testcase1) == true);

        String[][] testcase2 = new String[][]{
                {".", ".", "2", ".", "1"},
                {".", ".", "#", ".", "."},
                {"#", "2", ".", ".", "1"},
                {".", ".", ".", "2", "."},
                {"#", "2", ".", ".", "1"}
        };

        Assert.assertTrue(NurikabeVerifier(testcase2) == false);

        String[][] testcase3 = new String[][]{
                {".", "#", "2", "#", "1"},
                {".", ".", ".", ".", "."},
                {"#", "2", ".", ".", "."},
                {".", ".", ".", "2", "."},
                {"#", "2", ".", "#", "1"}
        };

        Assert.assertTrue(NurikabeVerifier(testcase3) == false);

        String[][] testcase4 = new String[][]{
                {".", ".", ".", ".", "."},
                {".", ".", ".", ".", "."},
                {".", ".", ".", ".", "."},
                {".", ".", ".", ".", "."},
                {".", ".", ".", ".", "."}
        };

        Assert.assertTrue(NurikabeVerifier(testcase4) == true);


        String[][] testcase5 = new String[][]{
                {"25", "#", "#", "#", "#"},
                {"#", "#", "#", "#", "#"},
                {"#", "#", "#", "#", "#"},
                {"#", "#", "#", "#", "#"},
                {"#", "#", "#", "#", "#"}
        };

        Assert.assertTrue(NurikabeVerifier(testcase5) == false);

        String[][] testcase6 = new String[][]{
                {"21", "#", "#", "#", "#"},
                {"#", "#", ".", ".", "#"},
                {"#", "#", ".", ".", "#"},
                {"#", "#", "#", "#", "#"},
                {"#", "#", "#", "#", "#"}
        };

        Assert.assertTrue(NurikabeVerifier(testcase6) == false);
    }


/*
Nurikabe is a puzzle where a 2d grid is given with many blank spaces and some numbers.
The challenge is to fill in the grid with '.' (water) and '#' (islands) in such a way that
   - Each number is with a connected group of island squares that, including the number square itself,
     contains exactly that many squares are connected up-down-left-right only, not diagonally
   - Each connected group of is land squares contains exactly one numbered square
   - All of the water squares are connected to each other
   - There no 2x2 blocks of water anywhere in the grid
   - No other characters appear in the grid (cheater!)
   Your task is to write a function that takes a 2d array representing a solved Nurikabe puzzle and
   returns True if the puzzle is correctly solved and False otherwise.
   For example, given the 5x5 puzzle
   ~~~~
   .#2.1
   .....
   #2.#.
   ...2.
   #2..1
   ~~~~
   you would return true, but given
   ~~~
   ..2.1
   ..#..
   #2.#.
   ...2.
   #2..1
   you would return false.
*/
    public int[] rowSteps = new int[]{0, 1, 0, -1};

    public int[] colSteps = new int[]{1, 0, -1, 0};

    public int numberOfIslandsInGroup = 0;

    public boolean NurikabeVerifier(String[][] nurikabe) {
        int rowSize = nurikabe.length;
        if (rowSize == 0)
            return true;

        int colSize = nurikabe[0].length;
        if (colSize == 0)
            return true;

        System.out.println("The given nurikabe is printed below : " + rowSize + " * " + colSize);

        PrintUtills.printString2DArray(nurikabe);

        // we first scan the nurikabe, when we meet water, then dfs nurikabe, to change all the water in the dfs to be "W";
        boolean findSea = false;

        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                if (nurikabe[i][j].equals(".")) {
                    searchWaterInNurikabe(nurikabe, i, j);
                    findSea = true;
                    break;
                }
            }
            if (findSea)
                break;
        }

        if (findSea == false)
            return false;

        System.out.println("After search water, the nurikabe is printed below : " + rowSize + " * " + colSize);

        PrintUtills.printString2DArray(nurikabe);

        // Check if the nurikabe has sea on the bound, else it is not valid
        boolean seaValid = false;

        // after scan for sea we can first check if there are pools and if the sea is valid, e.g, there are waters
        // in the bound
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                if (nurikabe[i][j].equals("."))
                    return false;

                if ((seaValid == false) && ((i == 0 && nurikabe[i][j].equals("W")) ||
                    (i == rowSize - 1 && nurikabe[i][j].equals("W"))
                        || (j == 0 && nurikabe[i][j].equals("W"))
                        || (j == colSize - 1 && nurikabe[i][j].equals("W")))) {
                    seaValid = true;
                }
            }
        }

        if (seaValid == false)
            return false;

        /* After this, 
        .#2.1       
        .....
        #2.#. 
        ...2.
        #2..1
        
        changes to :
        
        W#2W1
        WWWWW
        #2W#W
        WWW2W
        #2WW1
        */

        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                int numberOfIslands = isNumeric(nurikabe[i][j]);
                //System.out.println(numberOfIslands);
                if (numberOfIslands > -1) {
                    numberOfIslandsInGroup = numberOfIslands;
                    searchIslandInNurikabe(nurikabe, i, j);
                    System.out.println(numberOfIslandsInGroup);
                    if (numberOfIslandsInGroup != 0)
                        return false;
                }
            }
        }

        System.out.println("After searchingLand, the nurikabe is printed below : ");
        PrintUtills.printString2DArray(nurikabe);

        // Check if bound has W, e.g, we have sea

        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                if (!(nurikabe[i][j].equals("W") || nurikabe[i][j].equals("L")))
                    return false;
            }
        }

        return true;
    }

    public void searchWaterInNurikabe(String[][] nurikabe, int curRow, int curCol) {
        nurikabe[curRow][curCol] = "W";

        for (int i = 0; i < 4; i++) {
            int nextRow = curRow + rowSteps[i];

            int nextCol = curCol + colSteps[i];

            if (nextRow >= 0 && nextRow < nurikabe.length
                    && nextCol >= 0 && nextCol < nurikabe[0].length
                    && nurikabe[nextRow][nextCol].equals(".")) {
                searchWaterInNurikabe(nurikabe, nextRow, nextCol);
            }
        }
    }

    public void searchIslandInNurikabe(String[][] nurikabe, int curRow, int curCol) {

        System.out.println("Row : " + curRow + " Col : " + curCol + " Number Of Islands : " + numberOfIslandsInGroup);

        nurikabe[curRow][curCol] = "L";

        numberOfIslandsInGroup--;

        for (int i = 0; i < 4; i++) {
            int nextRow = curRow + rowSteps[i];

            int nextCol = curCol + colSteps[i];

            if (nextRow >= 0 && nextRow < nurikabe.length
                    && nextCol >= 0 && nextCol < nurikabe[0].length
                    && (nurikabe[nextRow][nextCol].equals("#") ||
                    isNumeric(nurikabe[nextRow][nextCol]) > -1)) {

                searchIslandInNurikabe(nurikabe, nextRow, nextCol);
            }
        }

        return;
    }

    public int isNumeric(String s) {
        int result = 0;
        // s could be "10"
        int len = s.length();

        //System.out.println(s);

        for (int i = 0; i < len; i++) {
            char digit = s.charAt(i);

            //System.out.println(digit);

            if (digit < '0' || digit > '9')
                return -1;

            result += (digit - '0') * Math.pow(10, len - i - 1);
        }

        //System.out.println(result);

        return result;
    }
}
