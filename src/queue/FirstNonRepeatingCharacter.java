/*
First non-repeating character
Problem Description

Given a string A denoting a stream of lowercase alphabets.

You have to make new string B. B is formed such that we have to find first non-repeating character each time a character is inserted to the stream and append it at the end to B. if no non-repeating character is found then append '#' at the end of B.



Problem Constraints
1 <= |A| <= 100000



Input Format
The only argument given is string A.



Output Format
Return a string B after processing the stream of lowercase alphabets A.



Example Input
Input 1:

 A = "abadbc"
Input 2:

 A = "abcabc"


Example Output
Output 1:

"aabbdd"
Output 2:

"aaabc#"


Example Explanation
Explanation 1:

"a"      -   first non repeating character 'a'
"ab"     -   first non repeating character 'a'
"aba"    -   first non repeating character 'b'
"abad"   -   first non repeating character 'b'
"abadb"  -   first non repeating character 'd'
"abadbc" -   first non repeating character 'd'
Explanation 2:

"a"      -   first non repeating character 'a'
"ab"     -   first non repeating character 'a'
"abc"    -   first non repeating character 'a'
"abca"   -   first non repeating character 'b'
"abcab"  -   first non repeating character 'c'
"abcabc" -   no non repeating character so '#'
 */
package queue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class FirstNonRepeatingCharacter {
    public String solve(String A) {
        StringBuilder str = new StringBuilder();
        Queue<Character> q = new LinkedList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < A.length(); i++){
            if(!map.containsKey(A.charAt(i))){
                map.put(A.charAt(i), 1);
                q.add(A.charAt(i));
                str = str.append(q.peek());
            }
            else{
                if(!q.isEmpty() && A.charAt(i) != q.peek()){
                    map.put(A.charAt(i), map.get(A.charAt(i)) + 1);
                    str = str.append(q.peek());
                }
                else{
                    map.put(A.charAt(i), map.get(A.charAt(i)) + 1);
                    while(!q.isEmpty() && map.get(q.peek()) > 1){
                        q.remove();
                    }
                    if(q.isEmpty()){
                        str = str.append('#');
                    }
                    else{
                        str.append(q.peek());
                    }
                }
            }
        }
        return str.toString();
    }
}
