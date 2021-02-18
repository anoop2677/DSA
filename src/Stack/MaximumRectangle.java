/*
Maximum Rectangle
Given a 2D binary matrix of integers A containing 0's and 1's of size N x M.

Find the largest rectangle containing only 1's and return its area.

Note: Rows are numbered from top to bottom and columns are numbered from left to right.


Input Format

The only argument given is the integer matrix A.
Output Format

Return the area of the largest rectangle containing only 1's.
Constraints

1 <= N, M <= 1000
0 <= A[i] <= 1
For Example

Input 1:
    A = [   [0, 0, 1]
            [0, 1, 1]
            [1, 1, 1]   ]
Output 1:
    4

Input 2:
    A = [   [0, 1, 0, 1]
            [1, 0, 1, 0]    ]
Output 2:
    1
 */
package Stack;

import java.util.Arrays;
import java.util.Stack;

public class MaximumRectangle {
    public static int solve(int[][] A) {
        for(int i = 1; i < A.length; i++){
            for(int j = 0; j < A[i].length; j++){
                if(A[i][j] == 1)
                    A[i][j] = A[i][j] + A[i - 1][j];
            }
        }
        int area = 0;
        for(int i = 0 ;i < A.length; i++){
            Stack<Integer> st = new Stack<>();
            int j = 0;
            for(j = 0; j < A[i].length;){
                if(st.isEmpty() || A[i][j] >= A[i][st.peek()]){
                    st.push(j++);
                }
                else{
                    int x = st.pop();
                    area = Math.max(area, A[i][x] * (st.isEmpty() ? j : j - st.peek() -1));
                }
            }
            while (!st.isEmpty()){
                int x = st.pop();
                area = Math.max(area, A[i][x] * (st.isEmpty() ? j : j - st.peek() -1));
            }
        }
        return area;
    }

    public static void main(String[] args) {
        int[][] x= {
            {0, 1, 1},
            {1, 0, 0},
            {1, 0, 0},
            {1, 0, 0},
            {1, 0, 0},
            {1, 1, 1},
            {0, 1, 0},
        };
        System.out.println(solve(x));
    }
}
