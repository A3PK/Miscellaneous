import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public int[] flopArraySorter(int[] args) {
        if (args.length == 1) {
            return args;
        }
        int[] next = flopArraySorter(Arrays.copyOf(args, args.length - 1));
        int[] result = new int[2 + next.length];
        result[0] = args.length;
        result[1] = args[args.length - 1];
        System.arraycopy(next, 0, result, 2, next.length);
        return result;
    }

    public static int getLargest(int[] ar) {
        int[] a = Arrays.copyOf(ar, ar.length);
        Arrays.sort(a);
        int element = a[a.length - 1];
        return element;
    }

    public void flopLargestToPos(int pos, int[] arr) {
        int n = getLargest(arr);
        int loc = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == n) {
                loc = i;
                break;
            }
        }
        arr[loc] = arr[pos];
        arr[pos] = n;
    }

    public boolean[] findEquals(int[] a, int[] b) {
        boolean[] n = new boolean[a.length];
        for (int i = 0; i < a.length; i++) {
            n[i] = false;
            if (a[i] == b[i]) {
                n[i] = true;
            }
        }
        return n;
    }

    public int findIdx(int element, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == element) {
                return i;
            }
        }
        return -1;
    }

    public void flopSortedArray(int[] sorted, int[] target) {
        while (!Arrays.equals(sorted, target)) {
            int largestIdx = findIdx(getLargest(sorted), sorted);
            int currIdx = findIdx(largestIdx + 1, sorted);
            System.out.println(getLargest(sorted));
            System.out.println(largestIdx);
            System.out.println(currIdx);
            System.out.println(Arrays.toString(sorted));
            flopLargestToPos(currIdx, sorted);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        int[] input = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] output = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt)
                             .toArray();
        Main m = new Main();
        Arrays.sort(input);
        m.flopSortedArray(input, output);
        System.out.println(Arrays.toString(input));
    }
}
