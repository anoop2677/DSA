/*
Rain Water Trapped
Problem Description

Given a vector A of non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.



Problem Constraints
1 <= |A| <= 100000



Input Format
First and only argument is the vector A



Output Format
Return one integer, the answer to the question



Example Input
Input 1:

A = [0, 1, 0, 2]
Input 2:

A = [1, 2]


Example Output
Output 1:

1
Output 2:

0


Example Explanation
Explanation 1:

1 unit is trapped on top of the 3rd element.
Explanation 2:

No water is trapped.
 */
package OneDandTwoDArray;

public class RainWaterTrapped {
    public static int trap(final int[] A) {
        int max = Integer.MIN_VALUE;
        int n = A.length;
        int j = 0;
        for(int i = 0; i < n; i++){
            if(max < A[i]){
                max = A[i];
                j = i;
            }
        }
        int maxLeft = A[0];
        int ans = 0;
        for(int i = 1; i < j; i++){
            maxLeft = Math.max(maxLeft, A[i]);
            ans += Math.min(max, maxLeft) - A[i];
        }
        int maxRight = A[n-1];
        for(int k = n-2; k >=j; k--){
            maxRight = Math.max(maxRight, A[k]);
            ans += Math.min(max, maxRight) - A[k];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] x = {0, 1, 0, 2};
        System.out.println(trap(x));
    }
}
