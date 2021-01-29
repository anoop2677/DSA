/*
Array 3 Pointers
Problem Description

You are given 3 sorted arrays A, B and C.

Find i, j, k such that : max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i])) is minimized.

Return the minimum max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i])).



Problem Constraints
0 <= len(A), len(B), len(c) <= 106

0 <= A[i], B[i], C[i] <= 107



Input Format
First argument is an integer array A.

Second argument is an integer array B.

Third argument is an integer array C.



Output Format
Return an single integer denoting the minimum max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i])).



Example Input
Input 1:

 A = [1, 4, 10]
 B = [2, 15, 20]
 C = [10, 12]
Input 2:

 A = [3, 5, 6]
 B = [2]
 C = [3, 4]


Example Output
Output 1:

 5
Output 2:

 1


Example Explanation
Explanation 1:

 With 10 from A, 15 from B and 10 from C.
Explanation 2:

 With 3 from A, 2 from B and 3 from C.
 */
package TwoPointer;

public class ArrayThreePointers {
    public int minimize(final int[] A, final int[] B, final int[] C) {
        int ai = 0;
        int bi = 0;
        int ci = 0;
        int min = Integer.MAX_VALUE;
        int maxDiff = 0;
        while(ai < A.length && bi < B.length && ci < C.length){
            maxDiff = Math.max(Math.abs(A[ai] - B[bi]), Math.max(Math.abs(B[bi] - C[ci]), Math.abs(A[ai] - C[ci])));
            min = Math.min(min, maxDiff);
            if(A[ai] <= B[bi]  && A[ai] <= C[ci]){
                ai++;
            }
            else if(B[bi] <= A[ai]  && B[bi] <= C[ci]){
                bi++;
            }
            else if(C[ci] <= A[ai]  && C[ci] <= B[bi]){
                ci++;
            }
        }
        return min;
    }
}
