/*
Binary Tree From Inorder And Preorder
Problem Description

Given preorder and inorder traversal of a tree, construct the binary tree.

NOTE: You may assume that duplicates do not exist in the tree.



Problem Constraints
1 <= number of nodes <= 105



Input Format
First argument is an integer array A denoting the preorder traversal of the tree.

Second argument is an integer array B denoting the inorder traversal of the tree.



Output Format
Return the root node of the binary tree.



Example Input
Input 1:

 A = [1, 2, 3]
 B = [2, 1, 3]
Input 2:

 A = [1, 6, 2, 3]
 B = [6, 1, 3, 2]


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

public class BinaryTreeFromInorderAndPreorder {
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
    int end = 0;

    public TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {
        if (A.size() == 0) return null;
        end = 0;
        return constructBT(B,A, 0, B.size()-1);
    }

    public TreeNode constructBT(ArrayList<Integer> A, ArrayList<Integer> B, int aStart, int aEnd) {
        if (aStart > aEnd) return null;

        if(end == B.size()) return null;
        TreeNode root = new TreeNode(B.get(end++));

        if (aStart == aEnd) return root;
        int idx = findIdx(A, aStart, aEnd, root.val);

        root.left = constructBT(A,B,aStart, idx-1);
        root.right = constructBT(A,B,idx+1, aEnd);

        return root;
    }

    public int findIdx(ArrayList<Integer> A, int start, int end, int num) {
        for (int i=start;i<=end;i++) {
            if (A.get(i) == num) return i;
        }

        return -1;
    }
}
