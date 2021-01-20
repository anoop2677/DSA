/*
Problem Description

Given a non-negative number represented as an array of digits, add 1 to the number ( increment the number represented by the digits ).

The digits are stored such that the most significant digit is at the head of the list.

NOTE: Certain things are intentionally left unclear in this question which you should practice asking the interviewer. For example: for this problem, following are some good questions to ask :

Q : Can the input have 0's before the most significant digit. Or in other words, is 0 1 2 3 a valid input?
A : For the purpose of this question, YES
Q : Can the output have 0's before the most significant digit? Or in other words, is 0 1 2 4 a valid output?
A : For the purpose of this question, NO. Even if the input has zeroes before the most significant digit.


Problem Constraints
1 <= size of the array <= 1000000



Input Format
First argument is an array of digits.



Output Format
Return the array of digits after adding one.



Example Input
Input 1:

[1, 2, 3]


Example Output
Output 1:

[1, 2, 4]


Example Explanation
Explanation 1:

Given vector is [1, 2, 3].
The returned vector should be [1, 2, 4] as 123 + 1 = 124.

 */
package OneDandTwoDArray;

import java.util.Arrays;

public class AddOneToNumber {
    public static int[] plusOne(int[] A) {
        int n = A.length;
        int carry = 1;
        int[] ans = new int[n+1];
        int j = n;
        for(int i = n - 1; i >=0 ; i--){
            int temp = A[i] + carry;
            carry = temp / 10;
            if(carry == 0){
                ans[j] = temp;
            }
            else{
                ans[j] = 0;
            }
            j--;
        }
        if(carry == 1){
            ans[0] = 1;
        }
        int k = 0;
        for(int i = 0; i <= n; i++){
            if(ans[i] != 0){
                break;
            }k++;
        }
        // System.out.println(Arrays.toString(ans)+" "+k);
        if(k > 0){
            int[] ans1 = new int[ans.length-k];
            for(int i = k; i <= n; i++){
                ans1[i-k] = ans[i];
            }
            return ans1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] x = {1,2,4};
        System.out.println(Arrays.toString(plusOne(x)));
    }
}
