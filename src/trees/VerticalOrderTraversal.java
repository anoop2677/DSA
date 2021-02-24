/*
Vertical Order traversal
Problem Description

Given a binary tree, return a 2-D array with vertical order traversal of it. Go through the example and image for more details.


NOTE: If 2 Tree Nodes shares the same vertical level then the one with lesser depth will come first.



Problem Constraints
1 <= number of nodes <= 105



Input Format
First and only arument is a pointer to the root node of binary tree, A.



Output Format
Return a 2D array denoting the vertical order traversal of tree as shown.



Example Input
Input 1:

      6
    /   \
   3     7
  / \     \
 2   5     9
Input 2:

      1
    /   \
   3     7
  /       \
 2         9


Example Output
Output 1:

 [
    [2],
    [3],
    [6, 5],
    [7],
    [9]
 ]
Output 2:

 [
    [2],
    [3],
    [1],
    [7],
    [9]
 ]


Example Explanation
Explanation 1:

 First row represent the verical line 1 and so on.
 */
package trees;

import java.util.*;

public class VerticalOrderTraversal {
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
    public static ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(A == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        Map<Integer, ArrayList<Integer>> levelNodeMap = new HashMap<>();
        Queue<Integer> levels = new LinkedList<Integer>();

        queue.offer(A);
        levels.offer(0);
        Integer minLevel=0;
        Integer maxLevel=0;

        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            Integer level = levels.poll();
            minLevel = Math.min(level, minLevel);
            maxLevel = Math.max(maxLevel, level);

            if(!levelNodeMap.containsKey(level)){
                levelNodeMap.put(level, new ArrayList<Integer>());
            }
            levelNodeMap.get(level).add(node.val);
            if(node.left != null) {
                queue.offer(node.left);
                levels.offer(level - 1);
            }
            if(node.right != null) {
                queue.offer(node.right);
                levels.offer(level + 1);
            }
        }

        for(int level = minLevel; level <= maxLevel; ++level){
            if(levelNodeMap.containsKey(level)){
                result.add(levelNodeMap.get(level));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(9);
        ArrayList<ArrayList<Integer>> ans = verticalOrderTraversal(root);
        for(ArrayList<Integer> a : ans){
            System.out.println(Arrays.toString(a.toArray()));
        }
    }
}
