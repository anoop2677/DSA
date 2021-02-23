/*
Reorder List
Problem Description

Given a singly linked list A

 A: A0 → A1 → … → An-1 → An
reorder it to:

 A0 → An → A1 → An-1 → A2 → An-2 → …
You must do this in-place without altering the nodes' values.



Problem Constraints
1 <= |A| <= 106



Input Format
The first and the only argument of input contains a pointer to the head of the linked list A.



Output Format
Return a pointer to the head of the modified linked list.



Example Input
Input 1:

 A = [1, 2, 3, 4, 5]
Input 2:

 A = [1, 2, 3, 4]


Example Output
Output 1:

 [1, 5, 2, 4, 3]
Output 2:

 [1, 4, 2, 3]


Example Explanation
Explanation 1:

 The array will be arranged to [A0, An, A1, An-1, A2].
Explanation 2:

 The array will be arranged to [A0, An, A1, An-1, A2].
 */
package LinkedList;

public class ReorderList {
    static class ListNode {
      public int val;
      public ListNode next;
      ListNode(int x) { val = x; next = null; }
    }
    public static ListNode reverse(ListNode A) {
        if(A == null) return null;
        ListNode curr = A;
        ListNode next = null;
        ListNode prev = null;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public static ListNode reorderList(ListNode A) {
        ListNode slow = A;
        ListNode fast = A;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode node = slow.next;
        ListNode root = A;
        slow.next = null;
        node = reverse(node);
        ListNode temp2 = new ListNode(0);
        ListNode curr = temp2;
        while (root != null && node != null){
            if (root != null) {
                curr.next = root;
                curr = curr.next;
                root = root.next;
            }
            if (node != null) {
                curr.next = node;
                curr = curr.next;
                node = node.next;
            }
        }
        temp2 = temp2.next;
        return temp2;
    }

    public static void main(String[] args) {
        ListNode n = new ListNode(1);
        n.next = new ListNode(2);
        n.next.next = new ListNode(3);
        n.next.next.next = new ListNode(4);
        n.next.next.next.next = new ListNode(5);
        ListNode temp = reorderList(n);
        while(temp!=null){
            System.out.print(temp.val+" ");
            temp = temp.next;
        }
    }
}