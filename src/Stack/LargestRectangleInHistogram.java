/*
Largest Rectangle in Histogram
Problem Description

Given an array of integers A .

A represents a histogram i.e A[i] denotes height of the ith histogram's bar. Width of each bar is 1.

Find the area of the largest rectangle formed by the histogram.



Problem Constraints
1 <= |A| <= 100000

1 <= A[i] <= 1000000000



Input Format
The only argument given is the integer array A.



Output Format
Return the area of largest rectangle in the histogram.



Example Input
Input 1:

 A = [2, 1, 5, 6, 2, 3]
Input 2:

 A = [2]


Example Output
Output 1:

 10
Output 2:

 2


Example Explanation
Explanation 1:

The largest rectangle has area = 10 unit. Formed by A[3] to A[4].
Explanation 2:

Largest rectangle has area 2.
 */
package Stack;

import java.util.Stack;

public class LargestRectangleInHistogram {
    public static int largestRectangleArea(int[] A) {
        Stack<Integer> st = new Stack<>();
        int area = 0;
        int i = 0;
        for(i = 0; i < A.length;){
            if(st.isEmpty() || A[i] >= A[st.peek()]){
                st.push(i++);
            }
            else{
                int x = st.pop();
                area = Math.max(area, A[x] * (st.isEmpty() ? i : i - st.peek() -1));
            }
        }
        while (!st.isEmpty()){
            int x = st.pop();
            area = Math.max(area, A[x] * (st.isEmpty() ? i : i - st.peek() -1));
        }

        return area;
    }

    public static void main(String[] args) {
        int[] x= {2};
        System.out.println(largestRectangleArea(x));
    }
}
