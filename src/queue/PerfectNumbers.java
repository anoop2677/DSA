/*
Perfect Numbers
Problem Description

Given an integer A, you have to find the Ath Perfect Number.

A Perfect Number has the following properties:

It comprises only 1 and 2.

The number of digits in a Perfect number is even.

It is a palindrome number.

For example 11, 22, 112211 are Perfect numbers, where 123, 121, 782, 1 are not.



Problem Constraints
1 <= A <= 100000



Input Format
The only argument given is an integer A.



Output Format
Return a string that denotes the Ath Perfect Number.



Example Input
Input 1:

 A = 2
Input 2:

 A = 3


Example Output
Output 1:

 22
Output 2:

 1111


Example Explanation
Explanation 1:

First four perfect numbers are:
1. 11
2. 22
3. 1111
4. 1221
Explanation 2:

First four perfect numbers are:
1. 11
2. 22
3. 1111
4. 1221
 */
package queue;

import java.util.LinkedList;
import java.util.Queue;

public class PerfectNumbers {
    public String solve(int A) {
        Queue<Long> q = new LinkedList<>();
        if(A == 1)return "11";
        if(A == 2) return "22";
        q.add(1L);
        q.add(2L);
        long i = 2, y = 0;
        while(i < A){
            long x = q.peek();
            y = x * 10 + 1;
            q.add(y);
            i++;
            if(i == A ){
                return String.valueOf(y) + new StringBuilder(String.valueOf(y)).reverse().toString();
            }
            y = x * 10 + 2;
            q.add(y);
            q.remove();
            i++;
        }
        return String.valueOf(y) + new StringBuilder(String.valueOf(y)).reverse().toString();
    }
}
