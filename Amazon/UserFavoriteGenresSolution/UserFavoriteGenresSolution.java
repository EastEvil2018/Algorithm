package Algorithm.Amazon.UserFavoriteGenresSolution;

import Algorithm.Public.Solution.Solution;
import Algorithm.Public.Utills.PrintUtills;

import java.util.*;

public class UserFavoriteGenresSolution extends Solution {

    @Override
    public void test() {
//        userMap = {
//“David”: [“song1”, “song2”, “song3”, “song4”, “song8”],
//“Emma”: [“song5”, “song6”, “song7”]
//},
//        genreMap = {
//“Rock”: [“song1”, “song3”],
//“Dubstep”: [“song7”],
//“Techno”: [“song2”, “song4”],
//“Pop”: [“song5”, “song6”],
//“Jazz”: [“song8”, “song9”]
//}
        HashMap<String, List<String>> userMap = new HashMap<>();

        userMap.put("David", new ArrayList<>());
        userMap.put("Emma", new ArrayList<>());

        userMap.get("David").add("song1");
        userMap.get("David").add("song2");
        userMap.get("David").add("song3");
        userMap.get("David").add("song4");
        userMap.get("David").add("song8");

        userMap.get("Emma").add("song5");
        userMap.get("Emma").add("song6");
        userMap.get("Emma").add("song7");

        HashMap<String, List<String>> genreMap = new HashMap<>();

        genreMap.put("Rock", new ArrayList<>());
        genreMap.put("Dubstep", new ArrayList<>());
        genreMap.put("Techno", new ArrayList<>());
        genreMap.put("Pop", new ArrayList<>());
        genreMap.put("Jazz", new ArrayList<>());

        genreMap.get("Rock").add("song1");
        genreMap.get("Rock").add("song3");

        genreMap.get("Dubstep").add("song7");

        genreMap.get("Techno").add("song2");
        genreMap.get("Techno").add("song4");

        genreMap.get("Pop").add("song5");
        genreMap.get("Pop").add("song6");

        genreMap.get("Jazz").add("song8");
        genreMap.get("Jazz").add("song9");

        userFavoriteGenres(userMap, genreMap);

        userMap.get("David").clear();
        userMap.get("Emma").clear();

        userFavoriteGenres(userMap, genreMap);

        genreMap.clear();

        userFavoriteGenres(userMap, genreMap);



    }

    private HashMap<String, List<String>> userFavoriteGenres(HashMap<String, List<String>> userMap,
                                                             HashMap<String, List<String>> genreMap) {
        HashMap<String, List<String>> res = new HashMap<>();

        if (userMap.size() == 0)
            return res;

        HashMap<String, List<String>> songToGenres = new HashMap<>();

        for (String genre : genreMap.keySet()) {
            for (String song : genreMap.get(genre)) {
                songToGenres.computeIfAbsent(song, (key) -> (new ArrayList<>()));
                songToGenres.get(song).add(genre);
            }
        }


        for (String username : userMap.keySet()) {
            res.computeIfAbsent(username, (k) -> (new ArrayList<>()));
            HashMap<String, Integer> calc = new HashMap<>();

            for (String song : userMap.get(username)) {
                List<String> genreList = songToGenres.get(song);
                if (genreList != null) {
                    for (String genre : genreList) {
                        calc.put(genre, calc.getOrDefault(genre, 0) + 1);
                    }
                }
            }

            PriorityQueue<String> pq
                    = new PriorityQueue<>(11, (a, b) -> (calc.get(b) - calc.get(a)));

            pq.addAll(calc.keySet());

            if (!pq.isEmpty()) {
                int max = calc.get(pq.peek());

                while (calc.get(pq.peek()) == max) {
                    res.get(username).add(pq.poll());
                }
            }
        }

        PrintUtills.printStringToStringListMap(res);

        return res;
    }
}
