/*
Level Order
Problem Description

Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).



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
   [9, 20],
   [15, 7]
 ]
Output 2:

 [
   [1]
   [6, 2]
   [3]
 ]


Example Explanation
Explanation 1:

 Return the 2D array. Each row denotes the traversal of each level.
 */
package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrder {
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

    public static ArrayList<ArrayList<Integer>> levelOrder(TreeNode A) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(A);
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
            if(!temp.isEmpty())
                al.add(temp);
        }
        return al;
    }
}
