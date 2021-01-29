/*
Inversion count in an array
Problem Description

Given an array of integers A. If i < j and A[i] > A[j] then the pair (i, j) is called an inversion of A. Find the total number of inversions of A modulo (109 + 7).



Problem Constraints
1 <= length of the array <= 100000

1 <= A[i] <= 10^9



Input Format
The only argument given is the integer array A.



Output Format
Return the number of inversions of A modulo (109 + 7).



Example Input
Input 1:

A = [3, 2, 1]
Input 2:

A = [1, 2, 3]


Example Output
Output 1:

3
Output 2:

0


Example Explanation
Explanation 1:

 All pairs are inversions.
Explanation 2:

 No inversions.
 */
package sorting;

import java.util.Arrays;

public class InversionCountArray {
    public int mergeAndCount(int[] a, int l, int m, int r){
        int[] larray = Arrays.copyOfRange(a, l, m + 1);
        int[] rarray = Arrays.copyOfRange(a, m + 1, r+1);
        int i = 0, j = 0, k = l, swaps = 0;
        while (i < larray.length && j < rarray.length){
            if (larray[i] <= rarray[j])
                a[k++] = larray[i++];
            else {
                a[k++] = rarray[j++];
                swaps += (m + 1) - (l + i);
            }
        }
        if(i == larray.length && j!=rarray.length){
            while(j < rarray.length){
                a[k] = rarray[j];
                k++;j++;
            }
        }
        if(i != larray.length && j==rarray.length){
            while(i < larray.length){
                a[k] = larray[i];
                k++;i++;
            }
        }
        return swaps;
    }
    public int mergeSortAndCount(int[] a, int start, int end){
        int count = 0;
        if(start < end){
            int mid = start + (end - start) / 2;
            int mod = (int)1e9 + 7;
            count = (count + mergeSortAndCount(a, start, mid)) % mod;
            count = (count + mergeSortAndCount(a, mid + 1, end)) % mod;
            count = (count + mergeAndCount(a, start, mid, end)) % mod;
        }
        return count;

    }
    public int solve(int[] A) {
        return mergeSortAndCount(A, 0 , A.length - 1);
    }
}
