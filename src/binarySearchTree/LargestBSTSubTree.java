/*
Largest BST Subtree
Problem Description

Given a Binary Tree A with N nodes.

Write a function that returns the size of the largest subtree which is also a Binary Search Tree (BST).

If the complete Binary Tree is BST, then return the size of whole tree.

NOTE:

Largest subtree means subtree with most number of nodes.


Problem Constraints
1 <= N <= 105



Input Format
First and only argument is an pointer to root of the binary tree A.



Output Format
Return an single integer denoting the size of the largest subtree which is also a BST.



Example Input
Input 1:

     10
    / \
   5  15
  / \   \
 1   8   7
Input 2:

     5
    / \
   3   8
  / \ / \
 1  4 7  9


Example Output
Output 1:

 3
Output 2:

 7


Example Explanation
Explanation 1:

 Largest BST subtree is
                            5
                           / \
                          1   8
Explanation 2:

 Given binary tree itself is BST.
 */
package binarySearchTree;

public class LargestBSTSubTree {
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
    class TreeInfo{
        int height;
        boolean isBst = false;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
    }
    TreeInfo treeInfo = new TreeInfo();
    int maxBstHeight(TreeNode root, TreeInfo minRef, TreeInfo maxRef, TreeInfo maxSizeRef, TreeInfo isBstRef) {
        if (root == null) {
            isBstRef.isBst = true;
            return 0;
        }
        int min = Integer.MAX_VALUE;
        boolean left_flag = false;
        boolean right_flag = false;
        int ls, rs;
        maxRef.max = Integer.MIN_VALUE;
        ls = maxBstHeight(root.left, minRef, maxRef, maxSizeRef, isBstRef);
        if (isBstRef.isBst == true && root.val > maxRef.max) {
            left_flag = true;
        }
        min = minRef.min;
        minRef.min = Integer.MAX_VALUE;
        rs = maxBstHeight(root.right, minRef, maxRef, maxSizeRef, isBstRef);
        if (isBstRef.isBst == true && root.val < minRef.min) {
            right_flag = true;
        }
        if (min < minRef.min) {
            minRef.min = min;
        }
        if (root.val < minRef.min) {
            minRef.min = root.val;
        }
        if (root.val > maxRef.max) {
            maxRef.max = root.val;
        }
        if (left_flag && right_flag) {
            if (ls + rs + 1 > maxSizeRef.height) {
                maxSizeRef.height = ls + rs + 1;
            }
            return ls + rs + 1;
        } else {
            isBstRef.isBst = false;
            return 0;
        }
    }
    public int solve(TreeNode A) {
        maxBstHeight(A, treeInfo, treeInfo, treeInfo, treeInfo);
        return treeInfo.height;
    }
}
