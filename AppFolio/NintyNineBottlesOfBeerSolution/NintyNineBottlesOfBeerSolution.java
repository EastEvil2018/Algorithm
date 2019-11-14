package Algorithm.AppFolio.NintyNineBottlesOfBeerSolution;

import Algorithm.Public.Solution.Solution;

public class NintyNineBottlesOfBeerSolution extends Solution {
    @Override
    public void test() {
        NintyNineBottlesOfBeer(3);
    }

    //    Task
    //    Display the complete lyrics for the song:     99 Bottles of Beer on the Wall.
    //
    //
    //    The beer song
    //    The lyrics follow this form:
    //
    //    99 bottles of beer on the wall
    //    99 bottles of beer
    //    Take one down, pass it around
    //    98 bottles of beer on the wall
    //
    //    98 bottles of beer on the wall
    //    98 bottles of beer
    //    Take one down, pass it around
    //    97 bottles of beer on the wall
    //
    //... and so on, until reaching 0.
    public void NintyNineBottlesOfBeer(int num) {
        String res = "";
        for (int i = num; i >= 1; i--) {
            res += "\n";
            res += (String.valueOf(i) + " bottles of beer on the wall\n");
            res += (String.valueOf(i) + " bottles of beer\n");
            res += "Take one down, pass it around\n";
            res += (String.valueOf(i - 1) + " bottles of beer on the wall\n");
        }

        System.out.println(res);
    }

}
