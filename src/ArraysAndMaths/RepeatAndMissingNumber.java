/*
Repeat and Missing Number Array
You are given a read only array of n integers from 1 to n.

Each integer appears exactly once except A which appears twice and B which is missing.

Return A and B.

Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Note that in your output A should precede B.

Example:

Input:[3 1 2 5 3]

Output:[3, 4]

A = 3, B = 4
 */
package ArraysAndMaths;

import java.util.Arrays;

public class RepeatAndMissingNumber {
    public static int[] repeatedNumber(final int[] A) {
        // int n = A.length;
        // long sumsquare = 0;
        int[] ans = new int[2];
        // long sum = n * ( n + 1 ) / 2;
        // long square = n * ( n + 1 ) * ( 2 * n + 1 ) / 6;
        // for(int i = 0; i< n; i++){
        //     sum = sum - (long)A[i];
        //     square = square - (long)(A[i]*A[i]);
        // }
        //  ans[1] = (int)(( sum + square / sum ) / 2);
        //  ans[0] = (int)(ans[1] - sum);
        // return ans;
        for (int i = 0; i < A.length; i++) {
            int absv = Math.abs(A[i]);
            if (A[absv - 1] > 0)
                A[absv - 1] = -A[absv - 1];
            else
                ans[0] = absv;
        }
        for (int i = 0; i < A.length; i++) {
            if (A[i] > 0)
                ans[1] = (i + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] x = {3,1,2,5,3};
        System.out.println(Arrays.toString(repeatedNumber(x)));
    }
}
