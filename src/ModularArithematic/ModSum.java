/*
Mod Sum
Problem Description

Given an array of integers A, calculate the sum of A [ i ] % A [ j ] for all possible i, j pairs. Return sum % (109 + 7) as an output.



Problem Constraints
1 <= length of the array A <= 105

1 <= A[i] <= 103



Input Format
The only argument given is the integer array A.



Output Format
Return a single integer denoting sum % (109 + 7).



Example Input
Input 1:

 A = [1, 2, 3]
Input 2:

 A = [17, 100, 11]


Example Output
Output 1:

 5
Output 2:

 61


Example Explanation
Explanation 1:

 (1 % 1) + (1 % 2) + (1 % 3) + (2 % 1) + (2 % 2) + (2 % 3) + (3 % 1) + (3 % 2) + (3 % 3) = 5
 */
package ModularArithematic;

import java.util.HashMap;

public class ModSum {
    public int solve(int[] A) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int mod = (int)1e9 + 7;
        for(int i = 0; i < A.length; i++){
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
        }
        int ans = 0;
        for(int key: map.keySet()){
            for(int key1: map.keySet()){
                ans = (ans + map.get(key) * map.get(key1) * (key % key1)) % mod;
            }
        }
        return ans % mod;
    }
}
