/*
Cyclic Permutations
Problem Description

Given two binary strings A and B, count how many cyclic permutations of B when taken XOR with A give 0.

NOTE: If there is a string, S0, S1, ... Sn-1 , then it's cyclic permutation is of the form Sk, Sk+1, ... Sn-1, S0, S1, ... Sk-1 where k can be any integer from 0 to N-1.



Problem Constraints
1 ≤ length(A) = length(B) ≤ 105



Input Format
First argument is a string A.
Second argument is a string B.



Output Format
Return an integer denoting the required answer.



Example Input
Input 1:

 A = "1001"
 B = "0011"
Input 2:

 A = "111"
 B = "111"


Example Output
Output 1:

 1
Output 2:

 3


Example Explanation
Explanation 1:

 4 cyclic permutations of B exists: "0011", "0110", "1100", "1001".
 There is only one cyclic permutation of B i.e. "1001" which has 0 xor with A.
Explanation 2:

 All cyclic permutations of B are same as A and give 0 when taken xor with A. So, the ans is 3.
 */
package String;

public class CyclicPermutation {
    void compute_z(String s, int z[]) {
        int l = 0, r = 0;
        int n = s.length();
        for (int i = 1; i <= n - 1; i++) {
            if (i > r) {
                l = i;
                r = i;
                while (r < n && s.charAt(r - l) == s.charAt(r))
                    r++;
                z[i] = r - l;
                r--;
            }
            else {
                int k = i - l;
                if (z[k] < r - i + 1) {
                    z[i] = z[k];
                }
                else {
                    l = i;
                    while (r < n && s.charAt(r - l) == s.charAt(r))
                        r++;
                    z[i] = r - l;
                    r--;
                }
            }
        }
    }
    public int solve(String A, String B) {
        B = B + B;
        B = B.substring(0, B.length() - 1);
        int ans = 0;
        String s = A + "$" + B;
        int n = s.length();
        int[] z = new int[n];
        compute_z(s, z);

        for (int i = 1; i <= n - 1; i++) {
            if (z[i] == A.length())
                ans++;
        }
        return ans;
    }
}
