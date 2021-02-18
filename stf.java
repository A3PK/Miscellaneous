import java.util.Scanner;

public class stf {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = Integer.parseInt(sc.nextLine());
        int cols = Integer.parseInt(sc.nextLine());
        int queries = Integer.parseInt(sc.nextLine());
        boolean[][] grid = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = false;
            }
        }
        int ans = 0;
        for (int i = 0; i < queries; i++) {
            String[] dhf = sc.nextLine().split(" ");
            if (dhf[0].equals("R")) {
                int row = Integer.parseInt(dhf[1]) - 1;
                for (int j = 0; j < cols; j++) {
                    grid[row][j] = !grid[row][j];
                    if (grid[row][j]) {
                        ans++;
                    }
                    else {
                        ans--;
                    }
                }
            }
            else {
                int col = Integer.parseInt(dhf[1]) - 1;
                for (int j = 0; j < rows; j++) {
                    grid[j][col] = !grid[j][col];
                    if (grid[j][col]) {
                        ans++;
                    }
                    else {
                        ans--;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
