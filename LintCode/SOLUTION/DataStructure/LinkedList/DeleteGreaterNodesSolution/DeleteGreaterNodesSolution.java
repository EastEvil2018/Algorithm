package Algorithm.LintCode.SOLUTION.DataStructure.LinkedList.DeleteGreaterNodesSolution;

import Algorithm.LintCode.PUBLIC_DATA_STRUCTURE.Node;
import Algorithm.LintCode.SOLUTION.Solution;
import Algorithm.LintCode.UTILLS.ConstructUtills;
import Algorithm.LintCode.UTILLS.PrintUtills;

import java.io.File;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Pattern;

public class DeleteGreaterNodesSolution extends Solution {

    public void test()
    {
        System.out.println("Test:");

        int x = 6;

        Node head = ConstructUtills.constructLinkedList(8, 20);

        System.out.println("\nBefore Testing:\n");

        PrintUtills.printLinkedList(head);

        head = deleteGreaterNodes(head, x);

        System.out.println("\nAfter Testing:\n");

        PrintUtills.printLinkedList(head);
    }


    public Node deleteGreaterNodes(Node head, int val)
    {
        Node temp = head;

        Node prev = head;

        while (temp.val > val)
        {
            temp = temp.next;
            prev = temp;
            head = temp;
        }

        while(temp != null)
        {
            while (temp != null && temp.val <= val)
            {
                prev = temp;
                temp = temp.next;
            }

            if (temp == null)
                return head;

            temp = temp.next;
            prev.next = temp;
        }



        return head;
    }
}
