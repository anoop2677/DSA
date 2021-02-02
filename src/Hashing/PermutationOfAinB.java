/*
Permutations of A in B
Problem Description

You are given two strings A and B of size N and M respectively.

You have to find the count of all permutations of A present in B as a substring. You can assume a string will have only lowercase letters.



Problem Constraints
1 <= N < M <= 105



Input Format
Given two argument, A and B of type String.



Output Format
Return a single Integer, i.e number of permutations of A present in B as a substring.



Example Input
Input 1:

 A = "abc"
 B = "abcbacabc"
Input 2:

 A = "aca"
 B = "acaa"


Example Output
Output 1:

 5
Output 2:

 2


Example Explanation
Explanation 1:

 Permutations of A that are present in B as substring are:
    1. abc
    2. cba
    3. bac
    4. cab
    5. abc
    So ans is 5.
Explanation 2:

 Permutations of A that are present in B as substring are:
    1. aca
    2. caa
 */
package Hashing;

public class PermutationOfAinB {
    public boolean matches(int[] s1map, int[] s2map) {
        for (int i = 0; i < 26; i++) {
            if (s1map[i] != s2map[i])
                return false;
        }
        return true;
    }
    public int solve(String A, String B) {
        if (A.length() > B.length())
            return 0;
        int[] s1map = new int[26];
        int[] s2map = new int[26];
        for (int i = 0; i < A.length(); i++) {
            s1map[A.charAt(i) - 'a']++;
            s2map[B.charAt(i) - 'a']++;
        }
        int ans = 0;
        for (int i = 0; i < B.length() - A.length(); i++) {
            if (matches(s1map, s2map)){
                ans++;
                // s2map[B.charAt(i) - 'a']--;
            }
            s2map[B.charAt(i + A.length()) - 'a']++;
            s2map[B.charAt(i) - 'a']--;
        }
        return matches(s1map, s2map) ? ans+1 : ans;
    }
}
