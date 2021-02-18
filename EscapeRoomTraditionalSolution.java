import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class rain {

    public Integer[] printDivisors(int n) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                if (n / i == i) {
                    list.add(i);
                }

                else {
                    list.add(i);
                    list.add(n / i);
                }
            }
        }
        Integer[] arr = list.toArray(new Integer[0]);
        return arr;
    }

    public boolean findIfPathExists(BufferedReader br) throws IOException {
        int rows = Integer.parseInt(br.readLine());
        int cols = Integer.parseInt(br.readLine());
        String[][] grid = new String[rows][cols];
        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            grid[i] = br.readLine().split(" ");
            for (int j = 0; j < cols; j++) {
                visited[i][j] = false;
            }
        }
        int n = Integer.parseInt(grid[0][0]);
        int currRow = 1;
        int currCol = 1;
        boolean done = true;
        HashSet<Integer> map = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> row = new LinkedList<>();
        Queue<Integer> col = new LinkedList<>();
        while (currRow != rows
                || currCol != cols) {
            Integer[] divisors;
            if (!map.contains(n)) {
                divisors = printDivisors(n);
                map.add(n);
                for (int i : divisors) {
                    if ((i == rows && n / i == cols) || (i == cols && n / i == rows)) {
                        return true;
                    }
                    if (i <= rows && n / i <= cols && !visited[i - 1][(n / i) - 1]) {
                        q.add(Integer.parseInt(grid[i - 1][(n / i) - 1]));
                        row.add(i);
                        col.add(n / i);
                        visited[i - 1][(n / i) - 1] = true;
                    }
                    if (n / i <= rows && i <= cols && !visited[(n / i) - 1][i - 1]) {
                        q.add(Integer.parseInt(grid[(n / i) - 1][i - 1]));
                        row.add(n / i);
                        col.add(i);
                        visited[(n / i) - 1][i - 1] = true;
                    }
                }
            }
            if (q.size() == 0) {
                done = false;
                break;
            }
            n = q.remove();
            currRow = row.remove();
            currCol = col.remove();
        }
        return done;
    }

    public static void main(String[] args) throws IOException {
        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);

        Main m = new Main();
        System.out.println(m.findIfPathExists(br) ? "yes" : "no");
    }
}

