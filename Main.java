import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        String[] str = sc.nextLine().split(" ");
        HashMap<String, String> map = new HashMap<>();
        String[] str2 = sc.nextLine().split(" ");
        for (int i = 0; i < str.length; i++) {
            map.put(str[i], str2[i]);
        }
        boolean good = true;
        for (String s : map.keySet()) {
            if (!s.equals(map.get(map.get(s))) || map.get(s).equals(s)) {
                good = false;
                break;
            }
        }
        System.out.println(good ? "good" : "bad");
    }
}
