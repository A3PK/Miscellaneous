package finishedStuff;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static int minSwaps(int[] arr) {
        int ans = 0;
        int[] temp = Arrays.copyOf(arr, arr.length);
        Arrays.sort(temp);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != temp[i]) {
                ans++;
                swap(arr, i, indexOf(arr, temp[i]));
            }
        }
        return ans;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int indexOf(int[] arr, int ele) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == ele) {
                return i;
            }
        }
        return -1;
    }

    public static int toInt(String s) {
        if (s.equals("L")) {
            return 0;
        }
        else if (s.equals("M")) {
            return 1;
        }
        else {
            return 2;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = Arrays.stream(sc.nextLine().split("")).mapToInt(Main::toInt).toArray();
        System.out.println(minSwaps(arr));

    }
}
