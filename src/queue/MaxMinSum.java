/*
Sum of min and max
Problem Description

Given an array A of both positive and negative integers.

Your task is to compute sum of minimum and maximum elements of all sub-array of size B.

NOTE: Since the answer can be very large, you are required to return the sum modulo 109 + 7.



Problem Constraints
1 <= size of array A <= 105

-109 <= A[i] <= 109

1 <= B <= size of array



Input Format
The first argument denotes the integer array A.
The second argument denotes the value B



Output Format
Return an integer that denotes the required value.



Example Input
Input 1:

 A = [2, 5, -1, 7, -3, -1, -2]
 B = 4
Input 2:

 A = [2, -1, 3]
 B = 2


Example Output
Output 1:

 18
Output 2:

 3


Example Explanation
Explanation 1:

 Subarrays of size 4 are :
    [2, 5, -1, 7],   min + max = -1 + 7 = 6
    [5, -1, 7, -3],  min + max = -3 + 7 = 4
    [-1, 7, -3, -1], min + max = -3 + 7 = 4
    [7, -3, -1, -2], min + max = -3 + 7 = 4
    Sum of all min & max = 6 + 4 + 4 + 4 = 18
Explanation 2:

 Subarrays of size 2 are :
    [2, -1],   min + max = -1 + 2 = 1
    [-1, 3],   min + max = -1 + 3 = 2
    Sum of all min & max = 1 + 2 = 3
 */
package queue;

import java.util.Deque;
import java.util.LinkedList;

public class MaxMinSum {
    public static int solve(int[] A, int B) {
        int j = 0;
        int mod = (int)1e9 + 7;
        Deque<Integer> dq = new LinkedList<>();
        Deque<Integer> dq1 = new LinkedList<>();
        int sum = 0;
        int i =0;
        for (i = 0; i < B; i++){
            while (!dq.isEmpty() && A[i] >= A[dq.peekLast()])
                dq.removeLast();
            while (!dq1.isEmpty() && A[i] <= A[dq1.peekLast()])
                dq1.removeLast();
            dq.addLast(i);
            dq1.addLast(i);
        }
        for (; i < A.length; i++) {
            sum = (sum + A[dq.peekFirst()] + A[dq1.peekFirst()]) % mod;
            while ((!dq.isEmpty()) && dq.peekFirst() <= i - B)
                dq.removeFirst();
            while ((!dq.isEmpty()) && A[i] >= A[dq.peekLast()])
                dq.removeLast();
            while ((!dq1.isEmpty()) && dq1.peekFirst() <= i - B)
                dq1.removeFirst();
            while ((!dq1.isEmpty()) && A[i] <= A[dq1.peekLast()])
                dq1.removeLast();
            dq.addLast(i);
            dq1.addLast(i);
        }
        sum = (sum + A[dq.peekFirst()] + A[dq1.peekFirst()]) % mod;
        return (sum + mod) % mod;
    }

    public static void main(String[] args) {
        int[] x = {2, 5, -1, 7, -3, -1, -2};
        System.out.println(solve(x, 4));
    }
}
