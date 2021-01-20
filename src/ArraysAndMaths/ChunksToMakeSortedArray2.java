/*
Max Chunks To Make Sorted II
Problem Description

Given an array of integers (not necessarily distinct) A, if we split the array into some number of "chunks" (partitions), and individually sort each chunk. After concatenating them, the result equals the sorted array.

What is the most number of chunks we could have made?



Problem Constraints
1 <= N <= 100000
-109 <= A[i] <= 109



Input Format
The only argument given is the integer array A.



Output Format
Return the maximum number of chunks that we could have made.



Example Input
 A = [2, 0, 1, 2]


Example Output
 2


Example Explanation
 We can split the array into two subarray one consisting element [2,0,1] and second one with only element [2].
 Sort them individually and concat them. The result will be sorted.
 */
package ArraysAndMaths;

import java.util.Stack;

public class ChunksToMakeSortedArray2 {
    public int solve(int[] A) {
        Stack<int[]> stack = new Stack<int[]>();

        for(int i=0; i<A.length; i++){
            int min=A[i];
            int max=A[i];

            while(!stack.isEmpty()){
                int[] top = stack.peek();

                if(A[i] < top[1]){
                    min=Math.min(top[0], min);
                    max=Math.max(max, top[1]);
                    stack.pop();
                }else{
                    break;
                }
            }

            stack.push(new int[]{min,max});
        }
        return stack.size();
    }
}
