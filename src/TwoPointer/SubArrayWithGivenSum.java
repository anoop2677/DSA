/*
Subarray with given sum
Problem Description

Given an array of positive integers A and an integer B, find and return first continuous subarray which adds to B.

If the answer does not exist return an array with a single element "-1".

First sub-array means the sub-array for which starting index in minimum.



Problem Constraints
1 <= length of the array <= 100000
1 <= A[i] <= 109
1 <= B <= 109



Input Format
The first argument given is the integer array A.

The second argument given is integer B.



Output Format
Return the first continuous sub-array which adds to B and if the answer does not exist return an array with a single element "-1".



Example Input
Input 1:

 A = [1, 2, 3, 4, 5]
 B = 5
Input 2:

 A = [5, 10, 20, 100, 105]
 B = 110


Example Output
Output 1:

 [2, 3]
Output 2:

 -1


Example Explanation
Explanation 1:

 [2, 3] sums up to 5.
Explanation 2:

 No subarray sums up to required number.
 */
package TwoPointer;

public class SubArrayWithGivenSum {
    public int[] solve(int[] A, int B) {
        int n = A.length;
        int i = 0;
        int j = 1;
        int sum = A[0];
        while(i < A.length && j < A.length && i <= j){
            if((sum + A[j]) == B){
                int[] ans = new int[j - i + 1];
                for(int k = 0; k < j - i + 1; k++){
                    ans[k] = A[i + k];
                }
                return ans;
            }
            else if((sum + A[j]) < B){
                sum += A[j];
                j++;
            }
            else{
                sum = sum - A[i];
                i++;
            }
        }
        return new int[]{-1};
    }
}
