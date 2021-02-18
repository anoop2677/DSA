/*
Infix to Postfix
Problem Description

Given string A denoting an infix expression. Convert the infix expression into postfix expression.

String A consists of ^, /, *, +, -, (, ) and lowercase english alphabets where lowercase english alphabets are operands and ^, /, *, +, - are operators.

Find and return the postfix expression of A.

NOTE:

^ has highest precedence.
/ and * have equal precedence but greater than + and -.
+ and - have equal precedence and lowest precedence among given operators.


Problem Constraints
1 <= length of the string <= 500000



Input Format
The only argument given is string A.



Output Format
Return a string denoting the postfix conversion of A.



Example Input
Input 2:

 A = "a+b*(c^d-e)^(f+g*h)-i"


Example Output
        Output 2:

        "abcd^e-fgh*+^*+i-"


        Example Explanation
        Explanation 1:

        Ouput dentotes the postfix expression of the given input.
 */
package Stack;

import java.util.Stack;

public class InfixToPostfix {
    static int priority(char x){
        switch (x){
            case '+' : case '-': return 0;
            case '/': case '*': return 1;
            default: return 2;
        }
    }
    public static String solve(String A) {
        Stack<Character> st = new Stack<>();
        Stack<String> st1 = new Stack<>();
        A = '(' + A + ')';
        String ans = "";
        for(int i = 0; i < A.length(); i++){
            if(A.charAt(i) >= 'a' && A.charAt(i) <= 'z'){
                st1.push(""+A.charAt(i));
            }
            else if(A.charAt(i) == '('){
                st.push('(');
            }
            else if(A.charAt(i) == ')'){
                while(st.peek() != '('){
                    char x = st.pop();
                    String op1 = st1.pop();
                    String op2 = st1.pop();
                    ans = op2 + op1 + x;
                    st1.push(ans);
                }
                st.pop();
            }
            else{
                if((priority(A.charAt(i)) > priority(st.peek())) || st.peek() == '('){
                    st.push(A.charAt(i));
                }
                else{
                    while (st.peek() != '(' && priority(A.charAt(i)) <= priority(st.peek())){
                        char x = st.pop();
                        String op1 = st1.pop();
                        String op2 = st1.pop();
                        ans = op2 + op1 + x;
                        st1.push(ans);
                    }
                    st.push(A.charAt(i));
                }
            }
        }
        return st1.pop();
    }

    public static void main(String[] args) {
        String s= "q+(c*t)*o+(g*g)+q*(i-a)*p-(i*l)";
        System.out.println(solve(s));
    }
}
