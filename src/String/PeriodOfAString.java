/*
Period of a string
Problem Description

Given a string A of length N consisting of lowercase alphabets. Find the period of the string.

Period of the string is the minimum value of k (k >= 1), that satisfies A[i] = A[i % k] for all valid i.



Problem Constraints
1 <= N <= 106



Input Format
First and only argument is a string A of length N.



Output Format
Return an integer, denoting the period of the string.



Example Input
Input 1:

 A = "abababab"
Input 2:

 A = "aaaa"


Example Output
Output 1:

 2
Output 2:

 1


Example Explanation
Explanation 1:

 Period of the string will be 2:
 Since, for all i, A[i] = A[i%2].
Explanation 2:

 Period of the string will be 1.
 */
package String;

public class PeriodOfAString {
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
    public int solve(String A) {
        int[] z = new int[A.length()];
        compute_z(A, z);
        for(int i = 0; i < z.length; i++){
            if(z[i] + i == z.length){
                return i;
            }
        }
        return z.length;
    }
}
