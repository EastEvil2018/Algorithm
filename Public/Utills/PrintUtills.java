package Algorithm.Public.Utills;

import Algorithm.Public.DataStructure.Interval;
import Algorithm.Public.DataStructure.Node;

import java.util.List;

public class PrintUtills {

    public static void printLinkedList(Node head)
    {
        Node dummyHead = head;

        System.out.println("The Linked List is printed below : ");

        while (dummyHead != null)
        {
            System.out.print(dummyHead.val + "->");
            dummyHead = dummyHead.next;
        }

        System.out.println("null");
    }

    public static void printIntervalList(List<Interval> intervals)
    {
        System.out.print("{");

        for (int i = 0; i < intervals.size(); i++)
        {
            printInterval(intervals.get(i));
        }

        System.out.print("}");
    }

    public static void printInterval(Interval interval)
    {
        System.out.print(" ( " + interval.start + ", ");

        System.out.print(interval.end + " ) ");
    }
}
