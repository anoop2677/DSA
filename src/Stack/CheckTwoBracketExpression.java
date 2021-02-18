/*
Check two bracket expressions
Problem Description

Given two strings A and B. Each string represents an expression consisting of lowercase english alphabets, '+', '-', '(' and ')'.

The task is to compare them and check if they are similar. If they are similar return 1 else return 0.

NOTE: It may be assumed that there are at most 26 operands from ‘a’ to ‘z’ and every operand appears only once.



Problem Constraints
1 <= length of the each String <= 100



Input Format
The arguments given are string A and String B.



Output Format
Return 1 if they represent the same expression else return 0.



Example Input
Input 1:

 A = "-(a+b+c)"
 B = "-a-b-c"
Input 2:

 A = "a-b-(c-d)"
 B = "a-b-c-d"


Example Output
Output 1:

 1
Output 2:

 0


Example Explanation
Explanation 1:

 The expression "-(a+b+c)" can be written as "-a-b-c" which is equal as B.
Explanation 2:

 Both the expression are different.
 */
package Stack;

import java.util.Stack;

public class CheckTwoBracketExpression {
    static int[] ans = new int[26];
    static boolean adjSign(String s, int i){
        if(i == 0){
            return true;
        }

        if(s.charAt(i - 1) == '-'){
            return false;
        }

        return true;
    };
    static void evaluateExpression(String A, boolean cond){
        Stack<Boolean> st = new Stack<>();
        st.push(true);
        for(int i = 0; i < A.length(); i++){
            if(A.charAt(i) == '+' || A.charAt(i) == '-'){
                continue;
            }
            if(A.charAt(i) == '('){
                if(adjSign(A, i)){
                    st.push(st.peek());
                }

                else{
                    st.push(!st.peek());
                }
            }
            else if(A.charAt(i) == ')'){
                st.pop();
            }
            else{
                if(st.peek()){
                    ans[A.charAt(i) - 'a'] += (adjSign(A, i) ? cond ? 1 : -1 : cond ? -1 : 1);
                }
                else {
                    ans[A.charAt(i) - 'a'] += (adjSign(A, i) ? cond ? -1 : 1 : cond ? 1 : -1);
                }
            }
        }
    }
    public static int solve(String A, String B) {
        evaluateExpression(A, true);
        evaluateExpression(B, false);
        for(int i = 0; i < 26; i++){
            if(ans[i] != 0){
                return 0;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        String a = "-(a-(-z-(b-(c+t)-x)+l)-q)";
        String b = "-a+l-b-(z-(c+t)-x-q)";
        System.out.println(solve(a, b));
    }
}
