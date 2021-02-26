/*
Recover Binary Search Tree
Problem Description

Two elements of a binary search tree (BST),represented by root A are swapped by mistake. Tell us the 2 values swapping which the tree will be restored.

A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?



Problem Constraints
1 <= size of tree <= 100000



Input Format
First and only argument is the head of the tree,A



Output Format
Return the 2 elements which need to be swapped.



Example Input
Input 1:


         1
        / \
       2   3
Input 2:


         2
        / \
       3   1



Example Output
Output 1:

 [2, 1]
Output 2:

 [3, 1]


Example Explanation
Explanation 1:

Swapping 1 and 2 will change the BST to be
         2
        / \
       1   3
which is a valid BST
Explanation 2:

Swapping 1 and 3 will change the BST to be
         2
        / \
       1   3
which is a valid BST
 */
package binarySearchTree;

import java.util.ArrayList;

public class RecoverBinarySearchTree {
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
    TreeNode first, middle, last, prev;
    ArrayList<Integer> ans = new ArrayList<>();
    void swapNodes(TreeNode root){
        if(root != null){
            swapNodes(root.left);
            if(prev != null && root.val < prev.val){
                if(first == null){
                    first = prev;
                    middle = root;
                }
                else last = root;
            }
            prev = root;
            swapNodes(root.right);
        }
    }
    public ArrayList<Integer> recoverTree(TreeNode A) {
        first = middle = last = prev = null;
        swapNodes(A);
        if(first != null && last != null){
            ans.add(last.val);
            ans.add(first.val);
        }
        else if(first != null && middle != null){
            ans.add(middle.val);
            ans.add(first.val);
        }
        return ans;
    }
}
