/*
Redundant Braces
Problem Description

Given a string A denoting an expression. It contains the following operators '+', '-', '*', '/'.

Chech whether A has redundant braces or not.

NOTE: A will be always a valid expression.



Problem Constraints
1 <= |A| <= 105



Input Format
The only argument given is string A.



Output Format
Return 1 if A has redundant braces, else return 0.



Example Input
Input 1:

 A = "((a+b))"
Input 2:

 A = "(a+(a+b))"


Example Output
Output 1:

 1
Output 2:

 0


Example Explanation
Explanation 1:

 ((a+b)) has redundant braces so answer will be 1.
Explanation 2:

 (a+(a+b)) doesn't have have any redundant braces so answer will be 0.
 */
package Stack;

import java.util.Stack;

public class RedundantBraces {
    boolean isOperator(char a){
        if(a == '*' || a == '+' || a == '-' || a == '/'){
            return true;
        }
        return false;
    }
    public int braces(String A) {
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < A.length(); i++){
            if(A.charAt(i) == '(' || isOperator(A.charAt(i))){
                st.push(A.charAt(i));
            }
            else{
                if(A.charAt(i) == ')'){
                    if(isOperator(st.peek())){
                        st.pop();
                        st.pop();
                    }
                    else{
                        return 1;
                    }
                }
            }
        }
        return 0;
    }
}
