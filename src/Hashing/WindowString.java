/*
Window String
Problem Description

Given a string A and a string B, find the window with minimum length in A which will contain all the characters in B in linear time complexity.
Note that when the count of a character c in B is x, then the count of c in minimum window in A should be at least x.

Note:

If there is no such window in A that covers all characters in B, return the empty string.
If there are multiple such windows, return the first occurring minimum window ( with minimum start index )


Problem Constraints
1 <= size(A), size(B) <= 106



Input Format
First argument is a string A.
Second argument is a string B.



Output Format
Return a string denoting the minimum window.



Example Input
Input 1:

 A = "ADOBECODEBANC"
 B = "ABC"
Input 2:

 A = "Aa91b"
 B = "ab"


Example Output
Output 1:

 "BANC"
Output 2:

 "a91b"


Example Explanation
Explanation 1:

 "BANC" is a substring of A which contains all characters of B.
Explanation 2:

 "a91b" is the substring of A which contains all characters of B.
 */
package Hashing;

import java.util.HashMap;

public class WindowString {
    public String minWindow(String A, String B) {
        if(A.length() == 0 || B.length() == 0)return "";
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < B.length(); i++) {
            int count = map.getOrDefault(B.charAt(i), 0);
            map.put(B.charAt(i), count + 1);
        }

        int req = map.size();
        int l = 0, r = 0;
        int formed = 0;
        HashMap<Character, Integer> winCount = new HashMap<>();
        int[] ans = {-1, 0 , 0};
        while(r < A.length()){
            char c = A.charAt(r);
            int count = winCount.getOrDefault(c, 0);
            winCount.put(c, count + 1);
            if (map.containsKey(c) && winCount.get(c).intValue() == map.get(c).intValue()){
                formed++;
            }
            while(l <= r && formed == req){
                c = A.charAt(l);
                if (ans[0] == -1 || r - l + 1 < ans[0]) {
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;
                }
                winCount.put(c, winCount.get(c) - 1);
                if (map.containsKey(c) && winCount.get(c).intValue() < map.get(c).intValue()) {
                    formed--;
                }
                l++;
            }
            r++;
        }
        return ans[0] == -1 ? "" : A.substring(ans[1], ans[2] + 1);
    }
}
