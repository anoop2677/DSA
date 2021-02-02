/*
Longest Substring Without Repeat
Problem Description

Given a string A, find the length of the longest substring without repeating characters.

Note: Users are expected to solve in O(N) time complexity.



Problem Constraints
1 <= size(A) <= 106

String consists of lowerCase,upperCase characters and digits are also present in the string A.



Input Format
Single Argument representing string A.



Output Format
Return an integer denoting the maximum possible length of substring without repeating characters.



Example Input
Input 1:

 A = "abcabcbb"
Input 2:

 A = "AaaA"


Example Output
Output 1:

 3
Output 2:

 2


Example Explanation
Explanation 1:

 Substring "abc" is the longest substring without repeating characters in string A.
Explanation 2:

 Substring "Aa" or "aA" is the longest substring without repeating characters in string A.
 */
package Hashing;

import java.util.HashSet;

public class LongestSubStringWithoutRepeat {
    public int lengthOfLongestSubstring(String A) {
        HashSet<Character> set = new HashSet<>();
        int count = 0;
        int max = 0;
        for(int i = 0; i < A.length(); i++){
            if(!set.contains(A.charAt(i))){
                set.add(A.charAt(i));
                count++;
                max = Math.max(max, count);
            }
            else{
                set = new HashSet<>();
                count = 0;
                int j = i - 1;
                set.add(A.charAt(i));
                count++;
                while(j>=0){
                    if(A.charAt(i) == A.charAt(j)){
                        break;
                    }
                    set.add(A.charAt(j));
                    count++;j--;
                }
            }
        }
        return max;
    }
}
