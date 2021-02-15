package finishedStuff; /**
 * This is a submission for the 2018 Junior CCC contest, final problem.
 * The intializePages function must be called before any other function
 */


import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Scanner;

public class escapeRoomSolution {
    // Class to handle the pages in a nice way
    private class Page {
        public boolean isEnd;
        public int pageNum;
        public Page[] nextPages;
        public int distanceFromRoot;

        public Page(int num) {
            pageNum = num;
        }

        public void setEnd(boolean b) {
            isEnd = b;
        }

        public void setNextPages(Page[] p) {
            nextPages = p;
        }
    }

    // The first or root page to be used for traversal
    private Page root;
    public boolean arePagesReachable = true;

    private void intializePages(Scanner sc) {
        int numPages = Integer.parseInt(sc.nextLine());
        // A two-dimensional array with all page data
        // The first array is used to store the pages : args[x][]
        // The second one stores the data of that page : args[][x]
        int[][] args = new int[numPages][];
        boolean[] visited = new boolean[numPages];
        for (int i = 0; i < numPages; i++) {
            int[] oof = Arrays.stream(sc.nextLine().split(" "))
                              .mapToInt(Integer::parseInt).toArray();
            args[i] = oof;
            visited[i] = false;
        }
        visited[0] = true;
        root = new Page(1);
        root.setEnd(args[0][0] == 0);
        Page[] nextPages = new Page[args[0].length - 1];
        Page currPage = root;
        for (int i = 1; i < args[0].length; i++) {
            nextPages[i - 1] = new Page(args[0][i]);
            nextPages[i - 1].setEnd(args[args[0][i] - 1][0] == 0);
            nextPages[i - 1].distanceFromRoot = 2;
        }
        root.setNextPages(nextPages);
        root.distanceFromRoot = 1;
        Queue<Page> q = new LinkedList<>();
        addStuffToQueue(q, root.nextPages);
        while (!q.isEmpty()) {
            currPage = q.remove();
            nextPages = new Page[args[currPage.pageNum - 1].length - 1];
            for (int i = 1; i < args[currPage.pageNum - 1].length; i++) {
                if (!visited[currPage.pageNum - 1]) {
                    nextPages[i - 1] = new Page(args[currPage.pageNum - 1][i]);
                    nextPages[i - 1].setEnd(args[args[currPage.pageNum - 1][i] - 1][0] == 0);
                    nextPages[i - 1].distanceFromRoot = currPage.distanceFromRoot + 1;
                }
            }
            currPage.setNextPages(
                    Arrays.stream(nextPages).filter(Objects::nonNull)
                          .toArray(Page[]::new));
            visited[currPage.pageNum - 1] = true;
            addStuffToQueue(q, currPage.nextPages);
        }
        for (boolean boo : visited) {
            if (!boo) {
                arePagesReachable = false;
            }
        }
    }

    public int shortestPathUntilEndPoint() {
        Page currPage = root;
        Queue<Page> q = new LinkedList<>();
        addStuffToQueue(q, currPage.nextPages);
        while (!currPage.isEnd) {
            currPage = q.remove();
            addStuffToQueue(q, currPage.nextPages);
        }
        return currPage.distanceFromRoot;
    }

    private void addStuffToQueue(Queue<Page> q, Page[] stuff) {
        Collections.addAll(q, stuff);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        escapeRoomSolution m = new escapeRoomSolution();
        m.intializePages(sc);
        System.out.println(m.arePagesReachable ? "Y" : "N");
        System.out.println(m.shortestPathUntilEndPoint());
    }
}

