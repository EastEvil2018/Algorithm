package Algorithm.LintCode.Solution.DataStructure.LinkedList.DeleteGreaterNodesSolution;

import Algorithm.Public.DataStructure.Node;
import Algorithm.LintCode.Solution.Solution;
import Algorithm.Public.Utills.ConstructUtills;
import Algorithm.Public.Utills.PrintUtills;

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
