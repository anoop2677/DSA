/*
Sort Array in given Order
Problem Description

Given two array of integers A and B, Sort A in such a way that the relative order among the elements will be the same as those are in B. For the elements not present in B, append them at last in sorted order.

Return the array A after sorting from the above method.

NOTE: Elements of B are unique.



Problem Constraints
1 <= length of the array A <= 100000

1 <= length of the array B <= 100000

-10^9 <= A[i] <= 10^9



Input Format
The first argument given is the integer array A.

The second argument given is the integer array B.



Output Format
Return the array A after sorting as described.



Example Input
Input 1:

A = [1, 2, 3, 4, 5]
B = [5, 4, 2]
Input 2:

A = [5, 17, 100, 11]
B = [1, 100]


Example Output
Output 1:

[5, 4, 2, 1, 3]
Output 2:

[100, 5, 11, 17]


Example Explanation
Explanation 1:

 Simply sort as described.
Explanation 2:

 Simply sort as described.
 */
package Hashing;

import java.util.Arrays;
import java.util.HashMap;

public class SortArrayInGivenOrder {
    public int[] solve(int[] A, int[] B) {
        int[] ans = new int[A.length];
        int k = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < A.length; i++){
            if(map.containsKey(A[i])){
                map.put(A[i], map.get(A[i]) + 1);
            }
            else{
                map.put(A[i], 1);
            }
        }
        for(int i = 0; i < B.length; i++){
            if(map.containsKey(B[i])){
                int count = map.get(B[i]);
                while(count-- > 0){
                    ans[k++] = B[i];
                    map.put(B[i], count);
                }
            }
        }
        int[] ar = new int[A.length - k];
        int j = 0;
        for(int key: map.keySet()){
            int count = map.get(key);
            if(count != 0){
                while(count-- > 0){
                    ar[j++] = key;
                    map.put(key, count);
                }
            }
        }
        Arrays.sort(ar);
        for(int i = 0; i < ar.length; i++){
            ans[k++] = ar[i];
        }
        return ans;
    }
}
