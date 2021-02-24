/*
Identical Binary Trees
Problem Description

Given two binary trees, check if they are equal or not.

Two binary trees are considered equal if they are structurally identical and the nodes have the same value.



Problem Constraints
1 <= number of nodes <= 105



Input Format
First argument is a root node of first tree, A.

Second argument is a root node of second tree, B.



Output Format
Return 0 / 1 ( 0 for false, 1 for true ) for this problem.



Example Input
Input 1:

   1       1
  / \     / \
 2   3   2   3
Input 2:

   1       1
  / \     / \
 2   3   3   3


Example Output
Output 1:

 1
Output 2:

 0


Example Explanation
Explanation 1:

 Both trees are structurally identical and the nodes have the same value.
Explanation 2:

 Value of left child of the tree is different.

 */
package trees;

public class IdenticalBinaryTree {
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

    public boolean identicalTrees(TreeNode a, TreeNode b) {
        if (a == null && b == null)
            return true;

        if (a != null && b != null)
            return (a.val == b.val
                    && identicalTrees(a.left, b.left)
                    && identicalTrees(a.right, b.right));

        return false;
    }

    public int isSameTree(TreeNode A, TreeNode B) {
        if(identicalTrees(A, B)) return 1;
        return 0;
    }
}
