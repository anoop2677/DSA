/*
Maximum Frequency stack
Problem Description

You are given a matrix A which represent operations of size N x 2. Assume initially you have a stack-like data structure you have to perform operations on it.

Operations are of two types:

1 x: push an integer x onto the stack and return -1

2 0: remove and return the most frequent element in the stack.

If there is a tie for the most frequent element, the element closest to the top of the stack is removed and returned.

A[i][0] describes the type of operation to be performed. A[i][1] describe the element x or 0 corresponding to the operation performed.



Problem Constraints
1 <= N <= 100000

1 <= A[i][0] <= 2

0 <= A[i][1] <= 109



Input Format
The only argument given is the integer array A.



Output Format
Return the array of integers denoting answer to each operation.



Example Input
Input 1:

A = [
            [1, 5]
            [1, 7]
            [1, 5]
            [1, 7]
            [1, 4]
            [1, 5]
            [2, 0]
            [2, 0]
            [2, 0]
            [2, 0]  ]
Input 2:

 A =  [
        [1, 5]
        [2 0]
        [1 4]   ]


Example Output
Output 1:

 [-1, -1, -1, -1, -1, -1, 5, 7, 5, 4]
Output 2:

 [-1, 5, -1]


Example Explanation
Explanation 1:

 Just simulate given operations
Explanation 2:

 Just simulate given operations
 */
package Stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class MaxFrequencyStack {
    public static int[] solve(int[][] A) {
        int maxFreq = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Stack<Integer>> stmap = new HashMap<>();
        int[] ans = new int[A.length];
        for(int i = 0;i < A.length; i++){
            if(A[i][0] == 1){
                map.put(A[i][1], map.getOrDefault(A[i][1], 0) + 1);
                maxFreq = Math.max(maxFreq, map.get(A[i][1]));
                if(stmap.containsKey(map.get(A[i][1]))){
                    Stack<Integer> temp = stmap.get(map.get(A[i][1]));
                    temp.push(A[i][1]);
                    stmap.put(map.get(A[i][1]), temp);
                }
                else{
                    Stack<Integer> temp = new Stack<>();
                    temp.push(A[i][1]);
                    stmap.put(map.get(A[i][1]), temp);
                }
                ans[i] = -1;
            }
            else{
                int x = stmap.get(maxFreq).pop();
                map.put(x, map.get(x) - 1);
                if(stmap.get(maxFreq).isEmpty()) maxFreq--;
                ans[i] = x;
            }
//            System.out.println(Arrays.toString(ans) + " ** "+maxFreq);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] x = {
                {1,4},{2,0},{1,9},{2,0},{1,6},{1,6},{2,0}
        };
        System.out.println(Arrays.toString(solve(x)));
    }
}
