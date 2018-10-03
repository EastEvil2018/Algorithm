package LintCode.UTILLS;

import LintCode.PUBLIC_DATA_STRUCTURE.Node;

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
}
