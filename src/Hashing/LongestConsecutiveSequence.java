/*
Longest Consecutive Sequence
Problem Description

Given an unsorted integer array A of size N.

Find the length of the longest set of consecutive elements from the array A.



Problem Constraints
1 <= N <= 106

-106 <= A[i] <= 106



Input Format
First argument is an integer array A of size N.



Output Format
Return an integer denoting the length of the longest set of consecutive elements from the array A.



Example Input
Input 1:

A = [100, 4, 200, 1, 3, 2]
Input 2:

A = [2, 1]


Example Output
Output 1:

 4
Output 2:

 2


Example Explanation
Explanation 1:

 The set of consecutive elements will be [1, 2, 3, 4].
Explanation 2:

 The set of consecutive elements will be [1, 2].
 */
package Hashing;

import java.util.HashSet;

public class LongestConsecutiveSequence {
    public int longestConsecutive(final int[] A) {
        int length = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < A.length; i++){
            set.add(A[i]);
        }
        for(int i = 0; i < A.length;){
            if(set.contains(A[i] - 1)){
                i++;
            }
            else{
                int k = A[i];
                int count = 0;
                while(set.contains(k)){
                    count++;k++;
                }
                length = Math.max(length, count);
                i++;
            }
        }
        return length;

    }
}
