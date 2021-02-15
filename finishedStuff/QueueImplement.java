package finishedStuff;/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.StdIn;

public class QueueImplement {
    private Node first, last;

    private class Node {
        String item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void enqueue(String item) {
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            first = last;
        }
        else {
            oldlast.next = last;
        }
    }

    public String dequeue() {
        String item = first.item;
        first = first.next;
        if (isEmpty()) {
            last = null;
        }
        return item;
    }

    public static void main(String[] args) {
        boolean comp = false;
        QueueImplement queue = new QueueImplement();
        System.out.println("Do you want to push an item, pop an item, or end?");
        System.out.println("Type p/o/e for each option.");
        while (!comp) {
            String s = StdIn.readLine();
            if (s.equals("p")) {
                queue.enqueue(StdIn.readLine());
                System.out.println("Completed.");
                System.out.println("");
            }
            if (s.equals("o") && !queue.isEmpty()) {
                System.out.println(queue.dequeue());
                System.out.println("");
            }
            if (s.equals("e")) {
                comp = true;
            }
        }
    }
}
