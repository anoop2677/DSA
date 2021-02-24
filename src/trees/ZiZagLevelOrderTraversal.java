/*
ZigZag Level Order Traversal BT
Problem Description

Given a binary tree, return the zigzag level order traversal of its nodes values. (ie, from left to right, then right to left for the next level and alternate between).



Problem Constraints
1 <= number of nodes <= 105



Input Format
First and only argument is root node of the binary tree, A.



Output Format
Return a 2D integer array denoting the zigzag level order traversal of the given binary tree.



Example Input
Input 1:

    3
   / \
  9  20
    /  \
   15   7
Input 2:

   1
  / \
 6   2
    /
   3


Example Output
Output 1:

 [
   [3],
   [20, 9],
   [15, 7]
 ]
Output 2:

 [
   [1]
   [2, 6]
   [3]
 ]


Example Explanation
Explanation 1:

 Return the 2D array. Each row denotes the zigzag traversal of each level.
 */
package trees;

import java.util.*;

public class ZiZagLevelOrderTraversal {
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
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {
        Deque<TreeNode> q = new LinkedList<>();
        q.add(A);
        boolean flag = true;
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        while (!q.isEmpty()){
            ArrayList<Integer> temp = new ArrayList<>();
            int count = q.size();
            while (count > 0){
                TreeNode x = q.poll();
                temp.add(x.val);
                if(x.left != null)
                    q.add(x.left);
                if(x.right != null)
                    q.add(x.right);
                count--;
            }
            if(!temp.isEmpty()) {
                if (flag) {
                    al.add(temp);
                    flag = !flag;
                } else {
                    Collections.reverse(temp);
                    al.add(temp);
                    flag = !flag;
                }
            }
        }
        return al;
    }
}
