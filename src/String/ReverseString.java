/*
Reverse the String
Problem Description

Given a string A of size N.

Return the string A after reversing the string word by word.

NOTE:

A sequence of non-space characters constitutes a word.
Your reversed string should not contain leading or trailing spaces, even if it is present in the input string.
If there are multiple spaces between words, reduce them to a single space in the reversed string.


Problem Constraints
1 <= N <= 3 * 105



Input Format
The only argument given is string A.



Output Format
Return the string A after reversing the string word by word.



Example Input
Input 1:
    A = "the sky is blue"
Input 2:
    A = "this is ib"


Example Output
Output 1:
    "blue is sky the"
Output 2:
    "ib is this"


Example Explanation
Explanation 1:
    We reverse the string word by word so the string becomes "the sky is blue".
Explanation 2:
    We reverse the string word by word so the string becomes "this is ib".
 */
package String;

import java.util.ArrayList;

public class ReverseString {
    public String solve(String A) {

        ArrayList<String> list = new ArrayList<String>();

        String cur = "";
        for(int i=0;i<A.length();i++)
        {
            char c = A.charAt(i);
            if(c == ' ')
            {
                if(cur.length()!=0)
                {

                    list.add(cur);
                }
                cur = "";
            }
            else
            {
                cur += c;
            }
        }
        if(cur.length()!=0) list.add(cur);

        String ans = "";
        for(int i=list.size()-1;i>=0;i--)
        {
            ans += list.get(i);
            if(i!=0)
            {
                ans += ' ';
            }
        }

        return ans;
    }
}
