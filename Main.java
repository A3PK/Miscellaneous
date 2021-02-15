import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static boolean isDistinct(int n) {
        char[] chars = Integer.toString(n).toCharArray();
        HashSet<Character> set = new HashSet<>();
        for (char c : chars) {
            if (set.contains(c)) {
                return false;
            }
            set.add(c);
        }
        return true;
    }

    public static int returnDistinctDate(int n) {
        if (isDistinct(n + 1)) {
            return n + 1;
        }
        return returnDistinctDate(n + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int date = sc.nextInt();
        System.out.println(returnDistinctDate(date));
    }
}
