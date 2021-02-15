package finishedStuff;/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;

public class HelloWorld {
    public static void main(String[] args) {
        Queue<String> queue = new Queue<String>();
        Stack<String> stack = new Stack<String>();
        String s = StdIn.readLine();
        for (String d : s.split("")) {
            queue.enqueue(d);
            stack.push(d);
        }
        System.out.println("Hello, World!");
        for (String d : queue) {
            System.out.println(d);
        }
        for (String d : stack) {
            System.out.println(d);
        }
    }
}
