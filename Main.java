import java.util.Scanner;

public class Main {
    public static boolean isConsonant(String s) {
        if (s.equals("a") || s.equals("e") || s.equals("i") || s.equals("o") || s.equals("u")) {
            return false;
        }
        return true;
    }

    public static String returnClosestVowel(String s) {
        char c = s.charAt(0);
        int[] distances = {
                (int) 'a' - (int) c, (int) 'e' - (int) c, (int) 'i' - (int) c, (int) 'o' - (int) c,
                (int) 'u' - (int) c,
                };
        char[] chars = { 'a', 'e', 'i', 'o', 'u' };
        int largest = 999999;
        int largestIdx = 0;
        for (int i = 0; i < distances.length; i++) {
            distances[i] = Math.abs(distances[i]);
            if (distances[i] < largest) {
                largest = distances[i];
                largestIdx = i;
            }
        }
        return Character.toString(chars[largestIdx]);
    }

    public static String returnNextConsonant(String s) {
        char c = s.charAt(0);
        char next = (char) ((int) c + 1);
        if (!isConsonant(Character.toString(next))) {
            return returnNextConsonant(Character.toString(next));
        }
        return Character.toString(next);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] letters = sc.nextLine().split("");
        String[] answer = new String[letters.length];
        for (int i = 0; i < letters.length; i++) {
            if (isConsonant(letters[i])) {
                answer[i] = letters[i] + returnClosestVowel(letters[i]) + returnNextConsonant(
                        letters[i]);
            }
            else {
                answer[i] = letters[i];
            }
        }
        for (String s : answer) {
            System.out.print(s);
        }
    }
}
