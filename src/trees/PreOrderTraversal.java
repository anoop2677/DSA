/*
Preorder Traversal
Problem Description

Given a binary tree, return the preorder traversal of its nodes values.

NOTE: Using recursion is not allowed.



Problem Constraints
1 <= number of nodes <= 105



Input Format
First and only argument is root node of the binary tree, A.



Output Format
Return an integer array denoting the preorder traversal of the given binary tree.



Example Input
Input 1:

   1
    \
     2
    /
   3
Input 2:

   1
  / \
 6   2
    /
   3


Example Output
Output 1:

 [1, 2, 3]
Output 2:

 [1, 6, 2, 3]


Example Explanation
Explanation 1:

 The Preoder Traversal of the given tree is [1, 2, 3].
Explanation 2:

 The Preoder Traversal of the given tree is [1, 6, 2, 3].
 */
package trees;

import java.util.ArrayList;
import java.util.Stack;

public class PreOrderTraversal {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }
    public ArrayList<Integer> preorderTraversal(TreeNode A) {
        Stack<TreeNode> st = new Stack<>();
        st.push(A);
        ArrayList<Integer> al = new ArrayList<>();
        while (!st.isEmpty()){
            A = st.pop();
            al.add(A.val);
            if(A.right != null){
                st.push(A.right);
            }
            if(A.left != null){
                st.push(A.left);
            }
        }
        return al;
    }
}
