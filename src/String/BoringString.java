/*
Boring substring
Problem Description

Given a string A of lowercase English alphabets. Rearrange the characters of the given string A such that there is no boring substring in A.

A boring substring has the following properties:

Its length is 2.
Both the characters are consecutive, for example - "ab", "cd", "dc", "zy" etc.(If the first character is C then the next character can be either (C+1) or (C-1)).
Return 1 if it possible to rearrange the letters of A such that there are no boring substring in A, else return 0.



Problem Constraints
1 <= |A| <= 105



Input Format
The only argument given is string A.



Output Format
Return 1 if it possible to rearrange the letters of A such that there are no boring substring in A, else return 0.



Example Input
Input 1:

 A ="abcd"
Input 2:

 A = "aab"


Example Output
Output 1:

 1
Output 2:

 0


Example Explanation
Explanation 1:

 String A can be rearranged into "cadb" or "bdac"
Explanation 2:

 No arrangement of string A can make it free of boring substrings.
 */
package String;

public class BoringString {
    public static int solve(String A) {
        char min = 'z';
        char max = 'a';
        char min1 = 'z';
        char max1 = 'a';
        for (int i = 0; i < A.length(); i++) {
            if ((int)A.charAt(i) % 2 == 0) {
                min = (char)Math.min((int)min, (int)A.charAt(i));
                max = (char)Math.max((int)max, (int)A.charAt(i));
            }
            else{
                min1 = (char)Math.min((int)min1, (int)A.charAt(i));
                max1 = (char)Math.max((int)max1, (int)A.charAt(i));
            }
        }
        boolean cond1 = true;
        boolean cond2 = true;
        if(max == min1 - 1 || max == min1 + 1){
            cond1 = false;
        }
        if(max1 == min - 1 || max1 == min + 1){
            cond2 = false;
        }
        if(!cond1 && !cond2) return 0;
        return 1;
    }

    public static void main(String[] args) {
        String s= "wwuvuw";
        System.out.println(solve(s));
    }
}
