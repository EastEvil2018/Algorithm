package Algorithm.LintCode.Sort.HouseRankingSolution;

import Algorithm.Public.Solution.Solution;
import Algorithm.Public.Utills.PrintUtills;

import java.util.*;

public class HouseRankingSolution extends Solution {

    public void test()
    {
        List<Integer> houseA = new ArrayList<>();

        houseA.add(1);

        houseA.add(180);

        houseA.add(497);

        houseA.add(60632);

        List<Integer> houseB = new ArrayList<>();

        houseB.add(2);

        houseB.add(121);

        houseB.add(485);

        houseB.add(60615);

        List<Integer> houseC = new ArrayList<>();

        houseC.add(3);

        houseC.add(74);

        houseC.add(457);

        houseC.add(60611);

        List<Integer> houseD = new ArrayList<>();

        houseD.add(4);

        houseD.add(186);

        houseD.add(369);

        houseD.add(60611);

        List<Integer> houseE = new ArrayList<>();

        houseE.add(5);

        houseE.add(45);

        houseE.add(227);

        houseE.add(60609);

        List<Integer> houseF = new ArrayList<>();

        houseF.add(2);

        houseF.add(133);

        houseF.add(477);

        houseF.add(60610);

        List<Integer> houseG = new ArrayList<>();

        houseG.add(3);

        houseG.add(118);

        houseG.add(377);

        houseG.add(60609);

        List<Integer> houseH = new ArrayList<>();

        houseH.add(6);

        houseH.add(46);

        houseH.add(200);

        houseH.add(60609);

        List<List<Integer>> scores = new ArrayList<>();

        scores.add(houseA);

        scores.add(houseB);

        scores.add(houseC);

        scores.add(houseD);

        scores.add(houseE);

        scores.add(houseF);

        scores.add(houseG);

        scores.add(houseH);

        List<List<Integer>> result = rankHouses(scores);

        PrintUtills.printListOfIntegerList(result);

    }

    class ScoresComparator implements Comparator<List<Integer>>
    {
        // Used for sorting in ascending order of
        // roll number
        public int compare(List<Integer> a, List<Integer> b)
        {

            int aScore = a.get(2);

            int bScore = b.get(2);

            return bScore - aScore;
        }
    }

    public List<List<Integer>> rankHouses(List<List<Integer>> scores)
    {
        List<List<Integer>> result = new ArrayList<>();

        Collections.sort(scores, new ScoresComparator());

        int count = 0;

        int size = scores.size();

        while (count < size)
        {
            HashSet<Integer> idSet = new HashSet<>();

            int num = 0;

            int[] indexArr = new int[5];

            for (int i = 0; num < 5 && i < scores.size(); i++)
            {
                int curIndex = i;

                int curId = scores.get(i).get(0);

                if (idSet.contains(curId))
                    continue;
                else {
                    idSet.add(curId);
                    result.add(scores.get(i));
                    indexArr[num] = curIndex;
                    num++;
                }
            }


            if (scores.size() < 5)
                break;

            for (int i = 0; i < 5; i++)
            {
                if (indexArr[i] < scores.size())
                    scores.remove(indexArr[i]);
            }

            count += 5;
        }

        return result;

    }
}
