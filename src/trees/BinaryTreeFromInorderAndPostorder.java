/*
Binary Tree From Inorder And Postorder
Problem Description

Given inorder and postorder traversal of a tree, construct the binary tree.

NOTE: You may assume that duplicates do not exist in the tree.



Problem Constraints
1 <= number of nodes <= 105



Input Format
First argument is an integer array A denoting the inorder traversal of the tree.

Second argument is an integer array B denoting the postorder traversal of the tree.



Output Format
Return the root node of the binary tree.



Example Input
Input 1:

 A = [2, 1, 3]
 B = [2, 3, 1]
Input 2:

 A = [6, 1, 3, 2]
 B = [6, 3, 2, 1]


Example Output
Output 1:

   1
  / \
 2   3
Output 2:

   1
  / \
 6   2
    /
   3


Example Explanation
Explanation 1:

 Create the binary tree and return the root node of the tree.
 */
package trees;

import java.util.ArrayList;
import java.util.HashMap;

public class BinaryTreeFromInorderAndPostorder {
    static HashMap<Integer, Integer> mp = new HashMap<>();
    static int index;
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
    static TreeNode buildUtil(ArrayList<Integer> in, ArrayList<Integer> post, int inStrt, int inEnd){
        if (inStrt > inEnd)
            return null;
        int curr = post.get(index);
        TreeNode node = new TreeNode(curr);
        index--;
        if (inStrt == inEnd)
            return node;
        int iIndex = mp.get(curr);
        node.right = buildUtil(in, post, iIndex + 1, inEnd);
        node.left = buildUtil(in, post, inStrt, iIndex - 1);
        return node;
    }


    public static TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {
        if(A == null && B == null) return null;
        for(int i = 0; i < A.size(); i++){
            mp.put(A.get(i), i);
        }
        index = A.size() - 1;
        return buildUtil(A, B, 0, A.size() - 1);
    }
}
