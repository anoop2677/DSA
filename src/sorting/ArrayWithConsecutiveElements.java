/*
Array with consecutive elements
Problem Description

Given an array of positive integers A, check and return whether the array elements are consecutive or not.
NOTE: Try this with O(1) extra space.



Problem Constraints
1 <= length of the array <= 100000
1 <= A[i] <= 10^9



Input Format
The only argument given is the integer array A.



Output Format
Return 1 if the array elements are consecutive else return 0.



Example Input
Input 1:

 A = [3, 2, 1, 4, 5]
Input 2:

 A = [1, 3, 2, 5]


Example Output
Output 1:

 1
Output 2:

 0


Example Explanation
Explanation 1:

 As you can see all the elements are consecutive, so we return 1.
Explanation 2:

 Element 4 is missing, so we return 0.
 */
package sorting;

public class ArrayWithConsecutiveElements {
    public int solve(int[] A) {
        int min = Integer.MAX_VALUE;
        int[] b = new int[A.length];
        for(int i = 0; i < A.length; i++){
            min = Math.min(A[i], min);
        }
        for(int i = 0; i < A.length; i++){
            int diff = A[i] - min;
            if(diff >= 0 && diff < A.length){
                b[diff] = A[i];
            }
        }
        // System.out.println(Arrays.toString(b));
        for(int i = 0; i < A.length - 1; i++ ){
            if((b[i+1] - b[i]) >1 || b[i] == 0) return 0;
        }

        return 1;
    }
}
