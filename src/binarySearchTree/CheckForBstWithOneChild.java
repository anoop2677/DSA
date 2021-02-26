/*
Check for BST with One Child
Problem Description

Given preorder traversal of a binary tree, check if it is possible that it is also a preorder traversal of a Binary Search Tree (BST), where each internal node (non-leaf nodes) have exactly one child.



Problem Constraints
1 <= number of nodes <= 100000



Input Format
First and only argument is an integer array denoting the preorder traversal of binary tree.



Output Format
Return a string "YES" if true else "NO".



Example Input
Input 1:

 A : [4, 10, 5, 8]
Input 2:

 A : [1, 5, 6, 4]


Example Output
Output 1:

 "YES"
Output 2:

 "NO"


Example Explanation
Explanation 1:

 The possible BST is:
            4
             \
             10
             /
             5
              \
              8
Explanation 2:

 There is no possible BST which have the above preorder traversal.
 */
package binarySearchTree;

import java.util.ArrayList;

public class CheckForBstWithOneChild {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
            left=null;
            right=null;
        }
    }
    public String solve(ArrayList<Integer> A) {
        int max= Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        if(A.size() <= 1) return "YES";
        for (int i = 0; i < A.size() - 1; i++){
            if(min > A.get(i) || A.get(i) > max){
                return "NO";
            }
            else{
                if(A.get(i) < A.get(i + 1)){
                    min = A.get(i);
                }
                else{
                    max = A.get(i);
                }
            }
        }
        if(min > A.get(A.size() - 1) || A.get(A.size() - 1) > max){
            return "NO";
        }
        return "YES";
    }
}
