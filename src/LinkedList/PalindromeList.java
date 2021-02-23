/*
Palindrome List
Problem Description

Given a singly linked list A, determine if its a palindrome. Return 1 or 0 denoting if its a palindrome or not, respectively.



Problem Constraints
1 <= |A| <= 105



Input Format
The first and the only argument of input contains a pointer to the head of the given linked list.



Output Format
Return 0, if the linked list is not a palindrome.

Return 1, if the linked list is a palindrome.



Example Input
Input 1:

A = [1, 2, 2, 1]
Input 2:

A = [1, 3, 2]


Example Output
Output 1:

 1
Output 2:

 0


Example Explanation
Explanation 1:

 The first linked list is a palindrome as [1, 2, 2, 1] is equal to its reversed form.
Explanation 2:

 The second linked list is not a palindrom as [1, 3, 2] is not equal to [2, 3, 1].
 */
package LinkedList;

public class PalindromeList {

      static class ListNode {
          public int val;
          public ListNode next;
          ListNode(int x) { val = x; next = null; }
      }
    static ListNode reverse(ListNode A){
          if(A == null) return null;
          ListNode curr =A;
          ListNode next = null;
          ListNode prev = null;
          while (curr != null){
              next = curr.next;
              curr.next = prev;
              prev = curr;
              curr = next;
          }
          A = prev;
          return A;
    }
    public static int lPalin(ListNode A) {
        ListNode slow = A;
        ListNode fast = A;
        if(A.next == null) return 1;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println();
        ListNode node = slow;
        slow = null;
        node = reverse(node);
        ListNode temp = A;
        while (temp != null && node != null){
            if(temp.val == node.val){
                temp = temp.next;
                node = node.next;
            }
            else {
                return 0;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(3);
        root.next.next = new ListNode(2);
//        root.next.next.next = new ListNode(1);
        System.out.println(lPalin(root));
    }
}
