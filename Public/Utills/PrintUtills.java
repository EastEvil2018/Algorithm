package Algorithm.Public.Utills;

import Algorithm.Public.DataStructure.Interval;
import Algorithm.Public.DataStructure.Node;

import java.util.HashMap;
import java.util.List;

public class PrintUtills {

    public static void printLinkedList(Node head) {
        Node dummyHead = head;

        System.out.println("The Linked List is printed below : ");

        while (dummyHead != null) {
            System.out.print(dummyHead.val + "->");
            dummyHead = dummyHead.next;
        }

        System.out.println("null");
    }

    public static void printeListOfIntervalList(List<List<Interval>> intervals) {
        System.out.println("The List of Interval List is printed below : ");

        System.out.print("{");

        for (int i = 0; i < intervals.size(); i++) {
            printIntervalList(intervals.get(i));
        }

        System.out.println("}");
    }

    public static void printIntervalList(List<Interval> intervals) {

        System.out.print("[");

        for (int i = 0; i < intervals.size(); i++) {
            printInterval(intervals.get(i));
        }

        System.out.print("]");
    }

    public static void printInterval(Interval interval) {
        System.out.print(" ( " + interval.start + ", ");

        System.out.print(interval.end + " ) ");
    }

    public static void printListOfIntegerList(List<List<Integer>> list) {
        System.out.println("The list of list of Integer is printed below : ");

        System.out.print("{\n");

        for (int i = 0; i < list.size(); i++) {
            printIntegerList(list.get(i));
        }

        System.out.print("\n}");
    }

    public static void printIntegerList(List<Integer> integerList) {
        System.out.print("[ ");
        for (int i = 0; i < integerList.size(); i++) {
            System.out.print(integerList.get(i) + " ");
        }
        System.out.print("]\n");
    }

    public static void printCharArray(char[] array)
    {
        int sum = array.length;

        if (sum == 0)
            return;

        System.out.print("The char array is printed below : \n[ ");

        for (int i = 0; i < sum; i++) {

            System.out.print(array[i] + " ");

        }

        System.out.print("]\n");

    }

    public static void printChar2DArray(char[][] array) {
        int sum = array.length;

        if (sum == 0)
            return;

        int length = array[0].length;

        if (length == 0)
            return;

        System.out.println("The char array is printed below : ");

        for (int i = 0; i < sum; i++) {
            for (int j = 0; j < length; j++) {
                System.out.print(array[i][j] + " ");
            }

            System.out.print("\n");
        }
    }

    public static void printListOfStringList(List<List<String>> list) {

        System.out.println("The list of list of String is printed below : ");

        System.out.print("{\n");

        for (int i = 0; i < list.size(); i++) {
            printStringList(list.get(i));
        }

        System.out.print("\n}");
    }

    public static void printStringList(List<String> stringList) {

        System.out.println("[ ");

        for (int i = 0; i < stringList.size(); i++) {
            System.out.println("\"" + stringList.get(i) + "\"");
        }

        System.out.print("]\n");
    }

    public static void printStringArray(String[] stringArray)
    {
        System.out.print("[ ");

        for (int i = 0; i < stringArray.length; i++)
        {
            System.out.print(stringArray[i] + " ");
        }

        System.out.print("]\n");
    }

    public static void printString2DArray(String[][] array) {
        int sum = array.length;

        if (sum == 0)
            return;

        int length = array[0].length;

        if (length == 0)
            return;

        System.out.println("The string array is printed below : ");

        for (int i = 0; i < sum; i++) {
            for (int j = 0; j < length; j++) {
                System.out.print(array[i][j] + " ");
            }

            System.out.print("\n");
        }
    }

    public static void printInt2DArray(int[][] array)
    {
        int row = array.length;

        if (row == 0)
            return;

        int col = array[0].length;

        if (col == 0)
            return;

        for (int i = 0; i < row; i++)
        {
            printIntArray(array[i]);
        }
    }

    public static void printIntArray(int[] array)
    {
        System.out.print("[ ");
        for (int i = 0; i < array.length; i++)
        {
            System.out.print(array[i] + " ");
        }
        System.out.print("]\n");
    }

    public static void printBoolean2DArray(boolean[][] array)
    {
        int row = array.length;

        if (row == 0)
            return;

        int col = array[0].length;

        if (col == 0)
            return;

        for (int i = 0; i < row; i++)
        {
            printBooleanArray(array[i]);
        }
    }

    public static void printBooleanArray(boolean[] array)
    {
        System.out.print("[ ");
        for (int i = 0; i < array.length; i++)
        {
            System.out.print(array[i] + " ");
        }
        System.out.print("]\n");
    }

    public static void printFloatArray(float[] array)
    {
        int sum = array.length;

        if (sum == 0)
            return;

        System.out.print("The float array is printed below : \n[ ");

        for (int i = 0; i < sum; i++) {

            System.out.print(array[i] + " ");

        }

        System.out.print("]\n");

    }

    public static void printStringToStringListMap(HashMap<String, List<String>> map) {
        int size = map.size();

        if (size == 0)
            return;

        System.out.println("The String To StringList HashMap is printed below : ");

        for (String key : map.keySet()) {
            System.out.print(key + " -> ");
            PrintUtills.printStringList(map.get(key));
        }
    }

    public static void printListOfIntArray(List<int[]> list) {
        int size = list.size();

        if (size == 0)
            return;

        System.out.println("The List Of Int Array is printed below : ");

        for (int[] array : list) {
            PrintUtills.printIntArray(array);
        }
    }


}
