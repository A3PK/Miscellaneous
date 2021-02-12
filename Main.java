import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public int[] arrayFlopper(int[] args) {
        if (args.length == 1) {
            return args;
        }
        int[] next = arrayFlopper(Arrays.copyOf(args, args.length - 1));
        int[] result = new int[2 + next.length];
        result[0] = args.length;
        result[1] = args[args.length - 1];
        System.arraycopy(next, 0, result, 2, next.length);
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        int[] input = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] output = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt)
                             .toArray();
        int flops = 0;
    }
}

