/*
Problem Description

Given an array A of size N, groot wants you to pick 2 indices i and j such that

1 <= i, j <= N
A[i] % A[j] is maximum among all possible pairs of (i, j).
Help Groot in finding the maximum value of A[i] % A[j] for some i, j.



Problem Constraints
1 <= N <= 100000
0 <= A[i] <= 100000



Input Format
First and only argument in an integer array A.



Output Format
Return an integer denoting the maximum value of A[i] % A[j] for any valid i, j.



Example Input
Input 1:

 A = [1, 2, 44, 3]
Input 2:

 A = [2, 6, 4]


Example Output
Output 1:

 3
Output 2:

 4
 */

package sorting;

public class MaxMod {
    public static int solve(int[] A) {
        int max = 0;
        int max2 = 0;
        for(int i = 0; i < A.length; i++){
            if(max < A[i]){
                max2 = max;
                max = A[i];
            }
            else if(max > A[i]){
                if(max2 < A[i]){
                    max2 = A[i];
                }
            }
        }
        return max2;
    }

    public static void main(String[] args) {
        int[] x = {1,2,44,3};
        System.out.println(solve(x));
    }
}
