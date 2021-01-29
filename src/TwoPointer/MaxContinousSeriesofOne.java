/*
Max Continuous Series of 1s
Problem Description

Given a binary array A, find the maximum sequence of continuous 1's that can be formed by replacing at-most B ones.

For this problem, return the indices of maximum continuous series of 1s in order.

If there are multiple possible solutions, return the sequence which has the minimum start index.



Problem Constraints
0 <= B <= 105

1 <= size(A) <= 105

A[i]==0 or A[i]==1



Input Format
First argument is an binary array A.

Second argument is an integer B.



Output Format
Return an array of integers denoting the indices(0-based) of 1's in the maximum continuous series.



Example Input
Input 1:

 A = [1 1 0 1 1 0 0 1 1 1 ]
 B = 1
Input 2:

 A = [1, 0, 0, 0, 1, 0, 1]
 B = 2


Example Output
Output 1:

 [0, 1, 2, 3, 4]
Output 2:

 [3, 4, 5, 6]


Example Explanation
Explanation 1:

 Flipping 0 present at index 2 gives us the longest continous series of 1's i.e subarray [0:4].
Explanation 2:

 Flipping 0 present at index 3 and index 5 gives us the longest continous series of 1's i.e subarray [3:6].
 */
package TwoPointer;

public class MaxContinousSeriesofOne {
    public int[] maxone(int[] A, int B) {
        int wL = 0, wR = 0;
        int nZero = 0;
        int bestWindowWidth = -1;
        int start = 0, end = 0;
        while (wR < A.length){
            if (nZero <= B){
                if (A[wR] == 0)
                    ++nZero;
                ++wR;
            }
            if (nZero > B){
                if (A[wL] == 0) --nZero;
                ++wL;
            }
            if (wR - wL + 1 > bestWindowWidth){
                bestWindowWidth = wR - wL + 1;
                start = wL;
                end = wR;
            }
        }
        int[] ans = new int[end - start];
        int k = 0;
        for (int i = start; i<end; ++i)
            ans[k++] = i;
        return ans;
    }
}
