package Algorithm.HackerRank.Mathworks.RemoveDuplicatesInUnsortedLinkedListSolution;

import Algorithm.Public.DataStructure.Node;
import Algorithm.Public.Solution.Solution;

import java.util.HashSet;


public class RemoveDuplicatesInUnsortedLinkedListSolution extends Solution {
    @Override
    public void test() {
        super.test();
    }

    public Node removeDuplicates(Node list) {
        // Remove the duplicates in an unsorted list
        if (list == null && list.next == null)
            return list;

        HashSet<Integer> set = new HashSet<>();

        Node head = list;

        Node prev = list;

        set.add(list.val);
        list = list.next;
        while (list != null) {
            if (set.contains(list.val)) {
                prev.next = list.next;
                list = list.next;
            } else {
                set.add(list.val);
                prev = list;
                list = list.next;
            }
        }

        return head;
    }
}
