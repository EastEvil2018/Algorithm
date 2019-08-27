package Algorithm.Public.Utills;

import Algorithm.Public.DataStructure.Node;

import java.util.Random;

public class ConstructUtills {

    public static Node constructLinkedList(int length, int maxValue)
    {
        if (length == 0)
            return null;

        Node head = new Node(0);

        Node temp = head;

        Random random = new Random();

        for (int i = 0; i < length; i++)
        {
            int val = random.nextInt(maxValue);

            temp.next = new Node(val);

            temp = temp.next;
        }

        return head;
    }
}
