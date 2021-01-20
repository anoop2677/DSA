/*
Sub-matrix Sum Queries
Problem Description

Given a matrix of integers A of size N x M and multiple queries Q, for each query find and return the submatrix sum.

Inputs to queries are top left (b, c) and bottom right (d, e) indexes of submatrix whose sum is to find out.

NOTE:

Rows are numbered from top to bottom and columns are numbered from left to right.
Sum may be large so return the answer mod 109 + 7.


Problem Constraints
1 <= N, M <= 1000
-100000 <= A[i] <= 100000
1 <= Q <= 100000
1 <= B[i] <= D[i] <= N
1 <= C[i] <= E[i] <= M



Input Format
The first argument given is the integer matrix A.
The second argument given is the integer array B.
The third argument given is the integer array C.
The fourth argument given is the integer array D.
The fifth argument given is the integer array E.
(B[i], C[i]) represents the top left corner of the i'th query.
(D[i], E[i]) represents the bottom right corner of the i'th query.



Output Format
Return an integer array containing the submatrix sum for each query.



Example Input
Input 1:

 A = [   [1, 2, 3]
         [4, 5, 6]
         [7, 8, 9]   ]
 B = [1, 2]
 C = [1, 2]
 D = [2, 3]
 E = [2, 3]
Input 2:

 A = [   [5, 17, 100, 11]
         [0, 0,  2,   8]    ]
 B = [1, 1]
 C = [1, 4]
 D = [2, 2]
 E = [2, 4]


Example Output
Output 1:

 [12, 28]
Output 2:

 [22, 19]


Example Explanation
Explanation 1:

 For query 1: Submatrix contains elements: 1, 2, 4 and 5. So, their sum is 12.
 For query 2: Submatrix contains elements: 5, 6, 8 and 9. So, their sum is 28.
Explanation 2:

 For query 1: Submatrix contains elements: 5, 17, 0 and 0. So, their sum is 22.
 For query 2: Submatrix contains elements: 11 and 8. So, their sum is 19.

 */
package ArraysAndMaths;

import java.util.Arrays;

public class SubMatrixSumQueries {
    public static int[] solve(int[][] A, int[] B, int[] C, int[] D, int[] E) {
        int m = A.length;
        int n = A[0].length;
        long mod = (long)(Math.pow(10,9))+7;
        long[][] prefixSum = new long[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if( i==0 && j==0){
                    prefixSum[i][j] = (A[i][j])%mod;
                }
                else if(i==0){
                    prefixSum[i][j] = (prefixSum[i][j-1] + A[i][j])%mod;
                }
                else if(j==0){
                    prefixSum[i][j] = (prefixSum[i-1][j] + A[i][j])%mod;
                }
                else {
                    prefixSum[i][j] = (((prefixSum[i-1][j] + prefixSum[i][j-1])%mod + A[i][j])%mod - prefixSum[i-1][j-1])%mod;
                }
            }
        }

        int[] ans = new int[B.length];
        for(int i = 0; i < B.length; i++){
            if( (B[i]-1)==0 && (C[i]-1)==0){
                ans[i] = (int)((prefixSum[(D[i]-1)][(E[i]-1)])%mod);
            }
            else if((B[i]-1) == 0){
                ans[i] = (int)((prefixSum[(D[i]-1)][(E[i]-1)] - prefixSum[(D[i]-1)][(C[i]-2)])%mod);
            }
            else if((C[i]-1) == 0){
                ans[i] = (int)((prefixSum[(D[i]-1)][(E[i]-1)] - prefixSum[(B[i]-2)][(E[i]-1)])%mod);
            }
            else {
                ans[i] = (int)((prefixSum[(D[i]-1)][(E[i]-1)] - prefixSum[(D[i]-1)][(C[i]-2)] - prefixSum[(B[i]-2)][(E[i]-1)] + prefixSum[(B[i]-2)][(C[i]-2)])%mod);
            }
            while(ans[i] < 0){
                ans[i]+=1000000007;
                ans[i]=(int)(ans[i]%mod);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] x = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        int[] b = {1,2};
        int[] c = {1,2};
        int[] d = {2,3};
        int[] e = {2,3};
        System.out.println(Arrays.toString(solve(x,b,c,d,e)));
    }
}
