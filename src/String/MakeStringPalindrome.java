/*
Make String Pallindrome
Problem Description

Given a string A of size N consisting only of lowercase alphabets. The only operation allowed is to insert characters in the beginning of the string.

Find and return how many minimum characters are needed to be inserted to make the string a palindrome string.



Problem Constraints
1 <= N <= 106



Input Format
The only argument given is a string A.



Output Format
Return an integer denoting the minimum characters that are needed to be inserted to make the string a palindrome string.



Example Input
Input 1:

 A = "abc"
Input 2:

 A = "bb"


Example Output
Output 1:

 2
Output 2:

 0


Example Explanation
Explanation 1:

 Insert 'b' at beginning, string becomes: "babc".
 Insert 'c' at beginning, string becomes: "cbabc".
Explanation 2:

 There is no need to insert any character at the beginning as the string is already a palindrome.
 */
package String;

public class MakeStringPalindrome {
    public int[] computeLPSArray(String str){
        int n = str.length();
        int lps[] = new int[n];
        int i = 1, len = 0;
        lps[0] = 0;

        while (i < n){
            if (str.charAt(i) == str.charAt(len)){
                len++;
                lps[i] = len;
                i++;
            }
            else{
                if (len != 0) {
                    len = lps[len - 1];
                }
                else{
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
    public int solve(String A) {
        StringBuilder s = new StringBuilder();
        s.append(A);
        String rev = s.reverse().toString();
        s.reverse().append("$").append(rev);
        int lps[] = computeLPSArray(s.toString());
        return A.length() - lps[s.length() - 1];
    }
}
