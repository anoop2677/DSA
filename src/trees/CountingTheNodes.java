/*
Counting the Nodes
Problem Description

Given the root of a tree A with each node having a certain value, find the count of nodes which have more value than all its ancestor



Problem Constraints
1 <= Number of Nodes <= 200000

1 <= Value of Nodes <= 2000000000



Input Format
First and only argument of input is a tree node.



Output Format
Return a single integer denoting count of nodes which have more value than all of it's ancestor.



Example Input
Input 1:


     3
Input 2:


    4
   / \
  5   2
     / \
    3   6


Example Output
Output 1:

 1
Output 2:

 3


Example Explanation
Explanation 1:

 One node is valid
Explanation 2:

 Three nodes are 4, 5 and 6.
 */
package trees;

public class CountingTheNodes {
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
    int count = 0;
    public void countNodes(TreeNode A, int max){
        if(A == null) return;
        if(max < A.val){
            count++;
        }
        countNodes(A.left, Math.max(max, A.val));
        countNodes(A.right, Math.max(max, A.val));
    }
    public int solve(TreeNode A) {
        countNodes(A, Integer.MIN_VALUE);
        System.out.println(count);
        return count;
    }
}
