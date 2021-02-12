import java.util.LinkedHashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < num; i++) {
            LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
            char[] chars = sc.nextLine().toCharArray();
            for (char c : chars) {
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                }
                else {
                    map.put(c, 1);
                }
            }
            for (char c : map.keySet()) {
                System.out.print(map.get(c) + " " + c + " ");
            }
            System.out.print("\n");
        }
    }
}

