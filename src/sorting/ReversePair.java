/*
Reverse pairs
Problem Description

Given an array of integers A, we call (i, j) an important reverse pair if i < j and A[i] > 2*A[j].
Return the number of important reverse pairs in the given array A.



Problem Constraints
1 <= length of the array <= 100000

1 <= A[i] <= 10^9



Input Format
The only argument given is the integer array A.



Output Format
Return the number of important reverse pairs in the given array A.



Example Input
Input 1:

 A = [1, 3, 2, 3, 1]
Input 2:

 A = [4, 1, 2]


Example Output
Output 1:

 2
Output 2:

 1


Example Explanation
Explanation 1:

 There are two pairs which are important reverse i.e (3, 1) and (3, 1).
Explanation 2:

 There is only one pair i.e (4, 1).
 */
package sorting;

import java.util.Arrays;

public class ReversePair {
    public void merge(int[] a, int l, int m, int r){
        int[] larray = Arrays.copyOfRange(a, l, m + 1);
        int[] rarray = Arrays.copyOfRange(a, m + 1, r+1);
        int i = 0, j = 0, k = l;
        while (i < larray.length && j < rarray.length){
            if (larray[i] <= rarray[j])
                a[k++] = larray[i++];
            else {
                a[k++] = rarray[j++];
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
    }
    public int mergeSortAndCount(int[] A, int start, int end){
        int count = 0;
        if(start < end){
            int mid = start + (end - start) / 2;
            count = count + mergeSortAndCount(A, start, mid);
            count = count + mergeSortAndCount(A, mid + 1, end);
            int j = mid + 1;
            for (int i = start; i <= mid; i++) {
                while (j <= end && A[i] > A[j] * 2)
                    j++;
                count += j - (mid + 1);
            }
            merge(A, start, mid, end);
            return count;
        }
        else return 0;
    }
    public int solve(int[] A) {
        return mergeSortAndCount(A, 0 , A.length - 1);
    }
}
