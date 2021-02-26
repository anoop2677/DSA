/*
Valid Binary Search Tree
Problem Description

Given a binary tree represented by root A.

Assume a BST is defined as follows:

1) The left subtree of a node contains only nodes with keys less than the node's key.

2) The right subtree of a node contains only nodes with keys greater than the node's key.

3) Both the left and right subtrees must also be binary search trees.



Problem Constraints
1 <= Number of nodes in binary tree <= 100000

0 <= node values <= 10^9



Input Format
First and only argument is head of the binary tree A.



Output Format
Return 0 if false and 1 if true.



Example Input
Input 1:


   1
  /  \
 2    3
Input 2:


  2
 / \
1   3


Example Output
Output 1:

 0
Output 2:

 1


Example Explanation
Explanation 1:

 2 is not less than 1 but is in left subtree of 1.
Explanation 2:

Satisfies all conditions.
 */
package binarySearchTree;

public class ValidBinarySearchTree {
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
    boolean isBST(TreeNode root, TreeNode l, TreeNode r) {
        if (root == null)
            return true;
        if (l != null && root.val <= l.val)
            return false;
        if (r != null && root.val >= r.val)
            return false;

        return isBST(root.left, l, root) &&
                isBST(root.right, root, r);
    }

    public int isValidBST(TreeNode A) {
        if(isBST(A, null, null)){
            return 1;
        }
        return 0;
    }
}
