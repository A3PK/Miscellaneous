import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CC02018D2P3 {

    public int[] flopArraySorter(int[] args, Queue<Integer> q) {
        if (args.length == 1) {
            return args;
        }
        int[] next = flopArraySorter(Arrays.copyOf(args, args.length - 1), q);
        int[] result = new int[2 + next.length];
        result[0] = args.length;
        result[1] = args[args.length - 1];
        System.arraycopy(next, 0, result, 2, next.length);
        q.add(findIdx(result[0], args));
        q.add(findIdx(result[1], args));
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

    public void flopSortedArray(int[] sorted, int[] target, Queue<Integer> q) {
        while (!Arrays.equals(sorted, target)) {
            int largestIdx = findIdx(getLargest(sorted), sorted);
            int currIdx = findIdx(largestIdx + 1, sorted);
            q.add(largestIdx);
            q.add(currIdx);
            flopLargestToPos(currIdx - 1, sorted);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        int[] input = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] output = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt)
                             .toArray();
        Main m = new Main();
        Queue<Integer> q
                = new LinkedList<>();
        m.flopArraySorter(input, q);
        Arrays.sort(input);
        m.flopSortedArray(input, output, q);
        System.out.println(q.size() / 2 - 1);
        while (!q.isEmpty() && q.size() > 2) {
            System.out.println(q.remove() + " " + q.remove());
        }
    }
}
