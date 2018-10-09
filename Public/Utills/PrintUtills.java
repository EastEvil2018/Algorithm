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
        System.out.println("The Interval List is printed below : ");

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

    public static void printListOfIntegerList(List<List<Integer>> list)
    {
        System.out.println("The list of list of Integer is printed below : ");

        System.out.print("{\n");

        for (int i = 0; i < list.size(); i++)
        {
            printIntegerList(list.get(i));
        }

        System.out.print("\n}");
    }

    public static void printIntegerList(List<Integer> integerList)
    {
        System.out.print("[ ");
        for (int i = 0; i < integerList.size(); i++)
        {
            System.out.print(integerList.get(i) + " ");
        }
        System.out.print("]");
    }

    public static void printCharArray(char[][] array)
    {
        int sum = array.length;

        if (sum == 0)
            return;

        int length = array[0].length;

        if (length == 0)
            return;

        System.out.println("The char array is printed below : ");

        for (int i = 0; i < sum; i++)
        {
            for (int j = 0; j < length; j++)
            {
                System.out.print(array[i][j] + " ");
            }

            System.out.print("\n");
        }
    }
}
