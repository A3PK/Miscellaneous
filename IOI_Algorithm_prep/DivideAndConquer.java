/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

package IOI_Algorithm_prep;

import java.util.Arrays;

public class DivideAndConquer {
    public int[] maxCrossingSubArray(int[] a, int low, int mid, int high) {
        int maxLeft = mid, maxRight = mid;
        int leftSum = Integer.MIN_VALUE, rightSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = mid; i-- > low; ) {
            sum += a[i];
            if (sum > leftSum) {
                leftSum = sum;
                maxLeft = i;
            }
        }
        sum = 0;
        for (int i = mid + 1; i++ < high; ) {
            sum += a[i];
            if (sum > rightSum) {
                rightSum = sum;
                maxRight = i;
            }
        }
        return new int[] { maxLeft, maxRight, leftSum + rightSum };
    }

    public int[] findMaximumSubArray(int[] a, int low, int high) {
        if (high == low) {
            return new int[] { low, high, a[low] };
        }
        else {
            int mid = (low + high) / 2;
            int[] leftVals = findMaximumSubArray(a, low, mid);
            int[] rightVals = findMaximumSubArray(a, mid + 1, high);
            int[] midVals = maxCrossingSubArray(a, low, mid, high);
            if (leftVals[2] > rightVals[2] && leftVals[2] > midVals[2]) {
                return leftVals;
            }
            else if (rightVals[2] > leftVals[2] && rightVals[2] > midVals[2]) {
                return rightVals;
            }
            else {
                return midVals;
            }
        }
    }

    public static void main(String[] args) {
        int[] values = { 13, -2, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7 };
        DivideAndConquer divideAndConquer = new DivideAndConquer();
        System.out.println(Arrays.toString(divideAndConquer.findMaximumSubArray(values, 0, 15)));
    }
}
