/*
Deserialize Binary Tree
Problem Description

Given an integer array A denoting the Level Order Traversal of the Binary Tree.

You have to Deserialize the given Traversal in the Binary Tree and return the root of the Binary Tree.

NOTE:

In the array, the NULL/None child is denoted by -1.
For more clarification check the Example Input.


Problem Constraints
1 <= number of nodes <= 105

-1 <= A[i] <= 105



Input Format
Only argument is an integer array A denoting the Level Order Traversal of the Binary Tree.



Output Format
Return the root node of the Binary Tree.



Example Input
Input 1:

 A = [1, 2, 3, 4, 5, -1, -1, -1, -1, -1, -1]
Input 2:

 A = [1, 2, 3, 4, 5, -1, 6, -1, -1, -1, -1, -1, -1]


Example Output
Output 1:

           1
         /   \
        2     3
       / \
      4   5
Output 2:

            1
          /   \
         2     3
        / \ .   \
       4   5 .   6


Example Explanation
Explanation 1:

 Each element of the array denotes the value of the node. If the val is -1 then it is the NULL/None child.
 Since 3, 4 and 5 each has both NULL child we had represented that using -1.
Explanation 2:

 Each element of the array denotes the value of the node. If the val is -1 then it is the NULL/None child.
 Since 3 has left child as NULL while 4 and 5 each has both NULL child.
 */
package trees;

import java.util.LinkedList;
import java.util.Queue;

public class DeserializeBinaryTree {
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
    public TreeNode solve(int[] A) {
        if(A.length == 0) return null;
        TreeNode root = new TreeNode(A[0]);
        if(A.length == 1) return root;
        Queue<TreeNode> q= new LinkedList<>();
        TreeNode temp = root;
        q.add(temp);
        for(int i = 1; i < A.length - 1 && !q.isEmpty(); i = i + 2){
            temp = q.poll();
            if(A[i] != -1){
                temp.left = new TreeNode(A[i]);
                q.add(temp.left);
            }
            if(A[i + 1] != -1){
                temp.right = new TreeNode(A[i + 1]);
                q.add(temp.right);
            }
        }
        return root;
    }
}
