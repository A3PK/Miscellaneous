/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.StdIn;

public class StackImplement {
    private Node first = null;
    int size = 0;

    private class Node {
        String item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void push(String item) {
        Node oldFirst = first;
        first = new Node();
        first.next = oldFirst;
        first.item = item;
        size++;
    }

    public String pop() {
        String item = first.item;
        first = first.next;
        size--;
        return item;

    }

    public static void main(String[] args) {
        boolean comp = false;
        StackImplement stack = new StackImplement();
        System.out.println("Do you want to push an item, pop an item, or end?");
        System.out.println("Type p/o/e for each option.");
        while (!comp) {
            String s = StdIn.readLine();
            if (s.equals("p")) {
                stack.push(StdIn.readLine());
                System.out.println("Completed.");
                System.out.println("");
            }
            if (s.equals("o") && !stack.isEmpty()) {
                System.out.println(stack.pop());
                System.out.println("");
            }
            if (s.equals("e")) {
                comp = true;
            }
        }
    }
}
