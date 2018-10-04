package Algorithm.LintCode.SOLUTION.DataStructure.LinkedList.DeleteGreaterNodesSolution;

import Algorithm.LintCode.PUBLIC_DATA_STRUCTURE.Node;
import Algorithm.LintCode.SOLUTION.Solution;
import Algorithm.LintCode.UTILLS.ConstructUtills;
import Algorithm.LintCode.UTILLS.PrintUtills;

public class DeleteGreaterNodesSolution implements Solution {

    public void run()
    {
        // write some test cases here

        int x = 6;

        Node head = ConstructUtills.constructLinkedList(8, 20);

        head = deleteGreaterNodes(head, x);

        PrintUtills.printLinkedList(head);
    }

    public void describe()
    {
        // Here we should show some descriptions for this problem
    }

    public void explain()
    {
        // Here we should explain the solution
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
