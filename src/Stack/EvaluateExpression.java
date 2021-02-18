/*
Evaluate Expression
Problem Description

An arithmetic expression is given by a charater array A of size N. Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each character may be an integer or an operator.



Problem Constraints
1 <= N <= 105



Input Format
The only argument given is character array A.



Output Format
Return the value of arithmetic expression formed using reverse Polish Notation.



Example Input
Input 1:
    A =   ["2", "1", "+", "3", "*"]
Input 2:
    A = ["4", "13", "5", "/", "+"]


Example Output
Output 1:
    9
Output 2:
    6


Example Explanation
Explaination 1:
    starting from backside:
    * : () * ()
    3 : () * (3)
    + : (() + ()) * (3)
    1 : (() + (1)) * (3)
    2 : ((2) + (1)) * (3)
    ((2) + (1)) * (3) = 9
Explaination 2:
    + : () + ()
    / : () + (() / ())
    5 : () + (() / (5))
    1 : () + ((13) / (5))
    4 : (4) + ((13) / (5))
    (4) + ((13) / (5)) = 6
 */
package Stack;

import java.util.Stack;

public class EvaluateExpression {
    boolean isOperator(String s){
        if((s.charAt(0) == '/' || s.charAt(0) == '*' || s.charAt(0) == '-' || s.charAt(0) == '+') && s.length() == 1)
            return true;
        return false;
    }
    public int evalRPN(String[] A) {
        Stack<Integer> st = new Stack<>();
        if(A.length == 1){
            return Integer.parseInt(A[0]);
        }
        for(int i = 0; i < A.length; i++){
            if(isOperator(A[i])){
                int a = st.pop();
                int b = st.pop();
                switch(A[i]){
                    case "+": st.push(a + b);break;
                    case "-": st.push(b - a);break;
                    case "*": st.push(b * a);break;
                    default: st.push(b / a);
                }
            }
            else{
                st.push(Integer.parseInt(A[i]));
            }
        }
        return st.pop();
    }
}
