/*
Count Subarrays
Problem Description

Misha likes finding all Subarrays of an Array. Now she gives you an array A of N elements and told you to find the number of subarrays of A, that have unique elements.

Since the number of subarrays could be large, return value % 109 +7.



Problem Constraints
1 <= N <= 105

1 <= A[i] <= 106



Input Format
The only argument given is an Array A, having N integers.



Output Format
Return the number of subarrays of A, that have unique elements.



Example Input
Input 1:

 A = [1, 1, 3]
Input 2:

 A = [2, 1, 2]


Example Output
Output 1:

 4
Output 1:

 5


Example Explanation
Explanation 1:

 Subarrays of A that have unique elements only:
 [1], [1], [1, 3], [3]
Explanation 2:

 Subarrays of A that have unique elements only:
 [2], [1], [2, 1], [1, 2], [2]
 */
package TwoPointer;

import java.util.HashSet;

public class CountSubarrays {
    public static int solve(int[] A) {
        int i = 0, j = 0;
        int count = 0;
        int mod = (int)1e9 + 7;
        HashSet<Integer> set = new HashSet<>();
        while(i < A.length && j < A.length){
            if(set.contains(A[j])){
                while(i < A.length && A[i]!=A[j]){
                    set.remove(A[i]);
                    i++;
                }
                set.remove(A[i]);
                i++;
            }
            else{
                set.add(A[j]);
                count = (count + (j - i + 1))%mod;
                j++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] x= {93, 9, 12, 32, 97, 75, 32, 77, 40, 79, 61, 42, 57, 19, 64, 16, 86, 47, 41, 67, 76, 63, 24, 10, 25, 96, 1, 30, 73, 91, 70, 65, 53, 75, 5, 19, 65, 6, 96, 33, 73, 55, 4, 90, 72, 83, 54, 78, 67, 56, 8, 70, 43, 63};
        System.out.println(solve(x));
    }
}
